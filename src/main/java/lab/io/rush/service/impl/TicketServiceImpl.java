package lab.io.rush.service.impl;

import java.sql.Timestamp;
import java.util.Date;

import lab.io.rush.dao.PurchaseRecordDao;
import lab.io.rush.dao.TicketDao;
import lab.io.rush.dao.UserDao;
import lab.io.rush.dto.PurchaseStatusDto;
import lab.io.rush.dto.PurchaseStatusEnum;
import lab.io.rush.model.PurchaseRecord;
import lab.io.rush.model.Ticket;
import lab.io.rush.model.User;
import lab.io.rush.service.EmailService;
import lab.io.rush.service.TicketService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * 票务服务接口实现类
 * @author cqy
 * @data 2017年1月6日 上午11:45:12
 */
@Transactional
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketDao ticketDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private PurchaseRecordDao purchaseRecordDao;
	@Autowired
	private EmailService emailService;

	@Override
	public int getTicketNum(String tid) {
		return ticketDao.getTicketNum(tid);
	}

	@Override
	public PurchaseStatusDto snapMovieTicket(String uid, String tid, int num) {

		Ticket ticket = ticketDao.selectById(tid);
		User user = userDao.selectById(uid);
		int t_num = ticket.getNum(); // 余票数量
		int p_num = purchaseRecordDao
				.getTicketNumPurchasedByUidAndTid(uid, tid); // 该用户已购买该电影票数量

		// 购买票数超出定额
		if (p_num + num > 2)
			return new PurchaseStatusDto(PurchaseStatusEnum.MORE_THAN_NUM);
		// 库存不足
		if (t_num < num)
			return new PurchaseStatusDto(PurchaseStatusEnum.NOT_ENOUGH);

		// 插入购买记录
		PurchaseRecord purchaseRecord = new PurchaseRecord();
		purchaseRecord.setUid(uid);
		purchaseRecord.setTid(tid);
		purchaseRecord.setNum(num);
		Timestamp timestamp = new Timestamp(new Date().getTime());
		purchaseRecord.setPurchaseTime(timestamp);
		purchaseRecordDao.insert(purchaseRecord);

		// 更新电影票数量
		ticket.setNum(ticket.getNum() - num);
		ticketDao.update(ticket);

		// 邮件通知
		String content = "Congratulations, you got %s Avatar2 movie ticket(s) at %s, hava a good time!";
		content = String.format(content, num,timestamp.toString());
		emailService.sendEmail(user.getEmail(), "Congratulations", content);

		return new PurchaseStatusDto(PurchaseStatusEnum.SUCCESS);
	}
}
