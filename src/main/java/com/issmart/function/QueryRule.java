package com.issmart.function;

import java.util.HashMap;
import java.util.Map;

import com.aliyun.fc.runtime.Context;
import com.aliyun.fc.runtime.PojoRequestHandler;
import com.issmart.model.Response;
import com.issmart.service.ScanService;
import com.issmart.service.impl.ScanServiceImpl;

/**
 * 查询扫描规则
 * 
 * @author Administrator
 *
 */
public class QueryRule implements PojoRequestHandler<Map<String, Object>, Map<String, Object>> {

	@Override
	public Map<String, Object> handleRequest(Map<String, Object> requestParam, Context context) {
		// 返回格式
		Map<String, Object> result = new HashMap<>();
		Map<String, String> headers = new HashMap<>();
		Response response = new Response();
		result.put("isBase64Encoded", false);
		result.put("statusCode", 200);
		result.put("headers", headers);
		context.getLogger().info("查询扫描规则参数："+requestParam);
		try {
			// 获取参数
			@SuppressWarnings("unchecked")
			Map<String, Object> queryParameters = (Map<String, Object>) requestParam.get("queryParameters");
			if (queryParameters.get("unitId") == null) {
				result.put("body", "The param is empty");
				return result;
			}
			String unitId = queryParameters.get("unitId").toString();
			ScanService scanService = new ScanServiceImpl();
			Map<String,Object> list = scanService.queryRule(unitId);
			response.success(list);
			result.put("body", response);
		} catch (Exception e) {
			context.getLogger().info("查询扫描规则异常："+e.getMessage());
		}
		return result;
	}
}
