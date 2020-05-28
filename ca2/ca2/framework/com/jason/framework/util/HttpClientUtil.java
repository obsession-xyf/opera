
package com.jason.framework.util;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class HttpClientUtil {
	public static String getData(String url) {
		HttpClient client = new DefaultHttpClient();
		HttpGet get = new HttpGet(url);
		String json = null;
		try {
			HttpResponse res = client.execute(get);
			if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				HttpEntity entity = res.getEntity();
				if (entity != null) {
					json = EntityUtils.toString(entity);
				}
			}
		} catch (Exception e) {

		} finally {
			// 关闭连接 ,释放资源
			client.getConnectionManager().shutdown();
		}
		if (StringUtils.isEmpty(json)) {
			json = "{\"status\":\"false\",\"msg\":\"请求失败\"}";
		}
		return json;
	}

	public static String postData(String url, String data) {
		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost(url);
		String json = null;
		try {
			StringEntity s = new StringEntity(data);
			s.setContentEncoding("UTF-8");
			s.setContentType("application/x-www-form-urlencoded");
			post.setEntity(s);

			HttpResponse res = client.execute(post);
			if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				HttpEntity entity = res.getEntity();
				if (entity != null) {
					json = EntityUtils.toString(entity);
				}
			}
		} catch (Exception e) {

		} finally {
			// 关闭连接 ,释放资源
			client.getConnectionManager().shutdown();
		}
		if (StringUtils.isEmpty(json)) {
			json = "{\"status\":\"false\",\"msg\":\"请求失败\"}";
		}
		return json;
	}

	public static void a(String json) {

	}

	public static void main(String[] args) {
		String data = getData("http://192.168.10.89:8080/ss-server/api/login.json?userName=admin&password=admin");
		System.out.println("===" + data + "==");
		String data1 = postData(
				"http://192.168.10.89:8080/ss-server/api/login.json",
				"userName=admin&password=admin");
		System.out.println("===" + data1 + "==");
	}
}
