package com.issmart.model;

import java.util.List;
import java.util.Map;

/**
 * 字典实体
 * 
 * @author Administrator
 *
 */
public class Dictionary {

	/**
	 * 主键
	 */
	private Integer id;
	/**
	 * unitd
	 */
	private Integer unitId;
	/**
	 * parentId
	 */
	private Integer parentId;
	/**
	 * 元素名
	 */
	private String elementName;
	/**
	 * 元素编码
	 */
	private String elementCode;
	/**
	 * 序号
	 */
	private Integer orderNum;
	/**
	 * 元素信息
	 */
	private List<Map<String,Object>> elementList;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUnitId() {
		return unitId;
	}
	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public String getElementName() {
		return elementName;
	}
	public void setElementName(String elementName) {
		this.elementName = elementName;
	}
	public String getElementCode() {
		return elementCode;
	}
	public void setElementCode(String elementCode) {
		this.elementCode = elementCode;
	}
	public Integer getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}
	public List<Map<String, Object>> getElementList() {
		return elementList;
	}
	public void setElementList(List<Map<String, Object>> elementList) {
		this.elementList = elementList;
	}
	@Override
	public String toString() {
		return "Dictionary [id=" + id + ", unitId=" + unitId + ", parentId=" + parentId + ", elementName=" + elementName
				+ ", elementCode=" + elementCode + ", orderNum=" + orderNum + ", elementList=" + elementList + "]";
	}
}
