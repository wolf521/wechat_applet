package com.issmart.model;

import java.util.List;
import java.util.Map;

/**
 * 推荐参数实体
 * 
 * @author Administrator
 *
 */
public class RecommendedInfo {
	/**
	 * unitId
	 */
	private String unitId; 
	/**
	 * beaconMac
	 */
	private String beaconMac; 
	/**
	 * 查询场地推荐数量
	 */
	private int boothSize; 
	/**
	 * 查询用户推荐数量
	 */
	private int memberSize; 
	/**
	 * 推荐查询人唯一标识（unitId_beaconMac）
	 */
	private String userId; 
	/**
	 * 推荐场地分类
	 */
	@SuppressWarnings("unused")
	private String boothCateId; 
	/**
	 * 推荐用户分类
	 */
	@SuppressWarnings("unused")
	private String memberCateId; 
	/**
	 * 推荐查询结果状态
	 */
	private String status; 
	/**
	 * 推荐查询结果数据
	 */
	private List<Map<String,String>> recdata; 
	/**
	 * 推荐查询结果Id
	 */
	private String request_id;
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
	public int getBoothSize() {
		return boothSize;
	}
	public void setBoothSize(int boothSize) {
		this.boothSize = boothSize;
	}
	public int getMemberSize() {
		return memberSize;
	}
	public void setMemberSize(int memberSize) {
		this.memberSize = memberSize;
	}
	public String getUserId() {
		return this.unitId+"_"+this.beaconMac;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<Map<String, String>> getRecdata() {
		return recdata;
	}
	public void setRecdata(List<Map<String, String>> recdata) {
		this.recdata = recdata;
	}
	public String getRequest_id() {
		return request_id;
	}
	public void setRequest_id(String request_id) {
		this.request_id = request_id;
	}
	
	public String getBoothCateId() {
		return "booth_"+this.unitId;
	}
	public String getMemberCateId() {
		return "member_"+this.unitId;
	}
	@Override
	public String toString() {
		return "RecommendedInfo [unitId=" + unitId + ", beaconMac=" + beaconMac + ", boothSize=" + boothSize
				+ ", memberSize=" + memberSize + ", userId=" + userId + ", status=" + status + ", recdata=" + recdata
				+ ", request_id=" + request_id + "]";
	} 
}
