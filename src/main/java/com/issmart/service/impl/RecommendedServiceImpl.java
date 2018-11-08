package com.issmart.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.alibaba.fastjson.JSON;
import com.aliyun.fc.runtime.Context;
import com.issmart.dao.RecommendedDao;
import com.issmart.model.BoothInfo;
import com.issmart.model.RecommendedInfo;
import com.issmart.model.RecommendedInfoBySelf;
import com.issmart.service.RecommendedService;
import com.issmart.util.HttpUtils;
import com.issmart.util.MyBatisUtil;

public class RecommendedServiceImpl implements RecommendedService {

	@Override
	public Map<String, List<Map<String, Object>>> queryRecommendedInfo(Context context,
			RecommendedInfo recommendedInfo) {
		// 获得会话对象
		SqlSession session = MyBatisUtil.getSqlSession(true);
		RecommendedDao recommendedDao = session.getMapper(RecommendedDao.class);
		Map<String, List<Map<String, Object>>> map = new HashMap<>();
		map.put("booth", queryBoothInfo(context, recommendedDao, recommendedInfo));
		map.put("member", queryMemberInfo(context, recommendedDao, recommendedInfo));
		return map;
	}

	/**
	 * 查询推荐展台信息
	 * 
	 * @param unitIid
	 * @param deviceMacList
	 * @return
	 */
	private List<Map<String, Object>> queryBoothInfo(Context context, RecommendedDao recommendedDao,
			RecommendedInfo recommendedInfo) {
		String url = "http://recapi.datagrand.com/personal/yisizhi?userid=" + recommendedInfo.getUserId() + "&cateid="
				+ recommendedInfo.getBoothCateId() + "&cnt=" + recommendedInfo.getBoothSize() + "&scene_type=booth";
		String result = HttpUtils.sendGetRequest(url);
		// context.getLogger().info("查询达观结果返回结果："+result);
		System.out.println("查询推荐展台返回结果：" + result);
		RecommendedInfo recommendedInfoParam = JSON.parseObject(result, RecommendedInfo.class);
		List<Map<String, Object>> deviceMacList = new ArrayList<>();
		if (recommendedInfoParam.getRecdata().size() == 0) {
			return new ArrayList<>();
		}
		for (Map<String, String> map : recommendedInfoParam.getRecdata()) {
			List<Map<String, Object>> boothInfoList = recommendedDao.queryBoothInfo(recommendedInfo.getUnitId(),
					map.get("itemid").split("_")[1]);
			if (boothInfoList.size() == 0)
				continue;
			Map<String, Object> boothInfo = boothInfoList.get(0);
			boothInfo.put("request_id", recommendedInfoParam.getRequest_id());
			boothInfo.put("userId", recommendedInfo.getUserId());
			boothInfo.put("itemId", recommendedInfo.getUnitId() + "_" + boothInfo.get("deviceMac"));
			deviceMacList.add(boothInfo);
		}
		return deviceMacList;
	}

	/**
	 * 查询推荐用户信息
	 * 
	 * @param unitIid
	 * @param beaconMacList
	 * @return
	 */
	private List<Map<String, Object>> queryMemberInfo(Context context, RecommendedDao recommendedDao,
			RecommendedInfo recommendedInfo) {
		String url = "http://recapi.datagrand.com/personal/yisizhi?userid=" + recommendedInfo.getUserId() + "&cateid="
				+ recommendedInfo.getMemberCateId() + "&cnt=" + recommendedInfo.getMemberSize() + "&scene_type=member";
		String result = HttpUtils.sendGetRequest(url);
		System.out.println("查询推荐用户返回结果：" + result);
		RecommendedInfo recommendedInfoParam = JSON.parseObject(result, RecommendedInfo.class);
		List<Map<String, Object>> beaconMacList = new ArrayList<>();
		if (recommendedInfoParam.getRecdata().size() == 0) {
			return new ArrayList<>();
		}
		for (Map<String, String> map : recommendedInfoParam.getRecdata()) {
			List<Map<String, Object>> resultMapList = recommendedDao.queryMemberInfo(recommendedInfo.getUnitId(),
					map.get("itemid").split("_")[1]);
			if (resultMapList.size() == 0)
				continue;
			Map<String, Object> resultMap = resultMapList.get(0);
			resultMap.put("request_id", recommendedInfoParam.getRequest_id());
			resultMap.put("userId", recommendedInfo.getUserId());
			resultMap.put("itemId", recommendedInfo.getUnitId() + "_" + resultMap.get("beaconMac"));
			beaconMacList.add(resultMap);
		}
		return beaconMacList;
	}

	@Override
	public Map<String, List<Map<String, Object>>> queryRecommendedInfoBySelf(Context context,
			RecommendedInfo recommendedInfo) {
		// 获得会话对象
		SqlSession session = MyBatisUtil.getSqlSession(true);
		RecommendedDao recommendedDao = session.getMapper(RecommendedDao.class);
		Map<String, List<Map<String, Object>>> map = new HashMap<>();
		map.put("booth", queryBoothInfoBySelf(context, recommendedDao, recommendedInfo));
		map.put("member", new ArrayList<>());
		return map;
	}

	/**
	 * 查询推荐展台信息
	 * 
	 * @param unitIid
	 * @param deviceMacList
	 * @return
	 */
	private List<Map<String, Object>> queryBoothInfoBySelf(Context context, RecommendedDao recommendedDao,
			RecommendedInfo recommendedInfo) {
		String url = "http://119.23.231.196:8080/recommend/manager/query/recommend?beaconMac="
				+ recommendedInfo.getBeaconMac() + "&boothSize=" + recommendedInfo.getBoothSize();
		String result = HttpUtils.sendGetRequest(url);
		context.getLogger().info("查询个性化推荐返回结果："+result);
		if(result == null) {
			return new ArrayList<>();
		}
		RecommendedInfoBySelf recommendedInfoParam = JSON.parseObject(result, RecommendedInfoBySelf.class);
		List<Map<String, Object>> deviceMacList = new ArrayList<>();
		if (recommendedInfoParam.getData().getRecommendInfoList().size() == 0) {
			return new ArrayList<>();
		}
		List<Map<String, Object>> boothInfoList = recommendedDao.queryBoothInfoByUnitId(recommendedInfo.getUnitId());
		for (BoothInfo boothInfo : recommendedInfoParam.getData().getRecommendInfoList()) {
			if (boothInfoList.size() == 0)
				continue;
			deviceMacList.add(getBoothInfo(boothInfoList, boothInfo.getBoothId()));
		}
		return deviceMacList;
	}

	private Map<String, Object> getBoothInfo(List<Map<String, Object>> boothInfoList, Integer boothId) {
		for (Map<String, Object> map : boothInfoList) {
			if (boothId.equals(map.get("boothId"))) {
				return map;
			}
		}
		return null;
	}
}
