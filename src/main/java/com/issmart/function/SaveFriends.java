package com.issmart.function;

import java.util.HashMap;
import java.util.Map;

import com.aliyun.fc.runtime.Context;
import com.aliyun.fc.runtime.PojoRequestHandler;
import com.issmart.model.Friend;
import com.issmart.model.Response;
import com.issmart.service.FriendsService;
import com.issmart.service.impl.FriendsServiceImpl;
import com.issmart.util.BusinessUtil;

/**
 * 保存好友
 * 
 * @author Administrator
 *
 */
public class SaveFriends implements PojoRequestHandler<Map<String, Object>, Map<String, Object>> {

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
			context.getLogger().info("保存好友参数："+bodyBase64);
			// 获取body参数
			Friend friend = BusinessUtil.proParamAPIGatewayBodyToFriend(bodyBase64);
			if(friend == null) {
				result.put("body", "参数解密异常");
				return result;
			}
			FriendsService friendsService = new FriendsServiceImpl();
			response.success(friendsService.saveFriends(friend));
			result.put("body", response);
		} catch (Exception e) {
			context.getLogger().info("保存好友异常："+e.getMessage());
			response.failure(e.getMessage());
			result.put("body", response);
		}
		return result;
	}
}
