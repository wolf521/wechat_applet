package com.issmart.function;

import java.util.HashMap;
import java.util.Map;

import com.aliyun.fc.runtime.Context;
import com.aliyun.fc.runtime.PojoRequestHandler;
import com.issmart.model.Dictionary;
import com.issmart.model.Response;
import com.issmart.service.DictionaryService;
import com.issmart.service.impl.DictionaryServiceImpl;

/**
 * 查询字典信息
 * 
 * @author Administrator
 *
 */
public class QueryDictionary implements PojoRequestHandler<Map<String, Object>, Map<String, Object>> {

	@Override
	public Map<String, Object> handleRequest(Map<String, Object> requestParam, Context context) {
		// 返回格式
		Map<String, Object> result = new HashMap<>();
		Map<String, String> headers = new HashMap<>();
		Response response = new Response();
		result.put("isBase64Encoded", false);
		result.put("statusCode", 200);
		result.put("headers", headers);
		context.getLogger().info("查询字典信息参数："+requestParam);
		try {
			// 获取参数
			@SuppressWarnings("unchecked")
			Map<String, Object> queryParameters = (Map<String, Object>) requestParam.get("queryParameters");
			if (queryParameters.get("unitId") == null || queryParameters.get("elementCode") == null) {
				result.put("body", "The param is empty");
				return result;
			}
			String unitId = (String) queryParameters.get("unitId");
			String elementCode = queryParameters.get("elementCode").toString();
			DictionaryService dictionaryService = new DictionaryServiceImpl();
			Dictionary dictionary = dictionaryService.queryDictionary(unitId, elementCode);
			context.getLogger().info("查询字典信息结果："+dictionary.toString());
			response.success(dictionary);
			result.put("body", response);
		} catch (Exception e) {
			context.getLogger().info("查询字典信息异常："+e.getMessage());
			response.failure("param:"+requestParam);
			result.put("body", response);
		}
		return result;
	}
}
