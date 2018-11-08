package com.issmart.service;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.issmart.model.Friend;
import com.issmart.service.impl.FriendsServiceImpl;

public class FriendsServiceTest {

	@Test
	public void testQueryFriends() {
		FriendsService friendsService = new FriendsServiceImpl();
		Friend friend = new Friend();
		friend.setId(100);
		friend.setUnitId("919");
		friend.setBeaconCode("123456");
		friend.setBeaconCodeFriends("88888888");
		friend.setValidate("1");
		friend.setApplication("0");
		int i = friendsService.saveFriends(friend);
		System.out.println(i);
	}

	@Test
	public void testSaveFriends() {
		FriendsService friendsService = new FriendsServiceImpl();
		List<Map<String,Object>> list = friendsService.queryFriends("919", "01245");
		for(Map<String,Object> map:list) {
			System.out.println(map);
		}
	}
	
	@Test
	public void testSaveFriendsFromCard() {
		FriendsService friendsService = new FriendsServiceImpl();
		List<Map<String,Object>> list = friendsService.queryFriendsFromCard(158318);
		for(Map<String,Object> map:list) {
			System.out.println(map);
		}
	}
}
