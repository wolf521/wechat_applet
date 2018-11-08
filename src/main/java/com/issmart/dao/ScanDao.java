package com.issmart.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Param;


public interface ScanDao {
	
	/**
	 * 查询扫描规则
	 * 
	 * @param unitId
	 * @return
	 */
	Map<String,Object>  queryRule(@Param("unitId") String unitId);
	
	/**
	 * 查询扫描信息
	 * 
	 * @param unitId
	 * @return
	 */
	Map<String,Object> queryMemberInfoFromScan(@Param("unitId") String unitId,@Param("targetBeaconMac") String targetBeaconMac,@Param("beaconCode") String beaconCode,@Param("rssi") Integer rssi);
}
