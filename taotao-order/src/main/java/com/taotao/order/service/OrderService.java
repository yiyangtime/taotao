package com.taotao.order.service;

import java.util.List;

import com.taotao.pojo.TaotaoResult;
import com.taotao.pojo.TbOrder;
import com.taotao.pojo.TbOrderItem;
import com.taotao.pojo.TbOrderShipping;

public interface OrderService {
	/**
	 * 创建订单
	 * @param order
	 * @param itemList
	 * @param orderShipping
	 * @return
	 */
	TaotaoResult createOrder(TbOrder order, List<TbOrderItem> itemList,
			TbOrderShipping orderShipping);
}
