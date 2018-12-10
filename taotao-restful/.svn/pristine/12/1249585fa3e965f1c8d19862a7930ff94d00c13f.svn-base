package com.taotao.restful.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.taotao.restful.pojo.CatResult;
import com.taotao.restful.service.ItemCatService;

/**
 * 
 * 商品分类管理Controller    
 * @ProjectName:  [taotao-restful]   
 * @Package:      [com.taotao.restful.controller]    
 * @ClassName:    [ItemCatController]     
 * @Description:  [一句话描述该类的功能]     
 * @Author:       [yiyan]     
 * @CreateDate:   [2017年9月20日 上午11:48:44]     
 * @UpdateUser:   [yiyan]     
 * @UpdateDate:   [2017年9月20日 上午11:48:44]     
 * @UpdateRemark: [说明本次修改内容]    
 * @Version:      [v1.0]   
 *
 */
@Controller
public class ItemCatController {
	@Autowired
	private ItemCatService itemCatService;
	
//	@RequestMapping(value="/itemcat/list",produces=MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
//	@ResponseBody
//	public String getItemCatList(String callback) {
//		CatResult catResult=itemCatService.getItemCatList();
//		//把pojo转换成字符串
//		String json=JsonUtils.objectToJson(catResult);
//		//拼装返回值
//		String result=callback+"("+json+");";
//		return result;
//	}
	
	@RequestMapping("/itemcat/list")
	@ResponseBody
	public Object getItemCatList(String callback) {
		CatResult catResult=itemCatService.getItemCatList();
		MappingJacksonValue mappingJacksonValue=new MappingJacksonValue(catResult);
		mappingJacksonValue.setJsonpFunction(callback);
		return mappingJacksonValue;
	}
}
