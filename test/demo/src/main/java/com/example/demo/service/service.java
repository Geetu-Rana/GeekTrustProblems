package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Data;
import com.example.demo.model.DataDto;
import com.example.demo.model.Entries;
import com.example.demo.repository.EntriesRepository;
@Service
public class service {
	
	@Autowired
	private RestTemplate template;
	
	private Boolean flag;
	
	@Autowired
	private EntriesRepository eRepo;
	
	@Autowired
	public service( RestTemplate template) {
		// TODO Auto-generated constructor stub
		this.template = template;
				
	}
	
	public Entries consumeApi() {

		Entries entries = template.getForObject("https://api.publicapis.org/entries", Entries.class);
		return entries;
		
	}
	
	public List<DataDto> getAllDataByCategory(String category){
		
		List<DataDto> list = new ArrayList<>();
		Entries entries = template.getForObject("https://api.publicapis.org/entries", Entries.class);
		
		for(Data d : entries.getEntries()) {
			
			String[] arr = d.getCategory().split(" ");
			String c = arr[0].trim();
			if(c.equalsIgnoreCase(category)) {
				list.add(new DataDto(d.getApi(), d.getDescription()));
			}
		}
		
		return list;
	}
	
	public String saveData(Data data){
		List<Entries> entries = eRepo.findAll();
		if(entries.isEmpty()) {
			Entries en = template.getForObject("https://api.publicapis.org/entries", Entries.class);
			en.getEntries().add(data);
			eRepo.save(en);
			return "Count of saved data is " + en.getEntries().size();
		}else {
			Entries entry = eRepo.findAll().get(0);
			entry.getEntries().add(data);
			eRepo.save(entry);
			return "Count of saved data is " + entry.getEntries().size();
		}
		
		
		
	}
	
}
