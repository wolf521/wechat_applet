package com.issmart.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;

import com.issmart.dao.CardDao;
import com.issmart.model.CardMessage;
import com.issmart.service.CardService;
import com.issmart.util.MyBatisUtil;
import com.issmart.util.StringUtil;

public class CardServiceImpl implements CardService {

	@Override
	public List<Map<String, Object>> queryCardMessage(CardMessage cardMessage) {
		// 获得会话对象O
		SqlSession session = MyBatisUtil.getSqlSession(true);
		CardDao cardDao = session.getMapper(CardDao.class);
		Set<String> set = removaRepeat(cardMessage.getTargetBeaconMacList());
		if(set.size() != 0) {
			List<String> list = cardDao.queryBeaconMacInfo(cardMessage.getUnitId());
			List<String> beaconMacList = getFullBeaconMac(set,list);
			compareCardInfo(cardDao,cardMessage,beaconMacList);
			List<Map<String, Object>> infoList = cardDao.queryCardsInfo(cardMessage.getUnitId(), beaconMacList);
			return infoList;
		} 
		return null;
	}
	
	public Set<String> removaRepeat(List<String> list){
		Set<String> set = new HashSet<>();
		for(String str:list) {
			set.add(str.substring(2));
		}
		return set;
	}
	
	/**
	 * 补满所有的BeaconMac
	 * 
	 * @param set
	 * @param beaconMacList
	 * @return
	 */
	public List<String> getFullBeaconMac(Set<String> set,List<String> beaconMacList){
		List<String> list = new ArrayList<>();
		for(String str:set) {
			List<String> resultList = getBeaconList(str.substring(2).toUpperCase(),beaconMacList);
			if(resultList.size() == 1) {
				list.add(resultList.get(0));
			} else if(resultList.size() > 1) {
				list.add(getBeaconMac(str.substring(0, 2),resultList));
			}
		}
		return list;
	}
	
	/**
	 * 获取目标在所有beacon中的数量及信息
	 * 
	 * @param targetBeaconMac
	 * @param beaconMacList
	 * @return
	 */
	public List<String> getBeaconList(String targetBeaconMac,List<String> beaconMacList){
		List<String> list = new ArrayList<>();
		for(String beaconMac:beaconMacList) {
			if(targetBeaconMac.equals(beaconMac.substring(6))) {
				list.add(beaconMac);
			}
		}
		return list;
	}
	
	/**
	 * 后六位存在重复数据，根据标识未获取真正的mac
	 * 
	 * @param mark
	 * @param resultList
	 * @return
	 */
	public String getBeaconMac(String mark,List<String> resultList) {
		String result = null;
		for(String mac:resultList) {
			if(StringUtil.verifyTargetBeaconMac(mark, mac)) {
				result = mac;
				break;
			}
		}
		return result;
	}
	
	/**
	 * 比较数据库名片信息与beacon中保存的信息，并进行合并去重处理
	 */
	public void compareCardInfo(CardDao cardDao,CardMessage cardMessage,List<String> beaconMacList) {
		Integer memberId = cardDao.queryMemberId(cardMessage.getUnitId(), cardMessage.getBeaconMac());
		List<Integer> cardMemberIdList = cardDao.queryMemberIdList(cardMessage.getUnitId(), memberId, beaconMacList);
		if(cardMemberIdList.size() != 0) {
			cardDao.insertCardInfo(memberId, cardMemberIdList);
		}
	}
}
