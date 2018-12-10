package com.taotao.search.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.taotao.pojo.TaotaoResult;
import com.taotao.search.service.ItemService;

@Controller
@RequestMapping("/manager")
public class ItemController {
	@Autowired
	private ItemService itemService;

	/**
	 * 导入商品数据到索引库
	 */
	@RequestMapping("/importAll")
	@ResponseBody
	public TaotaoResult importAll() {
		TaotaoResult result = itemService.importAllItems();
		return result;
	}
}
