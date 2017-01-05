package lab.io.rush.service;

import lab.io.rush.dto.PurchaseStatusDto;

public interface TicketService {

	int getTicketNum(String tid);

	PurchaseStatusDto snapMovieTicket(String uid, String tid, int num);
}
