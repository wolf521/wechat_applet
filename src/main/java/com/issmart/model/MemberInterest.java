package com.issmart.model;

/**
 * 个人兴趣实体
 * 
 * @author Administrator
 *
 */
public class MemberInterest {
	/**
	 * 主键
	 */
	private Integer id;
	/**
	 * memberId
	 */
	private Integer memberId;
	/**
	 * interestId
	 */
	private Integer interestId;
	/**
	 * interestName
	 */
	private String interestName;
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
	public Integer getInterestId() {
		return interestId;
	}
	public void setInterestId(Integer interestId) {
		this.interestId = interestId;
	}
	public String getInterestName() {
		return interestName;
	}
	public void setInterestName(String interestName) {
		this.interestName = interestName;
	}
	@Override
	public String toString() {
		return "MemberInterest [id=" + id + ", memberId=" + memberId + ", interestId=" + interestId + ", interestName="
				+ interestName + "]";
	}
}
