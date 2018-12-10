package com.taotao.service;

import com.taotao.pojo.EUDataGridResult;
import com.taotao.pojo.TaotaoResult;
import com.taotao.pojo.TbContent;

public interface ContentService {
	/**
	 * 分页查询内容列表
	 * @param page
	 * @param rows
	 * @return
	 */
	EUDataGridResult getContentList(long categoryId,int page,int rows);
	/**
	 * 插入内容管理信息
	 * @param tbContent
	 * @return
	 */
	TaotaoResult insertContent(TbContent content);
}
