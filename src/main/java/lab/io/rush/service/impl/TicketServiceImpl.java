package lab.io.rush.service.impl;

import java.sql.Timestamp;
import java.util.Date;

import lab.io.rush.dao.PurchaseRecordDao;
import lab.io.rush.dao.TicketDao;
import lab.io.rush.dto.PurchaseStatusDto;
import lab.io.rush.dto.PurchaseStatusEnum;
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
	public PurchaseStatusDto snapMovieTicket(String uid, String tid, int num) {

		Ticket ticket = ticketDao.selectById(tid);
		int t_num = ticket.getNum(); // ��Ʊ����
		int p_num = purchaseRecordDao
				.getTicketNumPurchasedByUidAndTid(uid, tid); // ���û��ѹ���õ�ӰƱ����

		//����Ʊ����������
		if (p_num + num > 2)
			return new PurchaseStatusDto(PurchaseStatusEnum.MORE_THAN_NUM);
		// ��治��
		if (t_num < num)
			return new PurchaseStatusDto(PurchaseStatusEnum.NOT_ENOUGH);

		// ���빺���¼
		PurchaseRecord purchaseRecord = new PurchaseRecord();
		purchaseRecord.setUid(uid);
		purchaseRecord.setTid(tid);
		purchaseRecord.setNum(num);
		purchaseRecord.setPurchaseTime(new Timestamp(new Date().getTime()));
		purchaseRecordDao.insert(purchaseRecord);

		// ���µ�ӰƱ����
		ticket.setNum(ticket.getNum() - num);

		return new PurchaseStatusDto(PurchaseStatusEnum.SUCCESS);
	}
}
