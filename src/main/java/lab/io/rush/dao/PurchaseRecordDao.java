package lab.io.rush.dao;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import lab.io.rush.model.PurchaseRecord;

/**
 * �����¼���ݲ�ӿ�
 * @author cqy
 * @data 2017��1��6�� ����11:22:47
 */
public interface PurchaseRecordDao {

	/**
	 * ���빺���¼
	 * @param purchaseRecord �����¼����
	 * @return ������
	 */
	@CacheEvict(value = "TicketNumPurchased", 
			key = "'TicketNumPurchased-uid-tid:'+#purchaseRecord.uid+'-'+#purchaseRecord.tid",
			beforeInvocation = true)
	boolean insert(PurchaseRecord purchaseRecord);

	/**
	 * �����û������Ʊ��Ż���û��ѹ�������
	 * @param uid �û����
	 * @param tid ��ӰƱ���
	 * @return �ѹ���Ʊ����
	 */
	@Cacheable(value = "TicketNumPurchased", 
			key = "'TicketNumPurchased-uid-tid:'+#uid+'-'+#tid")
	int getTicketNumPurchasedByUidAndTid(String uid, String tid);
}
