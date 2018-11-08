package com.issmart.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.issmart.model.Member;
import com.issmart.model.MemberInterest;
import com.issmart.model.MemberLabel;
import com.issmart.model.Response;
import com.issmart.service.impl.MemberServiceImpl;

public class MemberServiceTest {

	@Test
	public void testQueryMember() {
		MemberService memberService = new MemberServiceImpl();
		Response response = memberService.queryMember("919", "00353","033L7QJW09pcbU1IdFJW0pLBJW0L7QJA");
		System.out.println(response.getData()+","+response.getMeta());
	}

	@Test
	public void testSaveMember() {
		MemberService memberService = new MemberServiceImpl();
		Member member = new Member();
		//member.setId(81);
		member.setUnitId("919");
		member.setMemberName("邓鑫");
		member.setMemberEmail("dengxin@issmart.com.cn");
		member.setMemberPhone("1999999");
		member.setCompanyName("易思智");
		member.setBeaconCode("33333233");
		member.setPostionId(4);
		member.setIndustryId(7);
		member.setUpdateLabel("UPDATEALL");
		member.setOpenPrivacy("on");
		member.setOpenId("o3eAI0al4Gjwf9IMBO0ZMPO3UMXM");
		MemberLabel memberLabel = new MemberLabel();
		memberLabel.setLabelId(19);
		List<MemberLabel> memberLabelList = new ArrayList<MemberLabel>();
		memberLabelList.add(memberLabel);
		member.setMemberLabelList(memberLabelList);
		MemberInterest memberInterest = new MemberInterest();
		memberInterest.setInterestId(22);
		List<MemberInterest> memberInterestList = new ArrayList<MemberInterest>();
		memberInterestList.add(memberInterest);
		member.setMemberInterestList(memberInterestList);
		memberService.saveMember(member);
	}
	
	public static void main(String[] args) {
//		SaveMember saveMember = new SaveMember();
//		Map<String, Object> requestParam = new HashMap<>();
//		requestParam.put("body", "eyJpZCI6IiIsInVuaXRJZCI6IjkxOSIsIm1lbWJlck5hbWUiOiLltJTlv5fnpaUiLCJtZW1iZXJFbWFpbCI6ImN1aXpoaXhpbmdAaXNzbWFydC5jb20uY24iLCJ1cGRhdGVMYWJlbCI6IlVQREFURUFMTCIsIm1lbWJlclBob25lIjoiMTY2NjY2NiIsImNvbXBhbnlOYW1lIjoi5piT5oCd5pm6IiwicG9zdGlvbklkIjoiNiIsImluZHVzdHJ5SWQiOiIzIiwid2VjaGF0SGVhZEltZyI6IjIzIiwid2VjaGF0Tmlja25hbWUiOiIyMyIsImJlYWNvbkNvZGUiOiI4ODg4ODg4OCIsIm1lbWJlckxhYmVsTGlzdCI6W3sibGFiZWxJZCI6IjE1In1dLCJtZW1iZXJJbnRlcmVzdExpc3QiOlt7ImludGVyZXN0SWQiOiIxOSJ9XX0=");
//		saveMember.handleRequest(requestParam, null);
		System.out.println(System.currentTimeMillis());
	}
}
