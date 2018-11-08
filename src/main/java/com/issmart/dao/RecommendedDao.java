package com.issmart.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface RecommendedDao {
	
	/**
	 * 查询推荐展台信息
	 * 
	 * @param unitIid
	 * @param deviceMacList
	 * @return
	 */
	List<Map<String,Object>> queryBoothInfo(@Param("unitId") String unitIid,@Param("deviceMac") String deviceMac);
	
	/**
	 * 查询推荐用户信息
	 * 
	 * @param unitIid
	 * @param beaconMacList
	 * @return
	 */
	List<Map<String,Object>> queryMemberInfo(@Param("unitId") String unitIid,@Param("beaconMac") String beaconMac);

	/**
	 * 查询推荐展台信息
	 * 
	 * @param unitIid
	 * @return
	 */
	List<Map<String,Object>> queryBoothInfoByUnitId(@Param("unitId") String unitIid);
	
}
