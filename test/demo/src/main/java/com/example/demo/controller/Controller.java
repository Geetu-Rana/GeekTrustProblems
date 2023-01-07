package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Data;
import com.example.demo.model.DataDto;
import com.example.demo.model.Entries;
import com.example.demo.service.service;

@RestController
public class Controller {
	
	private service ser;
	
	@Autowired
	public Controller(service serv) {
		// TODO Auto-generated constructor stub
		this.ser = serv;
	}
	
	@GetMapping("/")
	public ResponseEntity<Entries> getAlldata(){
		Entries et = ser.consumeApi();
		return new ResponseEntity<Entries>(et, HttpStatus.OK);
	}
	
	@GetMapping("entries/{category}")
	public ResponseEntity<List<DataDto>> getCategoryTitleDes(@PathVariable("category") String cat){
		
		List<DataDto> list = ser.getAllDataByCategory(cat);
		
		return new ResponseEntity<List<DataDto>>(list, HttpStatus.OK);
		
	}
	
	@PostMapping("/entries")
	public ResponseEntity<String> saveData(@RequestBody Data data){
		
		String res = ser.saveData(data);
		return new ResponseEntity<String>(res, HttpStatus.ACCEPTED);
	}
	
}
