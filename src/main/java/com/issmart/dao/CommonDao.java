package com.issmart.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface CommonDao {
	
	/**
	 * 获取微信基础应用的access_token
	 * 
	 * @return
	 */
	int insertAccessToken(@Param("appId") String appId,@Param("accessToken") String accessToken);
	
	/**
	 * 获取微信基础应用的access_token
	 * 
	 * @return
	 */
	int updateAccessToken(@Param("appId") String appId,@Param("accessToken") String accessToken);
	
	/**
	 * 获取微信基础应用的access_token
	 * 
	 * @return
	 */
	String queryAccessToken(@Param("appId") String appId);
}
