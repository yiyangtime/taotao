package com.taotao.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.taotao.mapper.TbContentCategoryMapper;
import com.taotao.pojo.EUTreeNode;
import com.taotao.pojo.TaotaoResult;
import com.taotao.pojo.TbContentCategory;
import com.taotao.pojo.TbContentCategoryExample;
import com.taotao.pojo.TbContentCategoryExample.Criteria;
import com.taotao.service.ContentCategoryService;

@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {
	@Autowired
	private TbContentCategoryMapper contentCategoryMapper;
	
	@Override
	public List<EUTreeNode> getContentCategoryList(long parentId) {
		TbContentCategoryExample example=new TbContentCategoryExample();
		//设置查询条件
		Criteria criteria=example.createCriteria();
		//根据parentId查询子节点
		criteria.andParentIdEqualTo(parentId);
		//执行查询
		List<TbContentCategory> list=contentCategoryMapper.selectByExample(example);
		List<EUTreeNode> resultList=new ArrayList<>();
		for (TbContentCategory tbContentCategory : list) {
			//创建一个节点
			EUTreeNode node=new EUTreeNode();
			//添加节点内容
			node.setId(tbContentCategory.getId());
			node.setText(tbContentCategory.getName());
			node.setState(tbContentCategory.getIsParent()?"closed":"open");
			//将数据存储到集合数组中
			resultList.add(node);
		}
		return resultList;
	}

	@Override
	public TaotaoResult insertContentCategory(long parentId, String name) {
		//创建一个pojo
		TbContentCategory contentCategory=new TbContentCategory();
		//设置父id
		contentCategory.setParentId(parentId);
		//设置名称
		contentCategory.setName(name);
		//状态
		contentCategory.setStatus(1);
		contentCategory.setSortOrder(1);
		//是否为父节点
		contentCategory.setIsParent(false);
		//创建时间
		contentCategory.setCreated(new Date());
		//更新时间
		contentCategory.setUpdated(new Date());
		//插入数据库
		contentCategoryMapper.insert(contentCategory);
		//查看父节点的isParent列是否为true，如果不是true改成true
		TbContentCategory parentCat=contentCategoryMapper.selectByPrimaryKey(parentId);
		if (!parentCat.getIsParent()) {
			parentCat.setIsParent(true);
			//更新父节点
			contentCategoryMapper.updateByPrimaryKey(parentCat);
		}
		//返回结果
		return TaotaoResult.ok(contentCategory);
	}
	
}
