package com.issmart.function;

import java.util.HashMap;
import java.util.Map;

import com.aliyun.fc.runtime.Context;
import com.aliyun.fc.runtime.PojoRequestHandler;
import com.issmart.model.Response;
import com.issmart.service.BoothService;
import com.issmart.service.impl.BoothServiceImpl;

/**
 * 获得展台详情
 * 数据从通用版数据库中获取
 * 
 * @author Administrator
 *
 */
public class QueryBooothDetail implements PojoRequestHandler<Map<String, Object>, Map<String, Object>> {

	@Override
	public Map<String, Object> handleRequest(Map<String, Object> requestParam, Context context) {
		// 返回格式
		Map<String, Object> result = new HashMap<>();
		Map<String, String> headers = new HashMap<>();
		Response response = new Response();
		result.put("isBase64Encoded", false);
		result.put("statusCode", 200);
		result.put("headers", headers);
		context.getLogger().info("获得展台详情参数："+requestParam);
		try {
			// 获取参数
			@SuppressWarnings("unchecked")
			Map<String, Object> queryParameters = (Map<String, Object>) requestParam.get("queryParameters");
			if (queryParameters.get("unitId") == null || queryParameters.get("deviceMac") == null) {
				result.put("body", "The param is empty");
				return result;
			}
			String unitId = (String) queryParameters.get("unitId");
			String deviceMac = queryParameters.get("deviceMac").toString();
		
			BoothService boothService = new BoothServiceImpl();
			Map<String,Object> list = boothService.getBooothDetail(unitId,deviceMac);
			response.success(list);
			result.put("body", response);
		} catch (Exception e) {
			context.getLogger().info("获得展台详情异常："+e.getMessage());
		}
		return result;
	}
}
