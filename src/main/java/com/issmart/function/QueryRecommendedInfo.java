package com.issmart.function;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aliyun.fc.runtime.Context;
import com.aliyun.fc.runtime.PojoRequestHandler;
import com.issmart.model.RecommendedInfo;
import com.issmart.model.Response;
import com.issmart.service.RecommendedService;
import com.issmart.service.impl.RecommendedServiceImpl;

/**
 * 查询推荐信息信息
 * 
 * @author Administrator
 *
 */
public class QueryRecommendedInfo implements PojoRequestHandler<Map<String, Object>, Map<String, Object>> {

	@Override
	public Map<String, Object> handleRequest(Map<String, Object> requestParam, Context context) {
		// 返回格式
		Map<String, Object> result = new HashMap<>();
		Map<String, String> headers = new HashMap<>();
		Response response = new Response();
		result.put("isBase64Encoded", false);
		result.put("statusCode", 200);
		result.put("headers", headers);
		context.getLogger().info("查询推荐信息信息参数："+requestParam);
		try {
			// 获取参数
			@SuppressWarnings("unchecked")
			Map<String, Object> queryParameters = (Map<String, Object>) requestParam.get("queryParameters");
			if (queryParameters.get("unitId") == null || queryParameters.get("beaconMac") == null
					||queryParameters.get("boothSize") == null||queryParameters.get("memberSize") == null) {
				result.put("body", "The param is empty");
				return result;
			}
			RecommendedInfo recommendedInfo = new RecommendedInfo();
			recommendedInfo.setUnitId(queryParameters.get("unitId").toString());
			recommendedInfo.setBeaconMac(queryParameters.get("beaconMac").toString());
			recommendedInfo.setBoothSize(Integer.parseInt(queryParameters.get("boothSize").toString()));
			recommendedInfo.setMemberSize(Integer.parseInt(queryParameters.get("memberSize").toString()));
			RecommendedService recommendedService = new RecommendedServiceImpl();
			Map<String, List<Map<String, Object>>> list = recommendedService.queryRecommendedInfoBySelf(context,recommendedInfo);
			response.success(list);
			result.put("body", response);
		} catch (Exception e) {
			context.getLogger().info("查询推荐信息信息异常："+e.getMessage());
		}
		return result;
	}
}
