package lab.io.rush.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * 购票记录模型
 * @author cqy
 * @data 2017年1月6日 上午11:28:45
 */
@PersistenceCapable(table = "purchase_record")
public class PurchaseRecord implements Serializable{
	
	private static final long serialVersionUID = -8582988190067187109L;
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.UUIDHEX)
	private String id;
	
	@Persistent
	private String uid;
	
	@Persistent
	private String tid;
	
	@Persistent
	private int num;
	
	@Persistent
	private Timestamp purchaseTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Timestamp getPurchaseTime() {
		return purchaseTime;
	}

	public void setPurchaseTime(Timestamp purchaseTime) {
		this.purchaseTime = purchaseTime;
	}

}
