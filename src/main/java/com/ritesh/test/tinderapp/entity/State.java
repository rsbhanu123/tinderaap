package com.ritesh.test.tinderapp.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class State {
	@Id
	private Integer id;
	
	private String name;	
	
	@OneToOne
	private Country country;
	
	public State() {
		
	}
	
	public State(Integer id, String name, Country country) {
		this.id = id;
		this.name = name;
		this.country = country;
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

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	
	
	
}
