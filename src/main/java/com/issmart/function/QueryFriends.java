package com.issmart.function;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aliyun.fc.runtime.Context;
import com.aliyun.fc.runtime.PojoRequestHandler;
import com.issmart.model.Response;
import com.issmart.service.FriendsService;
import com.issmart.service.impl.FriendsServiceImpl;

/**
 * 查询好友信息
 * 
 * @author Administrator
 *
 */
public class QueryFriends implements PojoRequestHandler<Map<String, Object>, Map<String, Object>> {

	@Override
	public Map<String, Object> handleRequest(Map<String, Object> requestParam, Context context) {
		// 返回格式
		Map<String, Object> result = new HashMap<>();
		Map<String, String> headers = new HashMap<>();
		Response response = new Response();
		result.put("isBase64Encoded", false);
		result.put("statusCode", 200);
		result.put("headers", headers);
		context.getLogger().info("查询好友信息参数："+requestParam);
		try {
			// 获取参数
			@SuppressWarnings("unchecked")
			Map<String, Object> queryParameters = (Map<String, Object>) requestParam.get("queryParameters");
			if (queryParameters.get("unitId") == null || queryParameters.get("beaconCode") == null) {
				result.put("body", "The param is empty");
				return result;
			}
			String unitId = (String) queryParameters.get("unitId");
			String beaconCode = queryParameters.get("beaconCode").toString();
		
			FriendsService friendsService = new FriendsServiceImpl();
			List<Map<String,Object>> list = friendsService.queryFriends(unitId,beaconCode);
			response.success(list);
			result.put("body", response);
		} catch (Exception e) {
			context.getLogger().info("查询好友信息异常："+e.getMessage());
			response.failure("param:"+requestParam);
			result.put("body", response);
		}
		return result;
	}
}
