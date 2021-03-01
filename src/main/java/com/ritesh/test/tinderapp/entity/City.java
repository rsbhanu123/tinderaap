package com.ritesh.test.tinderapp.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class City {
	
	@Id
	private Integer id;
	private String name;
	
	@OneToOne
	private State state;
	
	public City() {
		
	}
	
	public City(Integer id) {
		this.id = id;
	}
	
	public City(Integer id,String name , State state) {
		this.id = id;
		this.name = name;
		this.state = state;
	}
	

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

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	
	
	
}
