package com.issmart.util;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.issmart.model.CardMessage;
import com.issmart.model.FeedbackInfo;
import com.issmart.model.Friend;
import com.issmart.model.Member;
import com.issmart.model.Response;
import com.issmart.model.ScanInfo;

public class BusinessUtil {

	// 字符串空校验
	public static boolean stringIsEmpty(String str) {

		if (str == null || str.equals("") || str.equals("null") || str.equals("NULL")) {
			return true;
		} else {
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	public static Map<String, Object> proParamAPIGatewayBodyToMap(String bodyBase64) {
		byte[] bodyByte = Base64.getDecoder().decode(bodyBase64);
		Map<String, Object> param = null;
		try {
			String body = new String(bodyByte, "utf-8");
			param = JSON.parseObject(body, Map.class);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return param;
	}
	
	public static Member proParamAPIGatewayBodyToMember(String bodyBase64) {
		byte[] bodyByte = Base64.getDecoder().decode(bodyBase64);
		Member member = null;
		try {
			String body = new String(bodyByte, "utf-8");
			member = JSON.parseObject(body, Member.class);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return member;
	}
	
	public static Friend proParamAPIGatewayBodyToFriend(String bodyBase64) {
		byte[] bodyByte = Base64.getDecoder().decode(bodyBase64);
		Friend friend = null;
		try {
			String body = new String(bodyByte, "utf-8");
			friend = JSON.parseObject(body, Friend.class);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return friend;
	}
	
	public static CardMessage proParamAPIGatewayBodyToCardMessage(String bodyBase64) {
		byte[] bodyByte = Base64.getDecoder().decode(bodyBase64);
		CardMessage cardMessage = null;
		try {
			String body = new String(bodyByte, "utf-8");
			cardMessage = JSON.parseObject(body, CardMessage.class);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return cardMessage;
	}
	
	public static List<ScanInfo> proParamAPIGatewayBodyToScanInfo(String bodyBase64) {
		byte[] bodyByte = Base64.getDecoder().decode(bodyBase64);
		List<ScanInfo> scanInfoList = null;
		try {
			String body = new String(bodyByte, "utf-8");
			scanInfoList = JSON.parseArray(body, ScanInfo.class);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return scanInfoList;
	}

	public static List<FeedbackInfo> proParamAPIGatewayBodyToFeedbackInfo(String bodyBase64) {
		byte[] bodyByte = Base64.getDecoder().decode(bodyBase64);
		List<FeedbackInfo> feedbackInfo = null;
		try {
			String body = new String(bodyByte, "utf-8");
			feedbackInfo = JSON.parseArray(body, FeedbackInfo.class);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return feedbackInfo;
	}

	public static void setPage(Response response, String pageNo, String pageSize, Integer count) {

		// 页码设置
		if (pageNo != null && !pageNo.equals("") && pageSize != null && !pageSize.equals("") 
				&& count != null) {

			Integer cPageNo = Integer.parseInt(pageNo);
			Integer cPageSize = Integer.parseInt(pageSize);

			Integer pageCount = count / Integer.parseInt(pageSize);

			if ((count % cPageSize) != 0) {
				pageCount += 1;
			}

			response.setPage(cPageNo, cPageSize, pageCount, count);
		}
	}

	/**
	 * 处理查询使用的pageNo
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public static Integer processPageNo(Integer pageNo, Integer pageSize) {

		Integer processPageNo = pageNo;

		// 页码处理
		if (processPageNo != null && pageNo != 0 && pageSize != null && pageSize != 0) {
			processPageNo = (processPageNo - 1) * pageSize;
		}
		return processPageNo;
	}
	
	public static String getOpenId(String code) {
		String url = "https://api.weixin.qq.com/sns/jscode2session?appid=wxc1f17015fdcb2e73&secret=54e031b229a46d2faaf51300eb330aa1&js_code="+code+"&grant_type=authorization_code";
		String result = HttpUtils.sendGetRequest(url);
		@SuppressWarnings("unchecked")
		Map<String,Object> map = JSON.parseObject(result, Map.class);
		if(map.get("openid") == null) {
			return null;
		} else {
			return map.get("openid").toString();	
		}
	}
	
	public static String getAccessToken() {
		String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wxc1f17015fdcb2e73&secret=54e031b229a46d2faaf51300eb330aa1";
		String result = HttpUtils.sendGetRequest(url);
		@SuppressWarnings("unchecked")
		Map<String,Object> map = JSON.parseObject(result, Map.class);
		if(map.get("access_token") == null) {
			return null;
		} else {
			return map.get("access_token").toString();	
		}
	}
}
