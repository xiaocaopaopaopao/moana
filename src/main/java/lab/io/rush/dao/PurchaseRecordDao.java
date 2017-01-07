package lab.io.rush.dao;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import lab.io.rush.model.PurchaseRecord;

/**
 * 购买记录数据层接口
 * @author cqy
 * @data 2017年1月6日 上午11:22:47
 */
public interface PurchaseRecordDao {

	/**
	 * 插入购买记录
	 * @param purchaseRecord 购买记录对象
	 * @return 插入结果
	 */
	@CacheEvict(value = "TicketNumPurchased", 
			key = "'TicketNumPurchased-uid-tid:'+#purchaseRecord.uid+'-'+#purchaseRecord.tid",
			beforeInvocation = true)
	boolean insert(PurchaseRecord purchaseRecord);

	/**
	 * 根据用户编号与票编号获得用户已购买数量
	 * @param uid 用户编号
	 * @param tid 电影票编号
	 * @return 已购买票数量
	 */
	@Cacheable(value = "TicketNumPurchased", 
			key = "'TicketNumPurchased-uid-tid:'+#uid+'-'+#tid")
	int getTicketNumPurchasedByUidAndTid(String uid, String tid);
}
