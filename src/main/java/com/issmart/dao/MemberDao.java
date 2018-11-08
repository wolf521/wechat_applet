package com.issmart.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.issmart.model.Member;
import com.issmart.model.MemberInterest;
import com.issmart.model.MemberLabel;

public interface MemberDao {

	/**
	 * 查询个人信息
	 * 
	 * @param unitId
	 * @param beaconCode
	 * @return
	 */
	Member queryMember(@Param("unitId") String unitId,@Param("beaconCode") String beaconCode);
	
	/**
	 * 查询个人标签
	 * @param id
	 * @return
	 */
	List<MemberLabel> queryLabel(@Param("id") String id);
	
	/**
	 * 新建个人信息
	 * 
	 * @param member
	 * @return
	 */
	Integer insertMember(Member member);
	/**
	 * 修改个人信息
	 * 
	 * @param member
	 * @return
	 */
	Integer updateMember(Member member);
	/**
	 * 删除个人标签
	 * 
	 * @param member
	 * @return
	 */
	Integer deleteMemberLabel(Integer memberId);
	/**
	 * 新建个人标签
	 * 
	 * @param member
	 * @return
	 */
	Integer insertMemberLabel(@Param("memberId") Integer memberId,@Param("memberLabelList") List<MemberLabel> memberLabelList);
	/**
	 * 删除个人兴趣
	 * 
	 * @param member
	 * @return
	 */
	Integer deleteMemberInterest(Integer memberId);
	/**
	 * 新建个人兴趣
	 * 
	 * @param member
	 * @return
	 */
	Integer insertMemberInterest(@Param("memberId") Integer memberId,@Param("memberInterestList") List<MemberInterest> memberInterestList);
}
