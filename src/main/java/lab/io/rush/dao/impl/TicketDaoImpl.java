package lab.io.rush.dao.impl;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;

import lab.io.rush.dao.TicketDao;
import lab.io.rush.model.Ticket;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 票务服务持久层接口实现类
 * @author cqy
 * @data 2017年1月6日 下午2:20:53
 */
public class TicketDaoImpl implements TicketDao {

	@Autowired
	private PersistenceManagerFactory persistenceManagerFactory;

	@Override
	public int getTicketNum(String tid) {
		Ticket ticket = selectById(tid);
		if(ticket != null)
			return ticket.getNum();
		else
			return -1;
	}

	@Override
	public Ticket selectById(String tid) {
		PersistenceManager pm = persistenceManagerFactory
				.getPersistenceManager();
		Ticket ticket = null;
		Query<?> q = pm.newQuery(Ticket.class, "tid =='" + tid + "'");
		@SuppressWarnings("unchecked")
		List<Ticket> tickets = (List<Ticket>) q.execute();
		if (tickets != null && !tickets.isEmpty())
			ticket = tickets.get(0);
		return ticket;
	}

	@Override
	public boolean update(Ticket ticket) {
		return true;
	}

}
