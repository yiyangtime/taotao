package com.taotao.restful.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.pojo.TaotaoResult;
import com.taotao.pojo.TbContent;
import com.taotao.restful.service.ContentService;
import com.taotao.utils.ExceptionUtil;

/**
 * 
 * 内容管理Controller
 * 
 * @ProjectName: [taotao-restful]
 * @Package: [com.taotao.restful.controller]
 * @ClassName: [ContentController]
 * @Description: [一句话描述该类的功能]
 * @Author: [yiyan]
 * @CreateDate: [2017年9月22日 下午3:09:50]
 * @UpdateUser: [yiyan]
 * @UpdateDate: [2017年9月22日 下午3:09:50]
 * @UpdateRemark: [说明本次修改内容]
 * @Version: [v1.0]
 * 
 */
@Controller
@RequestMapping("/content")
public class ContentController {
	@Autowired
	private ContentService contentService;

	@RequestMapping("/list/{contentCategoryId}")
	@ResponseBody
	public TaotaoResult getContentList(@PathVariable Long contentCategoryId) {
		try {
			List<TbContent> list = contentService
					.getContentList(contentCategoryId);
			return TaotaoResult.ok(list);
		} catch (Exception e) {
			e.printStackTrace();
			return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
		}

	}
}
