package com.issmart.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.issmart.dao.BoothDao;
import com.issmart.service.BoothService;
import com.issmart.util.MyBatisUtil;

public class BoothServiceImpl implements BoothService {

	@Override
	public Map<String, Object> getBooothDetail(String unitId, String deviceMac) {
		// 获得会话对象
		SqlSession session = MyBatisUtil.getSqlSession(true);
		BoothDao boothDao = session.getMapper(BoothDao.class);
		return boothDao.getBooothDetail(unitId, deviceMac);
	}

	@Override
	public Map<String,Object> getUnitId(String beaconId) {
		// 获得会话对象
		SqlSession session = MyBatisUtil.getSqlSession(true);
		BoothDao boothDao = session.getMapper(BoothDao.class);
		return boothDao.getUnitId(beaconId);
	}
	
	public static void main(String[] args) {
		System.out.println(new BoothServiceImpl().getUnitId("807198"));
	}

	@Override
	public Map<String,Object> queryBoothInfo() {
		// 获得会话对象
		SqlSession session = MyBatisUtil.getSqlSession(true);
		BoothDao boothDao = session.getMapper(BoothDao.class);
		List<Map<String,Object>> list = boothDao.queryBoothInfo();
		List<Map<String,Object>> table_content = new ArrayList<>();
		for(Map<String,Object> map:list) {
			Map<String,Object> item = new HashMap<String, Object>();
			item.put("cmd", "add");
			Map<String,Object> itemFields = new HashMap<String, Object>();
			itemFields.put("itemid", map.get("unit_id")+"_"+map.get("device_mac"));
			itemFields.put("cateid", "booth_"+map.get("unit_id"));
			itemFields.put("title", map.get("booth_name"));
			item.put("fields", itemFields);
			table_content.add(item);
		}
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("appid", "5215264");
		map.put("table_name", "item");
		map.put("table_content", table_content);
		return map;
	}
}
