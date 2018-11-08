package com.issmart.model;

import com.issmart.util.ConstantUtil;
import com.issmart.util.StringUtil;

/**
 * 扫描信息实体
 * 
 * @author Administrator
 *
 */
public class ScanInfo {
	
	/**
	 * unitId
	 */
	private String unitId;
	
	/**
	 * 当前扫描人的beaconCode
	 */
	private String beaconCode;
	
	/**
	 * targetBeaconMac
	 */
	private String targetBeaconMac;

	/**
	 * 扫描到的设备信息（android:安卓）
	 */
	private String deviceId;
	
	/**
	 * 扫描到的设备信息（ios:苹果）
	 */
	private String serviceDate;
	
	/**
	 * 扫描数据平台（android:安卓，ios:苹果）
	 */
	private String platform;
	
	/**
	 * 扫描到的设备信号值
	 */
	private Integer rssi;

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public Integer getRssi() {
		return rssi;
	}

	public void setRssi(Integer rssi) {
		this.rssi = rssi;
	}

	public String getUnitId() {
		return unitId;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}
	
	public String getTargetBeaconMac() {
		if(ConstantUtil.ANDROID.equals(this.platform)) {
			return StringUtil.getAnaroidBeaconMac(this.deviceId);
		} else if(ConstantUtil.IOS.equals(this.platform)) {
			return StringUtil.getIOSBeaconMac(this.serviceDate);
		}
		return null;
	}

	public String getBeaconCode() {
		return beaconCode;
	}

	public void setBeaconCode(String beaconCode) {
		this.beaconCode = beaconCode;
	}
	
	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getServiceDate() {
		return serviceDate;
	}

	public void setServiceDate(String serviceDate) {
		this.serviceDate = serviceDate;
	}

	@Override
	public String toString() {
		return "ScanInfo [unitId=" + unitId + ", beaconCode=" + beaconCode + ", targetBeaconMac=" + targetBeaconMac
				+ ", deviceId=" + deviceId + ", platform=" + platform + ", rssi=" + rssi + "]";
	}
}
