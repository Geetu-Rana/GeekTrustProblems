package com.example.demo.model;

import java.util.List;

public class Entries {
	
	private Integer count;
	
	private List<Data> entries;

	public Entries(List<Data> entries) {
		super();
		this.entries = entries;
	}

	public Entries(Integer count, List<Data> entries) {
		super();
		this.count = count;
		this.entries = entries;
	}

	public Entries() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public List<Data> getEntries() {
		return entries;
	}

	public void setEntries(List<Data> entries) {
		this.entries = entries;
	}
	
	
}
