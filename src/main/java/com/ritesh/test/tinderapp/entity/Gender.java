package com.ritesh.test.tinderapp.entity;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Gender {
	@Id
	private Integer id;
	private String name;
	
	public Gender() {
		
		
	}
	
	public Gender(Integer id) {
		this.id = id;		
	}
	
	public Gender(Integer id, String name) {
		this.id = id;
		this.name = name;		
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
