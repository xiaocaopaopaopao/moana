package lab.io.rush.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lab.io.rush.dto.PurchaseStatusDto;
import lab.io.rush.dto.PurchaseStatusEnum;
import lab.io.rush.model.User;
import lab.io.rush.service.TicketService;
import lab.io.rush.util.ResponseHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

/**
 * 用户服务Web接口
 * 
 * @author cqy
 * @data 2017年1月6日 上午11:29:39
 */
@Controller
@RequestMapping("/ticket")
public class TicketController extends MultiActionController {

	@Autowired
	private TicketService ticketService;

	/**
	 * 查询余票接口
	 * @param tid 电影票编号
	 */
	@RequestMapping(value = { "/getTicketNum.do" }, method = { RequestMethod.GET })
	private void getTicketNum(HttpServletResponse response,
			@RequestParam("tid") String tid) {
		try {
			int num = ticketService.getTicketNum(tid);
			new ResponseHelper().send(response, String.valueOf(num));
		} catch (Exception e) {
			e.printStackTrace();
		}
	    
	}

	/**
	 * 购票接口
	 * @param session 当前session对象
	 * @param tid 电影票编号
	 * @param num 电影票数量
	 */
	@RequestMapping(value = { "/purchaseTicket.do" }, method = { RequestMethod.GET })
	private void purchaseTicket(HttpSession session,
			HttpServletResponse response, @RequestParam("tid") String tid,
			@RequestParam("num") int num) {
		PurchaseStatusDto purchaseStatusDto = null;
		try {
			User user = (User) session.getAttribute("user");
			String uid = user.getUid();
			purchaseStatusDto = ticketService.snapMovieTicket(uid, tid, num);
		} catch (Exception e) {
			if (purchaseStatusDto == null)
				purchaseStatusDto = new PurchaseStatusDto(
						PurchaseStatusEnum.PURCHASE_ERROR);
			e.printStackTrace();
		}
		//返回
		new ResponseHelper().send(response, purchaseStatusDto);
	}
}
