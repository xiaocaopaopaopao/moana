package lab.io.rush.service;

import lab.io.rush.dto.PurchaseStatusDto;

/**
 * 票务服务接口
 * @author cqy
 * @data 2017年1月6日 上午11:06:55
 */
public interface TicketService {

	/**
	 * 获得余票数量
	 * @param tid 电影票编号
	 * @return 余票数量
	 */
	int getTicketNum(String tid);

	/**
	 * 购票方法
	 * @param uid 用户编号
	 * @param tid 电影票编号
	 * @param num 购买数量
	 * @return 购买状态
	 */
	PurchaseStatusDto snapMovieTicket(String uid, String tid, int num);
}
