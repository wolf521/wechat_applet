package com.issmart.function;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.aliyun.fc.runtime.Context;
import com.aliyun.fc.runtime.PojoRequestHandler;
import com.issmart.model.FeedbackInfo;
import com.issmart.model.Response;
import com.issmart.util.BusinessUtil;
import com.issmart.util.HttpUtils;

/**
 * 发送推荐反馈信息
 * 
 * @author Administrator
 *
 */
public class SendRecommendFeedbackInfo implements PojoRequestHandler<Map<String, Object>, Map<String, Object>> {

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
			context.getLogger().info("发送推荐反馈信息参数："+bodyBase64);
			// 获取body参数
			List<FeedbackInfo> feedbackInfoList = BusinessUtil.proParamAPIGatewayBodyToFeedbackInfo(bodyBase64);
			if(feedbackInfoList == null) {
				result.put("body", "参数解密异常");
				return result;
			}
			Map<String, Object> map = new HashMap<>();
			map.put("appid", "5215264");
			map.put("table_name", "user_action");
			map.put("table_content", feedbackInfoList);
			context.getLogger().info("发送推荐反馈信息解密后参数："+map);
			String requestUrl = "http://datareportapi.datagrand.com/data/yisizhi";
			String sendResult = HttpUtils.sendPostRequest(requestUrl, JSON.toJSONString(map));
			context.getLogger().info("发送推荐反馈信息结果："+sendResult);
			response.success(sendResult);
			result.put("body", response);
		} catch (Exception e) {
			context.getLogger().info("发送推荐反馈信息异常："+e.getMessage());
		}
		return result;
	}
}
