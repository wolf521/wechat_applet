package com.issmart.function;

import java.util.HashMap;
import java.util.Map;

import com.aliyun.fc.runtime.Context;
import com.aliyun.fc.runtime.PojoRequestHandler;
import com.issmart.model.Response;
import com.issmart.service.CommonService;
import com.issmart.service.impl.CommonServiceImpl;

/**
 * 查询AccessToken
 * 
 * @author Administrator
 *
 */
public class QueryAccessToken implements PojoRequestHandler<Map<String, Object>, Map<String, Object>> {

	@Override
	public Map<String, Object> handleRequest(Map<String, Object> requestParam, Context context) {
		// 返回格式
		Map<String, Object> result = new HashMap<>();
		Map<String, String> headers = new HashMap<>();
		Response response = new Response();
		result.put("isBase64Encoded", false);
		result.put("statusCode", 200);
		result.put("headers", headers);
		try {
			CommonService commonService = new CommonServiceImpl();
			response.success(commonService.queryAccessToken(context, "wxc1f17015fdcb2e73"));
			result.put("body", response);
		} catch (Exception e) {
			context.getLogger().info("查询AccessToken异常："+e.getMessage());
		}
		return result;
	}
}
