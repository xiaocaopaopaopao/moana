package lab.io.rush.service;

public interface TicketService {
	
	int getNumOfLastTickets(int id);
	
	boolean buyTicket(Integer num);
}
