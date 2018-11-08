package com.issmart.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;

public class HttpUtils {

	/**
	 * 向指定URL发送GET方法的请求
	 * 
	 */
	public static String sendGetRequest(String url) {
		BufferedReader in = null;
		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			URLConnection connection = realUrl.openConnection();
			// 设置通用的请求属性
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(5000);
			// 建立实际的连接
			connection.connect();
			// 定义 BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuffer sb = new StringBuffer();
			String line;
			while ((line = in.readLine()) != null) {
				sb.append(line);
			}
			return sb.toString();
		} catch (Exception e) {

		}
		// 使用finally块来关闭输入流
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * .httpRequestPost("http://api.issmart.com.cn/config/push/device/booth/relation",
	 * JSON.toJSONString(paramDevice));
	 * 
	 * @param requestUrl
	 * @param outputStr
	 * @return
	 */
	public static boolean httpRequestPost(String requestUrl, String outputStr) {
		boolean result = false;
		try {
			// 建立连接
			URL url = new URL(requestUrl);
			HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
			// 设置参数
			httpConn.setDoOutput(true); // 需要输出
			httpConn.setDoInput(true); // 需要输入
			httpConn.setUseCaches(false); // 不允许缓存
			httpConn.setRequestMethod("POST"); // 设置POST方式连接
			// 设置请求属性
			httpConn.setRequestProperty("Content-Type", "application/json");
			httpConn.setRequestProperty("Charset", "UTF-8");
			// 连接,也可以不用明文connect，使用下面的httpConn.getOutputStream()会自动connect
			httpConn.connect();
			// 建立输入流，向指向的URL传入参数
			DataOutputStream dos = new DataOutputStream(httpConn.getOutputStream());
			dos.write(outputStr.getBytes());
			dos.flush();
			dos.close();
			// 获得响应状态
			int resultCode = httpConn.getResponseCode();
			if (HttpURLConnection.HTTP_OK == resultCode) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * .sendPostRequest("http://api.issmart.com.cn/config/push/device/booth/relation",
	 * JSON.toJSONString(paramDevice));
	 * 
	 * @param requestUrl
	 * @param outputStr
	 * @return
	 */
	public static String sendPostRequest(String requestUrl, String outputStr) {
		String result = null;
		try {
			// 建立连接
			URL url = new URL(requestUrl);
			HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
			// 设置参数
			httpConn.setDoOutput(true); // 需要输出
			httpConn.setDoInput(true); // 需要输入
			httpConn.setUseCaches(false); // 不允许缓存
			httpConn.setRequestMethod("POST"); // 设置POST方式连接
			// 设置请求属性
			httpConn.setRequestProperty("Content-Type", "application/json");
			httpConn.setRequestProperty("Charset", "UTF-8");
			// 连接,也可以不用明文connect，使用下面的httpConn.getOutputStream()会自动connect
			httpConn.connect();
			// 建立输入流，向指向的URL传入参数
			DataOutputStream dos = new DataOutputStream(httpConn.getOutputStream());
			dos.write(outputStr.getBytes());
			dos.flush();
			dos.close();
			// 获得响应状态
			int resultCode = httpConn.getResponseCode();
			if (HttpURLConnection.HTTP_OK == resultCode) {
				BufferedReader in = new BufferedReader(new InputStreamReader(httpConn.getInputStream()));
				StringBuffer sb = new StringBuffer();
				String line;
				while ((line = in.readLine()) != null) {
					sb.append(line);
				}
				result = sb.toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static void main(String[] args) {
		Map<String, Object> map = new HashMap<>();
		map.put("appid", "5215264");
		map.put("table_name", "user_action");
		List<Map<String, Object>> list = new ArrayList<>();
		Map<String, Object> map1 = new HashMap<>();
		map1.put("cmd", "add");
		Map<String, Object> map2 = new HashMap<>();
		map2.put("timestamp", 1538965216);
		map2.put("action_type", "visit");
		map2.put("action_num", "1");
		map2.put("action_detail", "用户对场地进行访问活动");
		map2.put("userid", "919_F0F8F2DA9B36");
		map2.put("itemid", "919_00:1f:c2:26:54:65");
		map1.put("fields", map2);
		list.add(map1);
		map.put("table_content", list);
		System.out.println(sendPostRequest("http://datareportapi.datagrand.com/data/yisizhi", JSON.toJSONString(map)));
	}
}
