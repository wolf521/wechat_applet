package com.issmart.model;

import java.util.List;

public class CardMessage {

	private String unitId;
	
	private String beaconMac;
	
	private List<String> targetBeaconMacList;

	public String getUnitId() {
		return unitId;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}

	public String getBeaconMac() {
		return beaconMac;
	}

	public void setBeaconMac(String beaconMac) {
		this.beaconMac = beaconMac;
	}

	public List<String> getTargetBeaconMacList() {
		return targetBeaconMacList;
	}

	public void setTargetBeaconMacList(List<String> targetBeaconMacList) {
		this.targetBeaconMacList = targetBeaconMacList;
	}
}
