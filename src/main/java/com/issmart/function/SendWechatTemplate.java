package com.issmart.function;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.aliyun.fc.runtime.Context;
import com.aliyun.fc.runtime.PojoRequestHandler;
import com.issmart.model.Response;
import com.issmart.service.impl.CommonServiceImpl;
import com.issmart.util.BusinessUtil;
import com.issmart.util.HttpUtils;

/**
 * 发送微信模板消息
 * 
 * @param unitId
 * @param deviceMac
 * @return
 */
public class SendWechatTemplate implements PojoRequestHandler<Map<String, Object>, Map<String, Object>> {

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
			context.getLogger().info("发送微信模板消息参数："+bodyBase64);
			// 获取body参数
			Map<String, Object> map = BusinessUtil.proParamAPIGatewayBodyToMap(bodyBase64);
			if(map == null) {
				result.put("body", "参数解密异常");
				return result;
			}
			String access_token = new CommonServiceImpl().queryAccessToken(context, "wxc1f17015fdcb2e73");
			response.success(sendTemplate(access_token,map));
			result.put("body", response);
		} catch (Exception e) {
			context.getLogger().info("保存用户参数异常："+e.getMessage());
			response.failure(e.getMessage());
			result.put("body", response);
		}
		return result;
	}
	
	private String sendTemplate(String access_token,Map<String, Object> map) {
		String url = "https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send?access_token="+access_token;
		return HttpUtils.sendPostRequest(url,JSON.toJSONString(map));
	}
}
