package com.issmart.service;

import java.util.List;
import java.util.Map;

import com.aliyun.fc.runtime.Context;
import com.issmart.model.RecommendedInfo;

/**
 * 推荐功能服务
 * 
 * @author Administrator
 *
 */
public interface RecommendedService {
	/**
	 * 查询个人参展信息
	 * 达观
	 * 
	 * @param unitId
	 * @param beaconCode
	 * @return
	 */
	Map<String, List<Map<String, Object>>> queryRecommendedInfo(Context context,RecommendedInfo recommendedInfo);

	/**
	 * 查询个人参展信息
	 * 自研
	 * 
	 * @param unitId
	 * @param beaconCode
	 * @return
	 */
	Map<String, List<Map<String, Object>>> queryRecommendedInfoBySelf(Context context,RecommendedInfo recommendedInfo);

}
