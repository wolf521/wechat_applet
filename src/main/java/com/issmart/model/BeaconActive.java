package com.issmart.model;

import java.util.Date;

/**
 * 用户轨迹实体
 * 
 * @author CuiZhiXiang
 *
 */
public class BeaconActive {
	
	/**
	 * 主键
	 */
	private Integer id;
	
	/**
	 * memberId
	 */
	private Integer memberId;
	
	/**
	 * 邮箱
	 */
	private String memberEmail;
	
	/**
	 * 姓名
	 */
	private String memberName;
	
	/**
	 * 公司
	 */
	private String companyName;
	
	/**
	 * 职业
	 */
	private String postionCode;
	
	/**
	 * 到访展台名
	 */
	private String boothName;
	
	/**
	 * 到访时间
	 */
	private String arriveTime;
	
	/**
	 * 离开时间
	 */
	private Date leaveTime;
	
	/**
	 * 停留时长
	 */
	private Integer stayTime;
	
	/**
	 * beaconMac
	 */
	private String beaconMac;
	
	/**
	 * deviceMac
	 */
	private String deviceMac;
	
	/**
	 * unitId
	 */
	private String unitId;
	
	/**
	 * eventName
	 */
	private String eventName;
	
	/**
	 * 行为标识
	 */
	private String activeFlag;
	
	/**
	 * wechatHeadImg
	 */
	private String wechatHeadImg;
	
	/**
	 * targetBeaconCode
	 */
	private String targetBeaconCode;
	
	/**
	 * targetBeaconMac
	 */
	private String targetBeaconMac;
	
	public BeaconActive() {
		super();
	}

	public BeaconActive(
			String arriveTime, Date leaveTime, Integer stayTime, String beaconMac, String deviceMac) {
		super();
		this.arriveTime = arriveTime;
		this.leaveTime = leaveTime;
		this.stayTime = stayTime;
		this.beaconMac = beaconMac;
		this.deviceMac = deviceMac;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getPostionCode() {
		return postionCode;
	}

	public void setPostionCode(String postionCode) {
		this.postionCode = postionCode;
	}

	public String getBoothName() {
		return boothName;
	}

	public void setBoothName(String boothName) {
		this.boothName = boothName;
	}

	public String getArriveTime() {
		return arriveTime;
	}

	public void setArriveTime(String arriveTime) {
		this.arriveTime = arriveTime;
	}

	public Date getLeaveTime() {
		return leaveTime;
	}

	public void setLeaveTime(Date leaveTime) {
		this.leaveTime = leaveTime;
	}

	public Integer getStayTime() {
		return stayTime;
	}

	public void setStayTime(Integer stayTime) {
		this.stayTime = stayTime;
	}

	public String getBeaconMac() {
		return beaconMac;
	}

	public void setBeaconMac(String beaconMac) {
		this.beaconMac = beaconMac;
	}

	public String getDeviceMac() {
		return deviceMac;
	}

	public void setDeviceMac(String deviceMac) {
		this.deviceMac = deviceMac;
	}

	public String getUnitId() {
		return unitId;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}
	
	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getWechatHeadImg() {
		return wechatHeadImg;
	}

	public void setWechatHeadImg(String wechatHeadImg) {
		this.wechatHeadImg = wechatHeadImg;
	}

	public String getTargetBeaconMac() {
		return targetBeaconMac;
	}

	public void setTargetBeaconMac(String targetBeaconMac) {
		this.targetBeaconMac = targetBeaconMac;
	}

	public String getTargetBeaconCode() {
		return targetBeaconCode;
	}

	public void setTargetBeaconCode(String targetBeaconCode) {
		this.targetBeaconCode = targetBeaconCode;
	}

	@Override
	public String toString() {
		return "BeaconActive [id=" + id + ", memberId=" + memberId + ", memberEmail=" + memberEmail + ", memberName="
				+ memberName + ", companyName=" + companyName + ", postionCode=" + postionCode + ", boothName="
				+ boothName + ", arriveTime=" + arriveTime + ", leaveTime=" + leaveTime + ", stayTime=" + stayTime
				+ ", beaconMac=" + beaconMac + ", deviceMac=" + deviceMac + ", unitId=" + unitId + ", eventName="
				+ eventName + ", activeFlag=" + activeFlag + ", wechatHeadImg=" + wechatHeadImg + ", targetBeaconCode="
				+ targetBeaconCode + ", targetBeaconMac=" + targetBeaconMac + "]";
	}
}
