package test;

import java.time.LocalDateTime;

public class User {
	private String name;
	
	private final LocalDateTime date = LocalDateTime.now();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getDate() {
		return date;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", date=" + date + "]";
	}
	
	
}
