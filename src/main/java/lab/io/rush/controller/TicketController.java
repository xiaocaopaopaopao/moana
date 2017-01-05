package lab.io.rush.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lab.io.rush.dto.PurchaseStatusDto;
import lab.io.rush.dto.PurchaseStatusEnum;
import lab.io.rush.model.User;
import lab.io.rush.service.TicketService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

@Controller
@RequestMapping("/ticket")
public class TicketController extends MultiActionController {

	@Autowired
	private TicketService ticketService;

	public void setTicketService(TicketService ticketService) {
		this.ticketService = ticketService;
	}

	@RequestMapping(value = { "/getTicketNum.do" }, method = { RequestMethod.GET })
	private void getTicketNum(HttpServletResponse response,
			@RequestParam("tid") String tid) {
		try {
			int num = ticketService.getTicketNum(tid);
			response.getWriter().write(String.valueOf(num));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = { "/purchaseTicket.do" }, method = { RequestMethod.GET })
	private void purchaseTicket(HttpSession session,HttpServletResponse response,
			@RequestParam("tid") String tid, @RequestParam("num") int num) {
		PurchaseStatusDto  purchaseStatusDto = null;
		PrintWriter out = null;
		try {
			User user = (User)session.getAttribute("user");
			String uid = user.getUid();
			purchaseStatusDto = ticketService.snapMovieTicket(uid, tid, num);
		} catch (Exception e) {
			purchaseStatusDto = new PurchaseStatusDto(PurchaseStatusEnum.PURCHASE_FAIL);
		}
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		try {
			out = response.getWriter();
			out.write(purchaseStatusDto.toJson().toString());
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			if(out != null)
				out.close();
		}
	}
}
