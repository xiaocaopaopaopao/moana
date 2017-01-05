package lab.io.rush.dao;

import lab.io.rush.model.PurchaseRecord;

public interface PurchaseRecordDao {

	boolean insert(PurchaseRecord purchaseRecord);

	int getTicketNumPurchasedByUidAndTid(String uid, String tid);
}
