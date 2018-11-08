package com.issmart.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;


public interface BoothDao {
	
	/**
	 * 根据beaconId获取beaconCode
	 * 
	 * @param unitId
	 * @return
	 */
	Map<String,Object> getBooothDetail(@Param("unitId") String unitId,@Param("deviceMac") String deviceMac);
	

	/**
	 * 获取unitId
	 * 
	 * @param beaconId
	 * @return
	 */
	Map<String,Object> getUnitId(@Param("beaconId") String beaconId);
	
	/**
	 * 临时使用，查询展台信息
	 * 
	 * @return
	 */
	List<Map<String,Object>> queryBoothInfo();
}
