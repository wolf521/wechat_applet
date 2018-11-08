package com.issmart.service;

import java.util.List;

import com.issmart.model.BeaconActive;

/**
 * 轨迹数据服务
 * 
 * @author Administrator
 *
 */
public interface ActiveService {
	/**
	 * 查询个人参展信息
	 * 
	 * @param unitId
	 * @param beaconCode
	 * @return
	 */
	List<BeaconActive> queryActive(String unitId,String beaconCode);
}
