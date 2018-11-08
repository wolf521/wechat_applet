package com.issmart.service.impl;

import org.apache.ibatis.session.SqlSession;

import com.issmart.dao.MemberDao;
import com.issmart.model.Member;
import com.issmart.model.Response;
import com.issmart.service.MemberService;
import com.issmart.util.BusinessUtil;
import com.issmart.util.MyBatisUtil;
import com.issmart.util.UpdateMemberLabel;

public class MemberServiceImpl implements MemberService {

	@Override
	public Response queryMember(String unitId, String beaconCode, String code) {
		Response response = new Response();
		long l = System.currentTimeMillis();
		String openId = BusinessUtil.getOpenId(code);
		long l1 = System.currentTimeMillis();
		System.out.println("时间1："+(l1 - l));
		if (openId == null) {
			return response.diyFailure("40029", "code已失效");
		}
		// 获得会话对象
		SqlSession session = MyBatisUtil.getSqlSession(true);
		MemberDao memberDao = session.getMapper(MemberDao.class);
		Member member = memberDao.queryMember(unitId, beaconCode);
		long l2 = System.currentTimeMillis();
		System.out.println("时间2："+(l2 - l1));
		if (member != null) {
			if (!openId.equals(member.getOpenId())) {
				return response.diyFailure("40030", "登录信息错误");
			} else {
				return response.success(member);
			}
		} else {
			member = new Member();
			member.setOpenId(openId);
			return response.diySuccess(member,"40028","信息未注册");
		}
	}

	@Override
	public Integer saveMember(Member member) {
		Integer result = 0;
		if (UpdateMemberLabel.UPDATEALL.equals(member.getUpdateLabel())) {
			result = saveAllMember(member);
		} else if (UpdateMemberLabel.UPDATEMEMBER.equals(member.getUpdateLabel())) {
			result = saveMemberInfo(member);
		} else if (UpdateMemberLabel.UPDATELABEL.equals(member.getUpdateLabel())) {
			result = saveMemberLabel(member);
		} else if (UpdateMemberLabel.UPDATEINTEREST.equals(member.getUpdateLabel())) {
			result = saveAllInterest(member);
		}
		return result;
	}

	public Integer saveAllMember(Member member) {
		// 获得会话对象
		SqlSession session = MyBatisUtil.getSqlSession(false);
		MemberDao memberDao = session.getMapper(MemberDao.class);
		int memberResult = 0;
		int labelResult = 0;
		int interestResult = 0;
		if (member.getId() == null) {
			memberResult = memberDao.insertMember(member);
			if (member.getMemberId() != null) {
				labelResult = memberDao.insertMemberLabel(member.getMemberId(), member.getMemberLabelList());
				interestResult = memberDao.insertMemberInterest(member.getMemberId(), member.getMemberInterestList());
			}
		} else {
			memberResult = memberDao.updateMember(member);
			if (memberDao.deleteMemberLabel(member.getId()) != 0) {
				labelResult = memberDao.insertMemberLabel(member.getId(), member.getMemberLabelList());
			}
			if (memberDao.deleteMemberInterest(member.getId()) != 0) {
				interestResult = memberDao.insertMemberInterest(member.getId(), member.getMemberInterestList());
			}
		}
		if (memberResult != 0 && labelResult != 0 && interestResult != 0) {
			session.commit();
			return 1;
		} else {
			session.rollback();
			return 0;
		}
	}

	public Integer saveMemberInfo(Member member) {
		// 获得会话对象
		SqlSession session = MyBatisUtil.getSqlSession(false);
		MemberDao memberDao = session.getMapper(MemberDao.class);
		int memberResult = memberDao.updateMember(member);
		if (memberResult != 0) {
			session.commit();
			return memberResult;
		} else {
			session.rollback();
			return 0;
		}
	}

	public Integer saveMemberLabel(Member member) {
		// 获得会话对象
		SqlSession session = MyBatisUtil.getSqlSession(false);
		MemberDao memberDao = session.getMapper(MemberDao.class);
		int labelResult = 0;
		if (memberDao.deleteMemberLabel(member.getId()) != 0) {
			labelResult = memberDao.insertMemberLabel(member.getId(), member.getMemberLabelList());
		}
		if (labelResult != 0) {
			session.commit();
			return labelResult;
		} else {
			session.rollback();
			return 0;
		}
	}

	public Integer saveAllInterest(Member member) {
		// 获得会话对象
		SqlSession session = MyBatisUtil.getSqlSession(false);
		MemberDao memberDao = session.getMapper(MemberDao.class);
		int interestResult = 0;
		if (memberDao.deleteMemberInterest(member.getId()) != 0) {
			interestResult = memberDao.insertMemberInterest(member.getId(), member.getMemberInterestList());
		}
		if (interestResult != 0) {
			session.commit();
			return interestResult;
		} else {
			session.rollback();
			return 0;
		}
	}
}
