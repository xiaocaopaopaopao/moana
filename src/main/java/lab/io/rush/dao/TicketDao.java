package lab.io.rush.dao;

import lab.io.rush.model.Ticket;

public interface TicketDao {
	
	int getTicketNum(String tid);
	
	Ticket selectById(String tid);
	
	boolean update(Ticket ticket);
}
