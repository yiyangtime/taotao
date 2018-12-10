package com.taotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * 页面跳转Controller    
 * @ProjectName:  [taotao-manager-web]   
 * @Package:      [com.taotao.controller]    
 * @ClassName:    [PageController]     
 * @Description:  [一句话描述该类的功能]     
 * @Author:       [yiyan]     
 * @CreateDate:   [2017年9月17日 上午10:59:39]     
 * @UpdateUser:   [yiyan]     
 * @UpdateDate:   [2017年9月17日 上午10:59:39]     
 * @UpdateRemark: [说明本次修改内容]    
 * @Version:      [v1.0]   
 *
 */
@Controller
public class PageController {
	/*
	 * 打开首页
	 */
	@RequestMapping("/")
	public String showIndex() {
		return "index";
	}
	
	/*
	 * 展示其他页面
	 */
	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page) {
		return page;
	}
}
