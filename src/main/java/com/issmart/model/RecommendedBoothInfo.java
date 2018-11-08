package com.issmart.model;

import java.util.List;

public class RecommendedBoothInfo {

	/**
	 * id
	 */
	private String id; 
	
	/**
	 * beaconMac
	 */
	private String beaconMac; 
	
	/**
	 * 推荐信息列表
	 */
	private List<BoothInfo> recommendInfoList;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBeaconMac() {
		return beaconMac;
	}

	public void setBeaconMac(String beaconMac) {
		this.beaconMac = beaconMac;
	}

	public List<BoothInfo> getRecommendInfoList() {
		return recommendInfoList;
	}

	public void setRecommendInfoList(List<BoothInfo> recommendInfoList) {
		this.recommendInfoList = recommendInfoList;
	} 
}
