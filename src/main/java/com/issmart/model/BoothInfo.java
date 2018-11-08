package com.issmart.model;

import java.util.List;

public class BoothInfo {

	/**
	 * boothId
	 */
	private Integer boothId; 
	
	/**
	 * deviceMac列表
	 */
	private List<String> deviceMacList; 
	
	/**
	 * 评分
	 */
	private Integer score;

	public Integer getBoothId() {
		return boothId;
	}

	public void setBoothId(Integer boothId) {
		this.boothId = boothId;
	}

	public List<String> getDeviceMacList() {
		return deviceMacList;
	}

	public void setDeviceMacList(List<String> deviceMacList) {
		this.deviceMacList = deviceMacList;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	} 
}
