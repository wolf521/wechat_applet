package com.issmart.model;

import java.util.List;

/**
 * 参会人员实体
 * 
 * @author Administrator
 *
 */
public class Member {
	/**
	 * 主键
	 */
	private Integer id;
	/**
	 * memberId
	 */
	private Integer memberId;
	/**
	 * unitd
	 */
	private String unitId;
	/**
	 * 修改标记
	 */
	private String updateLabel;
	/**
	 * 名称
	 */
	private String memberName;
	/**
	 * 邮箱
	 */
	private String memberEmail;
	/**
	 * 电话
	 */
	private String memberPhone;
	/**
	 * 公司名称
	 */
	private String companyName;
	/**
	 * 职位id
	 */
	private Integer postionId;
	/**
	 * 职位
	 */
	private String postion;
	/**
	 * 行业id
	 */
	private Integer industryId;
	/**
	 * 行业
	 */
	private String industry;
	/**
	 * 微信头像
	 */
	private String wechatHeadImg;
	/**
	 * 微信昵称
	 */
	private String wechatNickname;
	/**
	 * beaconMac
	 */
	private String beaconMac;
	/**
	 * beaconCode
	 */
	private String beaconCode;
	/**
	 * 隐私开关
	 */
	private String openPrivacy;
	/**
	 * openId
	 */
	private String openId;
	/**
	 * 标签
	 */
	private List<MemberLabel> memberLabelList;
	/**
	 * 兴趣
	 */
	private List<MemberInterest> memberInterestList;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	public String getUnitId() {
		return unitId;
	}
	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getPostion() {
		return postion;
	}
	public void setPostion(String postion) {
		this.postion = postion;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public String getWechatHeadImg() {
		return wechatHeadImg;
	}
	public void setWechatHeadImg(String wechatHeadImg) {
		this.wechatHeadImg = wechatHeadImg;
	}
	public String getWechatNickname() {
		return wechatNickname;
	}
	public void setWechatNickname(String wechatNickname) {
		this.wechatNickname = wechatNickname;
	}
	public String getBeaconMac() {
		return beaconMac;
	}
	public void setBeaconMac(String beaconMac) {
		this.beaconMac = beaconMac;
	}
	public String getBeaconCode() {
		return beaconCode;
	}
	public void setBeaconCode(String beaconCode) {
		this.beaconCode = beaconCode;
	}
	public List<MemberLabel> getMemberLabelList() {
		return memberLabelList;
	}
	public void setMemberLabelList(List<MemberLabel> memberLabelList) {
		this.memberLabelList = memberLabelList;
	}
	public List<MemberInterest> getMemberInterestList() {
		return memberInterestList;
	}
	public void setMemberInterestList(List<MemberInterest> memberInterestList) {
		this.memberInterestList = memberInterestList;
	}
	public Integer getPostionId() {
		return postionId;
	}
	public void setPostionId(Integer postionId) {
		this.postionId = postionId;
	}
	public Integer getIndustryId() {
		return industryId;
	}
	public void setIndustryId(Integer industryId) {
		this.industryId = industryId;
	}
	
	public String getUpdateLabel() {
		return updateLabel;
	}
	public void setUpdateLabel(String updateLabel) {
		this.updateLabel = updateLabel;
	}
	public String getOpenPrivacy() {
		return openPrivacy;
	}
	public void setOpenPrivacy(String openPrivacy) {
		this.openPrivacy = openPrivacy;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	@Override
	public String toString() {
		return "Member [id=" + id + ", memberId=" + memberId + ", unitId=" + unitId + ", updateLabel=" + updateLabel
				+ ", memberName=" + memberName + ", memberEmail=" + memberEmail + ", memberPhone=" + memberPhone
				+ ", companyName=" + companyName + ", postionId=" + postionId + ", postion=" + postion + ", industryId="
				+ industryId + ", industry=" + industry + ", wechatHeadImg=" + wechatHeadImg + ", wechatNickname="
				+ wechatNickname + ", beaconMac=" + beaconMac + ", beaconCode=" + beaconCode + ", openPrivacy="
				+ openPrivacy + ", openId=" + openId + ", memberLabelList=" + memberLabelList + ", memberInterestList="
				+ memberInterestList + "]";
	}
}
