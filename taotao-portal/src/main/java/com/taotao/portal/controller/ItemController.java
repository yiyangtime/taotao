package com.taotao.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.portal.pojo.ItemInfo;
import com.taotao.portal.service.ItemService;

@Controller
@RequestMapping("/item")
public class ItemController {
	@Autowired
	private ItemService itemService;

	@RequestMapping(value = "/{itemId}")
	public String showItem(@PathVariable Long itemId, Model model) {
		ItemInfo item = itemService.getItemById(itemId);
		model.addAttribute("item", item);
		return "item";
	}

	@RequestMapping(value = "/desc/{itemId}", produces = MediaType.TEXT_HTML_VALUE
			+ ";charset=utf-8")
	@ResponseBody
	public String showItemDesc(@PathVariable Long itemId) {
		String string = itemService.getItemDescById(itemId);
		// System.out.println(string);
		return string;
	}

	@RequestMapping(value = "/param/{itemId}", produces = MediaType.TEXT_HTML_VALUE
			+ ";charset=utf-8")
	@ResponseBody
	public String showItemParam(@PathVariable Long itemId) {
		String string = itemService.getItemParam(itemId);
		return string;
	}
}
