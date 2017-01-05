package lab.io.rush.dao.impl;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;

import lab.io.rush.dao.PurchaseRecordDao;
import lab.io.rush.model.PurchaseRecord;

import org.springframework.beans.factory.annotation.Autowired;

public class PurchaseRecordDaoImpl implements PurchaseRecordDao {

	@Autowired
	private PersistenceManagerFactory persistenceManagerFactory;

	@Override
	public boolean insert(PurchaseRecord purchaseRecord) {
		PersistenceManager pm = persistenceManagerFactory
				.getPersistenceManager();
		boolean result = false;
		PurchaseRecord record = pm.makePersistent(purchaseRecord);
		if (record != null)
			result = true;
		return result;
	}

	@Override
	public int getTicketNumPurchasedByUidAndTid(String uid, String tid) {
		PersistenceManager pm = persistenceManagerFactory
				.getPersistenceManager();
		int num = -1;
		Query<?> q = pm.newQuery(PurchaseRecord.class, "uid =='" + uid
				+ "'&& tid == '" + tid + "'");
		@SuppressWarnings("unchecked")
		List<PurchaseRecord> records = (List<PurchaseRecord>) q.execute();
		if (records != null) {
			num = 0;
			for (PurchaseRecord r : records) {
				num += r.getNum();
			}
		}
		return num;
	}
}
