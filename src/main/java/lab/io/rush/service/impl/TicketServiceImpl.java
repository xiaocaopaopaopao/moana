package lab.io.rush.service.impl;

import java.sql.Timestamp;
import java.util.Date;

import lab.io.rush.dao.PurchaseRecordDao;
import lab.io.rush.dao.TicketDao;
import lab.io.rush.model.PurchaseRecord;
import lab.io.rush.model.Ticket;
import lab.io.rush.service.TicketService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketDao ticketDao;
	@Autowired
	private PurchaseRecordDao purchaseRecordDao;

	@Override
	public int getTicketNum(String tid) {
		return ticketDao.getTicketNum(tid);
	}

	@Override
	public boolean snapMovieTicket(String uid, String tid, int num) {

		Ticket ticket = ticketDao.selectById(tid);
		int t_num = ticket.getNum(); // 余票数量
		int p_num = purchaseRecordDao
				.getTicketNumPurchasedByUidAndTid(uid, tid); // 该用户已购买该电影票数量

		// 判断是否符合抢购条件
		if (p_num == -1 || p_num + num > 2 || t_num < num)
			return false;

		// 插入购买记录
		PurchaseRecord purchaseRecord = new PurchaseRecord();
		purchaseRecord.setUid(uid);
		purchaseRecord.setTid(tid);
		purchaseRecord.setNum(num);
		purchaseRecord.setPurchaseTime(new Timestamp(new Date().getTime()));
		purchaseRecordDao.insert(purchaseRecord);
		
		// 更新电影票数量
		ticket.setNum(ticket.getNum() - num);

		return true;
	}
}
