package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.pojo.EUDataGridResult;
import com.taotao.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;

/**
 * 商品管理Controller
 * Simple to Introduction    
 * @ProjectName:  [taotao-manager-web]   
 * @Package:      [com.taotao.controller]    
 * @ClassName:    [ItemController]     
 * @Description:  [一句话描述该类的功能]     
 * @Author:       [yiyan]     
 * @CreateDate:   [2017年9月17日 上午10:28:28]     
 * @UpdateUser:   [yiyan]     
 * @UpdateDate:   [2017年9月17日 上午10:28:28]     
 * @UpdateRemark: [说明本次修改内容]    
 * @Version:      [v1.0]   
 *
 */

@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/item/{itemId}")
	@ResponseBody
	public TbItem getItemById(@PathVariable Long itemId) {
		TbItem tbItem = itemService.getItemById(itemId);
		return tbItem;
	}
	
	@RequestMapping("/item/list")
	@ResponseBody
	public EUDataGridResult getItemList(Integer page,Integer rows) {
		EUDataGridResult result=itemService.getItemList(page,rows);
		return result;
	}
	
	@RequestMapping(value="/item/save",method=RequestMethod.POST)
	@ResponseBody
	public TaotaoResult createItem(TbItem item,String desc,String itemParams) throws Exception{
		TaotaoResult result=itemService.createItem(item,desc,itemParams);
		return result;
	}
}
