package com.issmart.service;

import java.util.List;
import java.util.Map;

import com.issmart.model.Friend;

public interface FriendsService {
	
	/**
	 * 查询消息请求好友信息
	 * 
	 * @param unitId
	 * @param beaconCode
	 * @return
	 */
	List<Map<String,Object>> queryFriends(String unitId,String beaconCode);
	/**
	 * 保存好友信息
	 * 
	 * @param unitId
	 * @param beaconCode
	 * @return
	 */
	Integer saveFriends(Friend friend);
	/**
	 * 查询贴一贴好友信息
	 * 
	 * @param unitId
	 * @param beaconCode
	 * @return
	 */
	List<Map<String,Object>> queryFriendsFromCard(Integer memberId);
}
