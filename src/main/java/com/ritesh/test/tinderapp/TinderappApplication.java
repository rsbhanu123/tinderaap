package com.ritesh.test.tinderapp;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.ritesh.test.tinderapp.service.IMemberService;

@SpringBootApplication
public class TinderappApplication {

	@Autowired
	public IMemberService memberService;
	
	public static void main(String[] args) {
		SpringApplication.run(TinderappApplication.class, args);
	}

	@PostConstruct
	public void AddDummyMember() {
		memberService.saveDummyMember();
	}
}
