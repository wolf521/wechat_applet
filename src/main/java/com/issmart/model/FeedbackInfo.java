package com.issmart.model;

import java.util.Map;

/**
 * 推荐反馈信息实体
 * 
 * @author Administrator
 *
 */
public class FeedbackInfo {

	private String cmd;
	
	private Map<String,Object> fields;

	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public Map<String, Object> getFields() {
		return fields;
	}

	public void setFields(Map<String, Object> fields) {
		this.fields = fields;
	}

	@Override
	public String toString() {
		return "FeedbackInfo [cmd=" + cmd + ", fields=" + fields + "]";
	}
}
