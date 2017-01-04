package lab.io.rush.dao;

import lab.io.rush.model.Ticket;

public interface TicketDao {
	
	public boolean addNumOfLastTickets2Cache(Ticket ticket);
	
    public Integer getNumOfLastTicketsFromDB(int id);
    
    public Integer getNumOfLastTicketsFromCache(int id);
    
    public boolean updateNumOfLastTickets2Cache(Ticket ticket);
    
    public boolean syncFromDB2Cache();
    
    public boolean syncFromCache2DB();
	
	public boolean buyTicket(Integer num);
}
