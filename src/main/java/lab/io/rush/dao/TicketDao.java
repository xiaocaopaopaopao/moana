package lab.io.rush.dao;

import lab.io.rush.model.Ticket;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;

/**
 * 票务服务数据层接口
 * @author cqy
 * @data 2017年1月6日 上午11:17:30
 */
public interface TicketDao {
	
	/**
	 * 获得余票数量
	 * @param tid 电影票编号
	 * @return 余票数量
	 */
	@Cacheable(value = "TicketNum", key = "'TicketNum-id:'+#tid")
	int getTicketNum(String tid);
	
    /**
     * 根据电影票编号查找电影票对象
     * @param tid 电影票编号
     * @return 电影票对象
     */
	@Cacheable(value = "Ticket", key = "'Ticket-id:'+#tid")
	Ticket selectById(String tid);
	
	/**
	 * 更新电影票信息
	 * @param ticket 电影票对象
	 * @return
	 */
	 @Caching(evict = {
			 @CacheEvict(value = "Ticket", key = "'Ticket-id:'+#ticket.tid", beforeInvocation = true),
			 @CacheEvict(value = "TicketNum", key = "'TicketNum-id:'+#ticket.tid", beforeInvocation = true)
	 })
	boolean update(Ticket ticket);
}
