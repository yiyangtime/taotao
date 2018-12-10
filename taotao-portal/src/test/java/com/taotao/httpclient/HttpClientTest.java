package com.taotao.httpclient;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

public class HttpClientTest {
	@Test
	public void doGet() throws Exception {
		// 创建一个httpclient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		// 创建一个GET对象
		HttpGet get = new HttpGet("http://www.baidu.com");
		// 执行请求
		CloseableHttpResponse response = httpClient.execute(get);
		// 取响应的结果
		// 状态码
		int statusCode = response.getStatusLine().getStatusCode();
		System.out.println(statusCode);
		HttpEntity entity = response.getEntity();
		String string = EntityUtils.toString(entity, "utf-8");
		System.out.println(string);
		// 关闭httpClient
		response.close();
		httpClient.close();
	}

	@Test
	public void doGetWithParam() throws Exception {
		// 创建一个httpclient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		// 创建uri对象
		URIBuilder builder = new URIBuilder("http://www.sogou.com");
		builder.addParameter("query", "花千骨");
		// 创建一个GET对象
		HttpGet get = new HttpGet(builder.build());
		// 执行请求
		CloseableHttpResponse response = httpClient.execute(get);
		// 取响应的结果
		// 状态码
		int statusCode = response.getStatusLine().getStatusCode();
		System.out.println("status:" + statusCode);
		HttpEntity entity = response.getEntity();
		String string = EntityUtils.toString(entity, "utf-8");
		System.out.println(string);
		// 关闭httpClient
		response.close();
		httpClient.close();

	}

	@Test
	public void doPost() throws Exception {
		// 创建一个httpClient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		// 创建一个post对象
		HttpPost post = new HttpPost(
				"http://localhost:8082/httpclient/post.action");
		// 执行请求
		CloseableHttpResponse response = httpClient.execute(post);
		// 响应结果
		String string = EntityUtils.toString(response.getEntity(), "utf-8");
		System.out.println(string);
		// 关闭
		response.close();
		httpClient.close();
	}

	@Test
	public void doPostWithParam() throws Exception {
		// 创建一个httpClient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		// 创建一个POST对象
		HttpPost post = new HttpPost(
				"http://localhost:8082/httpclient/post.action");
		// 创建一个entity
		List<NameValuePair> kvList = new ArrayList<>();
		kvList.add(new BasicNameValuePair("username", "zhangsan"));
		kvList.add(new BasicNameValuePair("password", "123"));
		// 包装成一个entity类
		StringEntity entity = new UrlEncodedFormEntity(kvList);
		// 设置请求内容
		post.setEntity(entity);
		// 执行请求
		CloseableHttpResponse response = httpClient.execute(post);
		// 响应结果
		String string = EntityUtils.toString(response.getEntity(), "utf-8");
		System.out.println(string);
		// 关闭
		response.close();
		httpClient.close();
	}
}
