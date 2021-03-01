package com.ritesh.test.tinderapp.service;

import java.util.List;

import com.ritesh.test.tinderapp.entity.Member;
import com.ritesh.test.tinderapp.entity.ProfileMatch;
import com.ritesh.test.tinderapp.request.LoginRequest;

public interface IMemberService {

	public void saveDummyMember();
	
	public List<Member> getAllMembers();
	
	public Member getMember(Integer memberId);
	
	public List<Member> getAllMembersForMember(Integer memberId);
	
	public Member checkLogin(String emailId);
	
	public ProfileMatch saveMatch(Integer memberId, Integer matchId,Integer swipwSide);		
}
