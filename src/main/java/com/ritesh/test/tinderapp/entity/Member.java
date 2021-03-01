package com.ritesh.test.tinderapp.entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Member {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer memberId;
	
	private String firstName;
	
	private String lastName;
	
	private String emailId;
	
	private String mobileNo;
	
	private String password;
	
	private int age;	
		
	@OneToOne
	private City city;	

	@OneToOne
	private Gender gender;
	
	@OneToOne
	private Gender preference;
	
	private String image;
	
	private String hobbies;
	
	private String occupation;
	
	private String description;
	
	@OneToMany(mappedBy="memberId",fetch=FetchType.LAZY)
	private Collection<ProfileMatch> profileMatch;
	
	public Member() {
		
	}
	
	public Member(Integer memberId,String firstName,String lastName,String emailId,String mobileNo,String password,int age			
			,Gender gender,String image,String hobbies,String occupation,String description, City city , Gender preference) {
		this.memberId =memberId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.mobileNo = mobileNo;
		this.age= age;
		this.password = password;
		this.gender = gender;
		this.image = image;
		this.hobbies =hobbies;
		this.occupation =occupation ;
		this.description =description;		
		this.city = city;
		this.preference = preference;
	}
	
	public Member(Integer memberId) {
		this.memberId = memberId;
	}
	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getHobbies() {
		return hobbies;
	}

	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	
	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}


	public Gender getPreference() {
		return preference;
	}

	public void setPreference(Gender preference) {
		this.preference = preference;
	}

	public Collection<ProfileMatch> getProfileMatch() {
		return profileMatch;
	}

	public void setProfileMatch(Collection<ProfileMatch> profileMatch) {
		this.profileMatch = profileMatch;
	}
	
	
}