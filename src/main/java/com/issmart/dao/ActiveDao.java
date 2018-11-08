package com.issmart.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.issmart.model.BeaconActive;


public interface ActiveDao {
	
	/**
	 * 根据beaconId获取beaconCode
	 * 
	 * @param unitId
	 * @return
	 */
	String getBeaconMac(@Param("unitId") String unitId,@Param("beaconCode") String beaconCode);
	

	/**
	 * 查询出某用户轨迹数据
	 * 
	 * @param unitId
	 * @return
	 */
	List<BeaconActive> queryActive(@Param("unitId") String unitId,@Param("beaconMac") String beaconMac);
	
	/**
	 * 获取按一按数据
	 * 
	 * @param unitId
	 * @param beaconCode
	 * @return
	 */
	public List<BeaconActive> queryBehaviorBtn(@Param("unitId") String unitId, @Param("beaconMac") String beaconMac);
	
	/**
	 * 获取贴一贴数据
	 * 
	 * @param unitId
	 * @param beaconCode
	 * @return
	 */
	public List<BeaconActive> queryBehaviorCard(@Param("unitId") String unitId, @Param("beaconMac") String beaconMac, @Param("beaconCode") String beaconCode);

	/**
	 * 获取好友数据
	 * 
	 * @param unitId
	 * @param beaconCode
	 * @return
	 */
	public List<BeaconActive> queryBehaviorFriends(@Param("unitId") String unitId, @Param("beaconCode") String beaconCode);

}
