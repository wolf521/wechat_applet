package com.issmart.function;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aliyun.fc.runtime.Context;
import com.aliyun.fc.runtime.PojoRequestHandler;
import com.issmart.model.Response;
import com.issmart.model.ScanInfo;
import com.issmart.service.ScanService;
import com.issmart.service.impl.ScanServiceImpl;
import com.issmart.util.BusinessUtil;

/**
 * 查询扫描信息
 * 
 * @author Administrator
 *
 */
public class QueryMemberInfoFromScan implements PojoRequestHandler<Map<String, Object>, Map<String, Object>> {

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
			String bodyBase64 = (String) requestParam.get("body");
			if (BusinessUtil.stringIsEmpty(bodyBase64)) {
				result.put("body", "The body is empty");
				return result;
			}
			context.getLogger().info("查询扫描信息参数："+bodyBase64);
			// 获取body参数
			List<ScanInfo> scanInfoList = BusinessUtil.proParamAPIGatewayBodyToScanInfo(bodyBase64);
			if(scanInfoList == null) {
				result.put("body", "参数解密异常");
				return result;
			}
			ScanService scanService = new ScanServiceImpl();
			response.success(scanService.queryMemberInfoFromScan(scanInfoList));
			result.put("body", response);
		} catch (Exception e) {
			context.getLogger().info("查询扫描信息异常："+e.getMessage());
		}
		return result;
	}
}
