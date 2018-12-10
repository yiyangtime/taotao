package com.taotao.portal.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.taotao.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;
import com.taotao.portal.pojo.CartItem;
import com.taotao.portal.service.CartService;
import com.taotao.utils.CookieUtils;
import com.taotao.utils.HttpClientUtil;
import com.taotao.utils.JsonUtils;

@Service
public class CartServiceImpl implements CartService {

	@Value("${REST_BASE_URL}")
	private String REST_BASE_URL;
	@Value("${ITME_INFO_URL}")
	private String ITME_INFO_URL;

	/**
	 * 添加购物车商品
	 */
	@Override
	public TaotaoResult addCartItem(long itemId, int num,
			HttpServletRequest request, HttpServletResponse response) {
		// 取商品信息
		CartItem cartItem = null;
		// 取购物车商品列表
		List<CartItem> itemList = getCartItemList(request);
		// 判断购物车商品列表中是否存在此商品
		for (CartItem cItem : itemList) {
			// 如果存在此商品
			if (cItem.getId() == itemId) {
				// 增加商品数量
				cItem.setNum(cItem.getNum() + num);
				cartItem = cItem;
				break;
			}
		}
		if (cartItem == null) {
			cartItem = new CartItem();
			// 根据商品id查询商品信息
			String json = HttpClientUtil.doGet(REST_BASE_URL + ITME_INFO_URL
					+ itemId);
			// 把json转换成java对象
			TaotaoResult result = TaotaoResult.formatToPojo(json, TbItem.class);
			if (result.getStatus() == 200) {
				TbItem item = (TbItem) result.getData();
				cartItem.setId(item.getId());
				cartItem.setTitle(item.getTitle());
				cartItem.setNum(num);
				cartItem.setPrice(item.getPrice());
				cartItem.setImage(item.getImage() == null ? "" : item
						.getImage().split(",")[0]);
			}
			// 添加商品到购物车列表
			itemList.add(cartItem);
		}
		// 把购物车列表写入cookie
		CookieUtils.setCookie(request, response, "TT_CART",
				JsonUtils.objectToJson(itemList), true);
		return TaotaoResult.ok();
	}

	/**
	 * 从cookie中取商品列表
	 * 
	 * @return
	 */
	private List<CartItem> getCartItemList(HttpServletRequest request) {
		// 从cookie中取商品列表
		String cartJson = CookieUtils.getCookieValue(request, "TT_CART", true);
		if (cartJson == null) {
			return new ArrayList<>();
		}
		// 把json转换成商品列表
		try {
			List<CartItem> list = JsonUtils
					.jsonToList(cartJson, CartItem.class);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}

	/**
	 * 购物车列表
	 */
	@Override
	public List<CartItem> getCartItemList(HttpServletRequest request,
			HttpServletResponse response) {
		List<CartItem> cartList = getCartItemList(request);
		return cartList;
	}

	/**
	 * 更新购物车商品数量
	 */
	public TaotaoResult updateNum(long itemId, int num,
			HttpServletRequest request, HttpServletResponse response) {
		// 取购物车商品列表
		List<CartItem> cartList = getCartItemList(request);
		// 遍历商品列表
		for (CartItem cartItem : cartList) {
			if (cartItem.getId() == itemId) {
				cartItem.setNum(num);
				break;
			}
		}
		// 把购物车列表重新写入cookie
		CookieUtils.setCookie(request, response, "TT_CART",
				JsonUtils.objectToJson(cartList), true);
		return TaotaoResult.ok();
	}

	@Override
	public TaotaoResult deleteCartItem(long itemId, HttpServletRequest request,
			HttpServletResponse response) {
		// 从购物车中取商品
		List<CartItem> cartList = getCartItemList(request);
		// 从列表中找到此商品
		for (CartItem cartItem : cartList) {
			if (cartItem.getId() == itemId) {
				cartList.remove(cartItem);
				break;
			}
		}
		// 把购物车列表重新写入cookie
		CookieUtils.setCookie(request, response, "TT_CART",
				JsonUtils.objectToJson(cartList), true);
		return TaotaoResult.ok();
	}
}
