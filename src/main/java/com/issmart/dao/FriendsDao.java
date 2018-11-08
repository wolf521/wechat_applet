package com.issmart.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.issmart.model.Friend;

public interface FriendsDao {

	/**
	 * 查询好友信息
	 * 
	 * @param unitId
	 * @param beaconCode
	 * @return
	 */
	List<Map<String,Object>> queryFriends(@Param("unitId") String unitId,@Param("beaconCode") String beaconCode);
	
	/**
	 * 新增
	 * 
	 * @param unitId
	 * @param list
	 * @return
	 */
	Integer insertsFriends(@Param("unitId") String unitId,@Param("list") List<Friend> list);
	
	/**
	 * 更新
	 * 
	 * @param unitId
	 * @param list
	 * @return
	 */
	Integer updateFriends(Friend friend);
	
	/**
	 * 查询好友信息
	 * 
	 * @param unitId
	 * @param beaconCode
	 * @return
	 */
	List<Map<String,Object>> queryFriendsFromCard(@Param("memberId") Integer memberId);
}
