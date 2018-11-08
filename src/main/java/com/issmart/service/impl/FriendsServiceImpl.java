package com.issmart.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.issmart.dao.FriendsDao;
import com.issmart.model.Friend;
import com.issmart.service.FriendsService;
import com.issmart.util.MyBatisUtil;

public class FriendsServiceImpl implements FriendsService {

	/**
	 * 查询好友信息
	 * 
	 * @param unitId	
	 * @param beaconCode
	 * @return
	 */
	@Override
	public List<Map<String, Object>> queryFriends(String unitId, String beaconCode) {
		// 获得会话对象
		SqlSession session = MyBatisUtil.getSqlSession(true);
		FriendsDao friendsDao = session.getMapper(FriendsDao.class);
		return friendsDao.queryFriends(unitId, beaconCode);
	}

	@Override
	public Integer saveFriends(Friend friend) {
		// 获得会话对象
		SqlSession session = MyBatisUtil.getSqlSession(false);
		FriendsDao friendsDao = session.getMapper(FriendsDao.class);
		int count = 0;
		Friend friend1 = new Friend();
		friend1.setBeaconCode(friend.getBeaconCodeFriends());
		friend1.setBeaconCodeFriends(friend.getBeaconCode());
		if(friend.getId() == null) {
			List<Friend> list = new ArrayList<Friend>();
			friend1.setApplication("1");
			list.add(friend);
			list.add(friend1);
			count = friendsDao.insertsFriends(friend.getUnitId(),list);
		} else {
			count += friendsDao.updateFriends(friend);
			friend1.setValidate(friend.getValidate());
			friend1.setUnitId(friend.getUnitId());
			count += friendsDao.updateFriends(friend1);
		}
		if(count != 2) {
			session.rollback();
		} else {
			session.commit();
		}
		return count;
	}

	@Override
	public List<Map<String, Object>> queryFriendsFromCard(Integer memberId) {
		// 获得会话对象
		SqlSession session = MyBatisUtil.getSqlSession(true);
		FriendsDao friendsDao = session.getMapper(FriendsDao.class);
		return friendsDao.queryFriendsFromCard(memberId);
	}
}
