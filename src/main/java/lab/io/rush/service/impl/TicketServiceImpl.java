package lab.io.rush.service.impl;

import lab.io.rush.dao.TicketDao;
import lab.io.rush.model.Ticket;
import lab.io.rush.service.TicketService;

import org.springframework.beans.factory.annotation.Autowired;

public class TicketServiceImpl implements TicketService{
	
	@Autowired
	private TicketDao ticketDao;
	
	public void setTicketDao(TicketDao ticketDao) {
		this.ticketDao = ticketDao;
	}

	@Override
	public boolean buyTicket(Integer num) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public int getNumOfLastTickets(int id) {
		int num = ticketDao.getNumOfLastTicketsFromCache(id);
		if(num == -1){
			num = ticketDao.getNumOfLastTicketsFromDB(id);
			//²âÊÔ£¬¼ÇµÃÐÞ¸Ä
			Ticket ticket= new Ticket();
			ticket.setId(0);
			ticket.setNumber(num);
			boolean flag = ticketDao.addNumOfLastTickets2Cache(ticket);
			System.out.println(flag);
		}
		return num;
	}
}
