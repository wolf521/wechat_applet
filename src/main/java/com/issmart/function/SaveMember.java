package com.issmart.function;

import java.util.HashMap;
import java.util.Map;

import com.aliyun.fc.runtime.Context;
import com.aliyun.fc.runtime.PojoRequestHandler;
import com.issmart.model.Member;
import com.issmart.model.Response;
import com.issmart.service.MemberService;
import com.issmart.service.impl.MemberServiceImpl;
import com.issmart.util.BusinessUtil;

/**
 * 保存用户
 * 
 * @param unitId
 * @param deviceMac
 * @return
 */
public class SaveMember implements PojoRequestHandler<Map<String, Object>, Map<String, Object>> {

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
			context.getLogger().info("保存用户参数："+bodyBase64);
			// 获取body参数
			Member member = BusinessUtil.proParamAPIGatewayBodyToMember(bodyBase64);
			if(member == null) {
				result.put("body", "参数解密异常");
				return result;
			}
			MemberService memberService = new MemberServiceImpl();
			response.success(memberService.saveMember(member));
			result.put("body", response);
		} catch (Exception e) {
			context.getLogger().info("保存用户参数异常："+e.getMessage());
			response.failure(e.getMessage());
			result.put("body", response);
		}
		return result;
	}
}
