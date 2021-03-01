package com.ritesh.test.tinderapp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ritesh.test.tinderapp.entity.Member;

@Repository
public interface MemberRepository extends CrudRepository<Member, Integer>{
	
	public List<Member> findByMemberIdNot(Integer memberId);
	
	public Member findByEmailId(String emailId);
}
