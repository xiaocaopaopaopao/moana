package lab.io.rush.model;

import java.io.Serializable;
import java.sql.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * 电影票模型
 * @author cqy
 * @data 2017年1月6日 上午11:28:27
 */
@PersistenceCapable(table = "ticket")
public class Ticket implements Serializable{
	
	private static final long serialVersionUID = -8529724637964460339L;
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.UUIDHEX)
	private String tid;
	
	@Persistent
	private String name;
	
	@Persistent
	private int num;
	
	@Persistent
	private Date onlineDate;

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Date getOnlineDate() {
		return onlineDate;
	}

	public void setOnlineDate(Date onlineDate) {
		this.onlineDate = onlineDate;
	}
}
