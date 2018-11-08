package com.issmart.service;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.issmart.model.RecommendedInfo;
import com.issmart.service.impl.RecommendedServiceImpl;

public class RecommendServiceTest {

	@Test
	public void testRecommendedService() {
		RecommendedInfo recommendedInfo = new RecommendedInfo();
		recommendedInfo.setUnitId("920");
		recommendedInfo.setBeaconMac("F0F8F2DA9B36");
		recommendedInfo.setBoothSize(2);
		recommendedInfo.setMemberSize(2);
		RecommendedService recommendedService = new RecommendedServiceImpl();
		Map<String, List<Map<String, Object>>> list = recommendedService.queryRecommendedInfo(null,recommendedInfo);
		System.out.println("dd"+list);
	}
	
	@Test
	public void testqueryRecommendedInfoBySelf() {
		RecommendedInfo recommendedInfo = new RecommendedInfo();
		recommendedInfo.setUnitId("920");
		recommendedInfo.setBeaconMac("F0F8F2DAr9B36");
		recommendedInfo.setBoothSize(2);
		recommendedInfo.setMemberSize(2);
		RecommendedService recommendedService = new RecommendedServiceImpl();
		Map<String, List<Map<String, Object>>> list = recommendedService.queryRecommendedInfoBySelf(null,recommendedInfo);
		System.out.println("dd"+list);
	}
	
	public static void main(String[] args) {
		RecommendedInfo recommendedInfo = new RecommendedInfo();
		recommendedInfo.setUnitId("919");
		recommendedInfo.setBeaconMac("F0F8F2DA9B36");
		recommendedInfo.setBoothSize(2);
		recommendedInfo.setMemberSize(2);
		RecommendedService recommendedService = new RecommendedServiceImpl();
		Map<String, List<Map<String, Object>>> list = recommendedService.queryRecommendedInfo(null,recommendedInfo);
		System.out.println("dd"+list);
	}
}
