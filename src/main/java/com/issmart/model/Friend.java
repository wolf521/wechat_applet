package com.issmart.model;

/**
 * 好友实体
 * 
 * @author Administrator
 *
 */
public class Friend {
	/**
	 * 主键
	 */
	private Integer id;
	/**
	 * unitId	
	 */
	private String unitId;
	/**
	 * beaconCode
	 */
	private String beaconCode;
	/**
	 * beaconCodeFriends
	 */
	private String beaconCodeFriends;
	/**
	 * 验证状态 (0：待验证，1：已通过，2：已拒绝)
	 */
	private String validate;
	/**
	 * (0：申请方，1：被申请方)
	 */
	private String application;
	/**
	 * 是否可用 (0：不可用，1：可用)
	 */
	private String enable;
	public String getEnable() {
		return enable;
	}
	public void setEnable(String enable) {
		this.enable = enable;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUnitId() {
		return unitId;
	}
	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}
	public String getBeaconCode() {
		return beaconCode;
	}
	public void setBeaconCode(String beaconCode) {
		this.beaconCode = beaconCode;
	}
	public String getBeaconCodeFriends() {
		return beaconCodeFriends;
	}
	public void setBeaconCodeFriends(String beaconCodeFriends) {
		this.beaconCodeFriends = beaconCodeFriends;
	}
	public String getValidate() {
		return validate;
	}
	public void setValidate(String validate) {
		this.validate = validate;
	}
	public String getApplication() {
		return application;
	}
	public void setApplication(String application) {
		this.application = application;
	}
	@Override
	public String toString() {
		return "Friend [id=" + id + ", unitId=" + unitId + ", beaconCode=" + beaconCode + ", beaconCodeFriends="
				+ beaconCodeFriends + ", validate=" + validate + ", application=" + application + ", enable=" + enable
				+ "]";
	}
}
