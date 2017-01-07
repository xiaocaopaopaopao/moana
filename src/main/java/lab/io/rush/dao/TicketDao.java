package lab.io.rush.dao;

import lab.io.rush.model.Ticket;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;

/**
 * Ʊ��������ݲ�ӿ�
 * @author cqy
 * @data 2017��1��6�� ����11:17:30
 */
public interface TicketDao {
	
	/**
	 * �����Ʊ����
	 * @param tid ��ӰƱ���
	 * @return ��Ʊ����
	 */
	@Cacheable(value = "TicketNum", key = "'TicketNum-id:'+#tid")
	int getTicketNum(String tid);
	
    /**
     * ���ݵ�ӰƱ��Ų��ҵ�ӰƱ����
     * @param tid ��ӰƱ���
     * @return ��ӰƱ����
     */
	@Cacheable(value = "Ticket", key = "'Ticket-id:'+#tid")
	Ticket selectById(String tid);
	
	/**
	 * ���µ�ӰƱ��Ϣ
	 * @param ticket ��ӰƱ����
	 * @return
	 */
	 @Caching(evict = {
			 @CacheEvict(value = "Ticket", key = "'Ticket-id:'+#ticket.tid", beforeInvocation = true),
			 @CacheEvict(value = "TicketNum", key = "'TicketNum-id:'+#ticket.tid", beforeInvocation = true)
	 })
	boolean update(Ticket ticket);
}
