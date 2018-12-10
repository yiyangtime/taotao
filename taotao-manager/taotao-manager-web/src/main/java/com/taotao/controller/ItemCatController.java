package com.taotao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.pojo.EUTreeNode;
import com.taotao.service.ItemCatService;

/**
 * 
 * 商品类目管理Controller    
 * @ProjectName:  [taotao-manager-web]   
 * @Package:      [com.taotao.controller]    
 * @ClassName:    [ItemCatController]     
 * @Description:  [一句话描述该类的功能]     
 * @Author:       [yiyan]     
 * @CreateDate:   [2017年9月17日 下午4:12:50]     
 * @UpdateUser:   [yiyan]     
 * @UpdateDate:   [2017年9月17日 下午4:12:50]     
 * @UpdateRemark: [说明本次修改内容]    
 * @Version:      [v1.0]   
 *
 */
@Controller
@RequestMapping("/item/cat")
public class ItemCatController {
	@Autowired
	private ItemCatService itemCatService;
	
	@SuppressWarnings({ })
	@RequestMapping("/list")
	@ResponseBody
	//如果id为null是使用默认值，也就是parentid为0的分类列表
	public List<EUTreeNode> categoryList(@RequestParam(value="id",defaultValue="0") Long parentId) {
		//查询数据流库
		List<EUTreeNode> list=itemCatService.getItemCatList(parentId);
		return list;
	}
}
