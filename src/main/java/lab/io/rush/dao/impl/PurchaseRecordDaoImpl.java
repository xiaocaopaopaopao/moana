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
		PurchaseRecord record = pm.makePersistent(purchaseRecord);
		boolean result = false;
		if (record != null)
			result = true;
		return result;
	}

	@Override
	public int getTicketNumPurchasedByUidAndTid(String uid, String tid) {
		PersistenceManager pm = persistenceManagerFactory
				.getPersistenceManager();
		Query<?> q = pm.newQuery(PurchaseRecord.class, "uid =='" + uid
				+ "'&& tid == '" + tid + "'");
		@SuppressWarnings("unchecked")
		List<PurchaseRecord> records = (List<PurchaseRecord>) q.execute();
		int num = 0;
		if (records != null) {
			for (PurchaseRecord r : records) {
				num += r.getNum();
			}
		}
		return num;
	}
}
