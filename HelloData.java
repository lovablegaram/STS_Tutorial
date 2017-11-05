package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class HelloData {
	
	@Id
	private 	int id;
	public HelloData() {
		
	}
	public HelloData(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
