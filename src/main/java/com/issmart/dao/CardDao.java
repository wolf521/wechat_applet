package com.issmart.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface CardDao {
	
	/**
	 * 插叙某会议所有beacon
	 * 
	 * @param unitId
	 * @return
	 */
	List<String> queryBeaconMacInfo(@Param("unitId") String unitId);
	
	/**
	 * 查询beaconMac列表信息
	 * 
	 * @param unitId
	 * @param beaconMacList
	 * @return
	 */
	List<Map<String, Object>> queryCardsInfo(@Param("unitId") String unitId,@Param("beaconMacList") List<String> beaconMacList);

	/**
	 * 查询当前人的memberId
	 * 
	 * @return
	 */
	Integer queryMemberId(@Param("unitId") String unitId,@Param("beaconMac") String beaconMac);

	/**
	 * 查询beacon中保存名片与数据库中保存名片不一致的部分
	 * 
	 * @param unitId
	 * @return
	 */
	List<Integer> queryMemberIdList(@Param("unitId") String unitId,@Param("memberId") Integer memberId,@Param("beaconMacList") List<String> beaconMacList);

	/**
	 * 新建名片数据
	 * 
	 * @param memberId
	 * @param memberIdList
	 * @return
	 */
	int insertCardInfo(@Param("memberId") Integer memberId,@Param("memberIdList") List<Integer> memberIdList);
}
