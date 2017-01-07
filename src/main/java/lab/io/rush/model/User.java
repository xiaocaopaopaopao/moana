package lab.io.rush.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * 用户模型
 * @author cqy
 * @data 2017年1月6日 上午11:27:17
 */
@PersistenceCapable(table="user")
public class User implements Serializable{
	
	private static final long serialVersionUID = 8945791775894037015L;
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.UUIDHEX)
	private String uid;
	
	@Persistent
	private String username;
	
	@Persistent
	private String password;
	
	@Persistent
	private String email;
	
	@Persistent
	private Timestamp registerTime;
	
	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Timestamp registerTime) {
		this.registerTime = registerTime;
	}
}
