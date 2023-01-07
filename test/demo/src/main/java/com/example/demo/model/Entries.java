package com.example.demo.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
@Entity
public class Entries {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;
	
	private Integer count;
	
	@ElementCollection
	@Embedded
	@JoinTable(name = "entry_data", joinColumns = @JoinColumn(name = "eId"))
	private List<Data> entries;

	public Entries() {
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
