package lab.io.rush.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import lab.io.rush.service.TicketService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

@Controller
@RequestMapping("/ticket")
public class TicketController extends MultiActionController{
	
	@Autowired
	private TicketService ticketService;
	
	public void setTicketService(TicketService ticketService) {
		this.ticketService = ticketService;
	}
	
	@RequestMapping(value = { "/getNumOfTicket.do" }, method = { RequestMethod.GET })
	private void getNumOfLastTicket(HttpServletResponse response,@RequestParam("id")String id) {
		System.out.println("1111");
		int num = ticketService.getNumOfLastTickets(Integer.valueOf(id));
		try {
			response.getWriter().write(String.valueOf(num));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
