package com.issmart.model;

/**
 * 推荐参数实体
 * 
 * @author Administrator
 *
 */
public class RecommendedInfoBySelf {
	/**
	 * data
	 */
	private RecommendedBoothInfo data; 
	/**
	 * success
	 */
	private boolean success;
	
	public RecommendedBoothInfo getData() {
		return data;
	}
	public void setData(RecommendedBoothInfo data) {
		this.data = data;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	} 
}

