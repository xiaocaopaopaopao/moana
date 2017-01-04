package lab.io.rush.model;

import java.io.Serializable;

public class Ticket implements Serializable{
	
	private static final long serialVersionUID = 4348481269232349611L;
	private Integer id;
	private String name;
	private Integer number;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}
}
