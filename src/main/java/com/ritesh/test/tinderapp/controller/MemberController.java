package com.ritesh.test.tinderapp.controller;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ritesh.test.tinderapp.entity.Member;
import com.ritesh.test.tinderapp.entity.ProfileMatch;
import com.ritesh.test.tinderapp.request.ErrorResponse;
import com.ritesh.test.tinderapp.request.LoginRequest;
import com.ritesh.test.tinderapp.request.LoginResponse;
import com.ritesh.test.tinderapp.request.Response;
import com.ritesh.test.tinderapp.service.IMemberService;

@RestController
public class MemberController {
	
	@Autowired
	IMemberService memberService;
	
	@RequestMapping("/Member")
	public List<Member> getAllMember() {
		return memberService.getAllMembers();
	}

	/**
	 * 
	 * @param id
	 * @return
	 * Fetch all the member excluding current member and already matched members
	 */
	@RequestMapping("/MemberForUser/{id}")
	public Response getAllMember(@PathVariable  Integer id) {
		Response resp = null;
		try {
			List<Member> finalMemberList = new ArrayList<>();
			List<Member> list = memberService.getAllMembersForMember(id);
			Member member = memberService.getMember(id);
			Collection<ProfileMatch> idList  = member.getProfileMatch();
			for(Member m : list) {
				boolean flag = false;
				for(ProfileMatch match :idList) {					
					if(m.getMemberId() == match.getMetchId()) {
						flag = true;
					}
				}
				if(!flag && member.getPreference().getId().equals(m.getGender().getId()))
					finalMemberList.add(m);
			}
			resp = new Response();
			resp.setData(finalMemberList);
			resp.setCode("11");			
		}
		catch (Exception e) {
			// TODO: handle exception
			resp = new ErrorResponse(e.getMessage());
			resp.setCode("00");
		}
		return resp;
	}
	
	/**
	 * Get member by member id
	 * @param id
	 * @return
	 */
	@RequestMapping("/Member/{id}")
	public Member getMember(@PathVariable Integer id) {
		return memberService.getMember(id);
	}	
	
	
	/**
	 * check login by username and password and return member object on successful login
	 * @param loginRequest
	 * @return
	 */
	@RequestMapping(method=RequestMethod.POST,value="/MemberLogin")
	public Response getMember(@RequestBody LoginRequest loginRequest) {
		Member member = null;
		Response resp = null;
		
		try {
			member = memberService.checkLogin(loginRequest.getEmailId());
			if(member == null || !member.getPassword().equals(loginRequest.getPassword())) {
				resp = new ErrorResponse("Invalid Profile");
				resp.setCode("00");
				
			}else {
				resp = new LoginResponse();
				resp.setData(member);
				resp.setCode("11");
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			resp = new ErrorResponse(e.getMessage());
			resp.setCode("00");
		}
		return resp;
	}	
	
	/**
	 * Return match count for memeber id 
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET,value="/Member/{id}/matchCount")
	public Response matchCount(@PathVariable  Integer id) {
		Response resp = null;
		try {
			Member member = memberService.getMember(id);
			Map <String,Integer> count = new HashMap<>();
			if(member != null) {
				resp = new Response();
				int rightCount= 0;
				int leftCount =0;
				for(ProfileMatch pm :member.getProfileMatch()) {
					if(pm.getSwipeSide()==1)
						rightCount++;
					else
						leftCount++;					
				}
				count.put("Right", rightCount);
				count.put("Left", leftCount);
				resp.setData(count);		
				resp.setCode("11");
				
			}else {				
				resp = new ErrorResponse("!Error");
				resp.setCode("00");
			}
		}catch (Exception e) {
			// TODO: handle exception
			resp = new ErrorResponse(e.getMessage());

		}
		return resp;
								
	}
	
	/**
	 * Save match with swipeSide id against memeber id
	 * @param id
	 * @param matchid
	 * @return
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(method=RequestMethod.POST,value="/Member/{id}/Match/{matchid}/{swipeSide}")
	public Response saveMatch(@PathVariable  Integer id,@PathVariable  Integer matchid,@PathVariable  Integer swipeSide) {
			Response resp = null;
			try {
				ProfileMatch match = memberService.saveMatch(id,matchid,swipeSide);
				if(match!=null) {
					resp = new Response();
					resp.setCode("11");
				}else {
					resp = new ErrorResponse("Error");
					resp.setCode("00");
				}				
			}catch (Exception e) {
				// TODO: handle exception
				resp = new ErrorResponse(e.getMessage());
				resp.setCode("00");
			}
			return resp;
	}
	
}
