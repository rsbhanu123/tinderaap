package com.ritesh.test.tinderapp.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ritesh.test.tinderapp.entity.City;
import com.ritesh.test.tinderapp.entity.Country;
import com.ritesh.test.tinderapp.entity.Gender;
import com.ritesh.test.tinderapp.entity.Member;
import com.ritesh.test.tinderapp.entity.ProfileMatch;
import com.ritesh.test.tinderapp.entity.State;
import com.ritesh.test.tinderapp.repository.CityRepository;
import com.ritesh.test.tinderapp.repository.CountryRepository;
import com.ritesh.test.tinderapp.repository.GenderRepository;
import com.ritesh.test.tinderapp.repository.MemberRepository;
import com.ritesh.test.tinderapp.repository.ProfileMatchRepository;
import com.ritesh.test.tinderapp.repository.StateRepository;


@Service
public class MemberService implements IMemberService{
	
	private MemberRepository memberRepository;
	private GenderRepository genderRepository;
	private CityRepository cityRepository;
	private StateRepository stateRepository;
	private CountryRepository countryRepository;
	private ProfileMatchRepository profileMatchRepository;
	

	@Autowired
	public MemberService(MemberRepository memberRepository,GenderRepository genderRepository,
			CityRepository cityRepository,StateRepository stateRepository,CountryRepository countryRepository
			,ProfileMatchRepository profileMatchRepository) {
		this.memberRepository =memberRepository;	
		this.genderRepository = genderRepository;
		this.cityRepository = cityRepository;
		this.stateRepository = stateRepository;
		this.countryRepository = countryRepository;
		this.profileMatchRepository = profileMatchRepository;
	}
	
	@Override
	public void saveDummyMember() {
		List<Gender> genderList = new ArrayList<>();
		genderList.add(new Gender(1,"Male"));
		genderList.add(new Gender(2,"Female"));
		genderList.add(new Gender(2,"Other"));
		
		for(Gender entity : genderList) {
			this.genderRepository.save(entity);			
		}		
		
		Country country = new Country(1,"India");
		countryRepository.save(country);
		
		State st = new State(1,"Maharashtra",country);
		stateRepository.save(st);		
		
		City c1 = new City(1, "Mumbai",st);
		cityRepository.save(c1);
		
		c1 = new City(2, "Pune",st);
		cityRepository.save(c1);
		
		st = new State(2,"Gujrat ",country);
		stateRepository.save(st);
		
		c1 = new City(3, "Surat",st);
		cityRepository.save(c1);
		
		c1 = new City(4, "Vapi",st);
		cityRepository.save(c1);
		
		
		List<Member> memberList = new ArrayList<>();
		
		memberList.add(new Member(null, "Ritesh", "Bhanushali", "ritesh123@gmail.com", "7854859580", "test@123", 27, new Gender(1), "1M.jpg", "cricket,music,reading", "Engineer", "I am the rainbow that drives your clouds away.",new City(1), new Gender(2)));
		memberList.add(new Member(null, "Radhika", "Mistry", "Radhika123@gmail.com", "7854859581", "test@123", 25,  new Gender(2), "2F.jpg", "Traveling", "Teacher", "I am teacher", new City(1), new Gender(1)));
		
		memberList.add(new Member(null, "Jitesh", "Maheta", "Jitesh123@gmail.com", "7854859582", "123456", 21, new Gender(1), "3M.jpg", "traveling", "student", "I am student.", new City(2), new Gender(2)));
		memberList.add(new Member(null, "ridhi", "parekh", "ridhiji123@gmail.com", "7854859583", "123456", 22,  new Gender(2), "4F.jpg", "Traveling", "Teacher", "I am teacher", new City(2), new Gender(1)));
		
		memberList.add(new Member(null, "krishna", "sudama", "krish123@gmail.com", "7854859584", "123", 23,  new Gender(1), "5M.jpg", "cricket", "student", "I am student", new City(3), new Gender(2)));
		memberList.add(new Member(null, "rita", "parekh", "rita123@gmail.com", "7854859585", "123", 22,  new Gender(2), "6F.jpg", "Music,Dance", "doctor", "I am doctor", new City(3), new Gender(1)));
		
		memberList.add(new Member(null, "Prakash", "purana", "prakash123@gmail.com", "7854859586", "456", 26,  new Gender(1), "7M.jpg", "cricket", "student", "I am student", new City(4), new Gender(2)));
		memberList.add(new Member(null, "chandani", "khurana", "chandani123@gmail.com", "7854859587", "456", 25,  new Gender(2), "8F.jpg", "Music,Dance", "doctor", "I am doctor", new City(4), new Gender(1)));
	
		memberList.add(new Member(null, "jagdish", "kiri", "jafu123@gmail.com", "785485958", "test@111", 18,  new Gender(1), "9M.jpg", "cricket", "engineer", "I am student", new City(1), new Gender(2)));
		memberList.add(new Member(null, "kitti", "nana", "kitti@gmail.com", "7854859589", "test@456", 27,  new Gender(2), "10F.jpg", "Music,Dance", "tester", "I am tester", new City(1), new Gender(1)));

		memberList.add(new Member(null, "viraj", "rai", "viraj123@gmail.com", "7854259681", "test@111", 20,  new Gender(1), "11M.jpg", "cricket", "engineer", "I am student", new City(2), new Gender(2)));
		memberList.add(new Member(null, "usha", "chitta", "usha123@gmail.com", "7854859579", "test@456", 30,  new Gender(2), "12F.jpg", "Music,Dance", "tester", "I am tester", new City(2), new Gender(1)));
		
		memberList.add(new Member(null, "raghu", "anand", "raghu@gmail.com", "7854879689", "test@111", 29,  new Gender(1), "13M.jpg", "dance", "engineer", "I am student", new City(3), new Gender(2)));
		memberList.add(new Member(null, "asha", "bajaj", "asha@gmail.com", "7851889579", "test@456", 31,  new Gender(2), "14F.jpg", "Music,travel", "doctor", "I am doctor", new City(4), new Gender(1)));
	
		memberList.add(new Member(null, "manish", "anand", "manish@gmail.com", "7851179689", "test@111", 29,  new Gender(1), "15M.jpg", "dance", "engineer", "I am student", new City(3), new Gender(2)));
		memberList.add(new Member(null, "chanda", "bajaj", "chanda111@gmail.com", "6651889579", "test@456", 31,  new Gender(2), "16F.jpg", "Music,travel", "doctor", "I am doctor", new City(4), new Gender(1)));
		
		for(Member entity : memberList ) {
			this.memberRepository.save(entity);
		}
	}
	

	@Override
	public List<Member> getAllMembers() {
		// TODO Auto-generated method stub
		return (List<Member>) this.memberRepository.findAll();
	}

	@Override
	public Member getMember(Integer memberId) {
		// TODO Auto-generated method stub
		return this.memberRepository.findOne(memberId);
	}
	
	
	public Member save(Member member) {
		return this.memberRepository.save(member);
	}

	@Override
	public List<Member> getAllMembersForMember(Integer memberId) {
		// TODO Auto-generated method stub
		return this.memberRepository.findByMemberIdNot(memberId);
	}

	@Override
	public Member checkLogin(String emailId) {
		// TODO Auto-generated method stub
		return this.memberRepository.findByEmailId(emailId);
	}

	@Override
	public ProfileMatch saveMatch(Integer memberId, Integer matchId, Integer swipwSide) {
		ProfileMatch match = new ProfileMatch();
		match.setMemberId(memberId);
		match.setMetchId(matchId);
		match.setSwipeSide(swipwSide);
		return profileMatchRepository.save(match);			
	}	
}
