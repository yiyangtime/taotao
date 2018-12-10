package com.taotao.portal.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taotao.pojo.TaotaoResult;
import com.taotao.portal.pojo.CartItem;

public interface CartService {
	/**
	 * 添加购物车商品
	 * 
	 * @param itemId
	 * @param num
	 * @param request
	 * @param response
	 * @return
	 */
	TaotaoResult addCartItem(long itemId, int num, HttpServletRequest request,
			HttpServletResponse response);

	/**
	 * 购物车列表
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	List<CartItem> getCartItemList(HttpServletRequest request,
			HttpServletResponse response);

	/**
	 * 更新购物车商品数量
	 * 
	 * @param itemId
	 * @param num
	 * @param request
	 * @param response
	 * @return
	 */
	TaotaoResult updateNum(long itemId, int num, HttpServletRequest request,
			HttpServletResponse response);
	/**
	 * 删除购物车商品
	 * @param itemId
	 * @param request
	 * @param response
	 * @return
	 */
	TaotaoResult deleteCartItem(long itemId, HttpServletRequest request,
			HttpServletResponse response);
}
