package com.issmart.service;

import com.issmart.model.Member;
import com.issmart.model.Response;

/**
 * 用户服务
 * 
 * @author Administrator
 *
 */
public interface MemberService {
	/**
	 * 查询个人信息
	 * 
	 * @param unitId
	 * @param beaconCode
	 * @return
	 */
	Response queryMember(String unitId,String beaconCode,String code);
	/**
	 * 保存个人信息
	 * 
	 * @param member
	 * @return
	 */
	Integer saveMember(Member member);
}
