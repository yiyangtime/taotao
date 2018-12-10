package com.taotao.portal.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.taotao.pojo.TaotaoResult;
import com.taotao.portal.pojo.Order;
import com.taotao.portal.service.OrderService;
import com.taotao.utils.HttpClientUtil;
import com.taotao.utils.JsonUtils;

@Service
public class OrderServiceImpl implements OrderService {
	@Value("${ORDER_BASE_URL}")
	private String ORDER_BASE_URL;
	@Value("${ORDER_CREATE_URL}")
	private String ORDER_CREATE_URL;

	@Override
	public String createOrder(Order order) {
		//调用创建订单服务之前补全用户信息
		//从cookie中获取TT_TOKEN的内容，根据token调用sso系统的服务获取用户信息
		// 调用taotao-order服务
		String json = HttpClientUtil.doPostJson(ORDER_BASE_URL
				+ ORDER_CREATE_URL, JsonUtils.objectToJson(order));
		// 把json转换成TaotaoResult
		TaotaoResult result = TaotaoResult.format(json);
		if (result.getStatus() == 200) {
			Object orderId =result.getData();
			return orderId.toString();
		}
		return "";
	}

}
