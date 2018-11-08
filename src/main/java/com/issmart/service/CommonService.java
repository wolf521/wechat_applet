package com.issmart.service;

import com.aliyun.fc.runtime.Context;

/**
 * 通用数据服务
 * 
 * @author Administrator
 *
 */
public interface CommonService {
	
	/**
	 * 获取微信基础应用的access_token
	 * 
	 * @return
	 */
	String queryAccessToken(Context context,String appId);
}
