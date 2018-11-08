package com.issmart.function;

import java.util.HashMap;
import java.util.Map;

import com.aliyun.fc.runtime.Context;
import com.aliyun.fc.runtime.PojoRequestHandler;
import com.issmart.model.CardMessage;
import com.issmart.model.Response;
import com.issmart.service.CardService;
import com.issmart.service.impl.CardServiceImpl;
import com.issmart.util.BusinessUtil;

/**
 * 查询beacon中保存的名片信息
 * 
 * @author Administrator
 *
 */
public class QueryMemberInfoFromCard implements PojoRequestHandler<Map<String, Object>, Map<String, Object>> {

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
			context.getLogger().info("查询beacon中保存的名片信息参数："+bodyBase64);
			// 获取body参数
			CardMessage cardMessage = BusinessUtil.proParamAPIGatewayBodyToCardMessage(bodyBase64);
			if(cardMessage == null || cardMessage.getTargetBeaconMacList().size() == 0) {
				result.put("body", "未保存名片信息");
				return result;
			}
			CardService cardService = new CardServiceImpl();
			response.success(cardService.queryCardMessage(cardMessage));
			result.put("body", response);
		} catch (Exception e) {
			context.getLogger().info("查询beacon中保存的名片信息异常："+e.getMessage());
		}
		return result;
	}
}
