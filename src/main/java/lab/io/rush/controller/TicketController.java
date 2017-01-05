package lab.io.rush.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lab.io.rush.model.User;
import lab.io.rush.service.TicketService;
import lab.io.rush.util.StaticVar;

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
		PrintWriter out = null;
		try {
			User user = (User)session.getAttribute("user");
			String uid = user.getUid();
			boolean isPurchaseSuccess = ticketService.snapMovieTicket(uid, tid, num);
			out=response.getWriter();
			if(isPurchaseSuccess)
				out.write(StaticVar.PurchaseSucces);
			else
				out.write(StaticVar.PurchaseFailed);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(out != null)
				out.close();
		}
	}
}
