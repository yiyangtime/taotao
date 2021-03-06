package com.taotao.service;

import com.taotao.pojo.EUDataGridResult;
import com.taotao.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;

public interface ItemService {

	/**
	 * 根据商品id查询商品信息
	 * @param itemId
	 * @return
	 */
	TbItem getItemById(long itemId);
	/**
	 * 分页查询商品列表
	 * @param page
	 * @param rows
	 * @return
	 */
	EUDataGridResult getItemList(int page, int rows);
	/**
	 * 添加商品信息
	 * @param item
	 * @return
	 */
	TaotaoResult createItem(TbItem item,String desc,String itemParams) throws Exception;
}
