package com.ritesh.test.tinderapp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProfileMatch {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer id;
	
	private Integer memberId;
	
	private Integer metchId;
	
	private Integer swipeSide;
	
	public ProfileMatch() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public Integer getMetchId() {
		return metchId;
	}

	public void setMetchId(Integer metchId) {
		this.metchId = metchId;
	}

	public Integer getSwipeSide() {
		return swipeSide;
	}

	public void setSwipeSide(Integer swipeSide) {
		this.swipeSide = swipeSide;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Integer id = (Integer) obj;
		if (metchId == null) {
			if (id != null)
				return false;
		} else if (!metchId.equals(id))
			return false;
		return true;
	}
	
	
		
}
