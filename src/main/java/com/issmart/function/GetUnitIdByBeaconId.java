package com.issmart.function;

import java.util.HashMap;
import java.util.Map;

import com.aliyun.fc.runtime.Context;
import com.aliyun.fc.runtime.PojoRequestHandler;
import com.issmart.model.Response;
import com.issmart.service.BoothService;
import com.issmart.service.impl.BoothServiceImpl;

/**
 * 通过beaconId获取unitId及beaconMac
 * 数据从数据平台中获取
 * 
 * @author Administrator
 *
 */
public class GetUnitIdByBeaconId implements PojoRequestHandler<Map<String, Object>, Map<String, Object>> {

	@Override
	public Map<String, Object> handleRequest(Map<String, Object> requestParam, Context context) {
		// 返回格式
		Map<String, Object> result = new HashMap<>();
		Map<String, String> headers = new HashMap<>();
		Response response = new Response();
		result.put("isBase64Encoded", false);
		result.put("statusCode", 200);
		result.put("headers", headers);
		context.getLogger().info("通过beaconId获取unitId及beaconMac参数："+requestParam);
		try {
			// 获取参数
			@SuppressWarnings("unchecked")
			Map<String, Object> queryParameters = (Map<String, Object>) requestParam.get("queryParameters");
			if (queryParameters.get("beaconCode") == null) {
				result.put("body", "The param is empty");
				return result;
			}
			String beaconCode = queryParameters.get("beaconCode").toString();
		
			BoothService boothService = new BoothServiceImpl();
			Map<String,Object> map = boothService.getUnitId(beaconCode);
			response.success(map);
			result.put("body", response);
		} catch (Exception e) {
			context.getLogger().info("通过beaconId获取unitId及beaconMac异常："+e.getMessage());
		}
		return result;
	}
}
