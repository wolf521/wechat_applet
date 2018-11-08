package com.issmart.model;

/**
 * 个人标签实体
 * 
 * @author Administrator
 *
 */
public class MemberLabel {
	/**
	 * 主键
	 */
	private Integer id;
	/**
	 * memberId
	 */
	private Integer memberId;
	/**
	 * labelId
	 */
	private Integer labelId;
	/**
	 * labelName
	 */
	private String labelName;
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
	public Integer getLabelId() {
		return labelId;
	}
	public void setLabelId(Integer labelId) {
		this.labelId = labelId;
	}
	public String getLabelName() {
		return labelName;
	}
	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}
	@Override
	public String toString() {
		return "MemberLabel [id=" + id + ", memberId=" + memberId + ", labelId=" + labelId + ", labelName=" + labelName
				+ "]";
	}
}
