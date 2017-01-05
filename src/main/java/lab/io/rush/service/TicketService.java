package lab.io.rush.service;

public interface TicketService {

	int getTicketNum(String tid);

	boolean snapMovieTicket(String uid, String tid, int num);
}
