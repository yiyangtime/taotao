package com.taotao.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemDescMapper;
import com.taotao.mapper.TbItemMapper;
import com.taotao.mapper.TbItemParamItemMapper;
import com.taotao.pojo.EUDataGridResult;
import com.taotao.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;
import com.taotao.pojo.TbItemExample;
import com.taotao.pojo.TbItemExample.Criteria;
import com.taotao.pojo.TbItemParamItem;
import com.taotao.service.ItemService;
import com.taotao.utils.IDUtils;

/**
 * 
 * 商品管理业务层   
 * @ProjectName:  [taotao-manager-service]   
 * @Package:      [com.taotao.service.impl]    
 * @ClassName:    [ItemServiceImpl]     
 * @Description:  [一句话描述该类的功能]     
 * @Author:       [yiyan]     
 * @CreateDate:   [2017年9月17日 上午10:27:36]     
 * @UpdateUser:   [yiyan]     
 * @UpdateDate:   [2017年9月17日 上午10:27:36]     
 * @UpdateRemark: [说明本次修改内容]    
 * @Version:      [v1.0]   
 *
 */
@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper itemMapper;
	@Autowired
	private TbItemDescMapper itemDescMapper;
	@Autowired
	private TbItemParamItemMapper itemParamItemMapper;
	
	/**
	 * 根据id查询商品信息
	 */
	public TbItem getItemById(long itemId) {
		
		//TbItem item = itemMapper.selectByPrimaryKey(itemId);
		//添加查询条件
		TbItemExample example = new TbItemExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(itemId);
		List<TbItem> list = itemMapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			TbItem item = list.get(0);
			return item;
		}
		return null;
	}

	/**
	 * 分页展示商品信息
	 */
	public EUDataGridResult getItemList(int page, int rows) {
		//查询商品列表
		TbItemExample example=new TbItemExample();
		//分页处理
		PageHelper.startPage(page, rows);
		List<TbItem> list=itemMapper.selectByExample(example);
		//创建一个返回值对象
		EUDataGridResult result=new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<TbItem> pageInfo=new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	/**
	 * 添加商品信息
	 * @throws java.lang.Exception 
	 */
	@Override
	public TaotaoResult createItem(TbItem item,String desc,String itemParams) throws Exception{
		//item补全
		//生成商品ID
		Long itemId=IDUtils.genItemId();
		item.setId(itemId);
		//商品状态  1-正常 2-下架 3-删除
		item.setStatus((byte) 1);
		item.setCreated(new Date());
		item.setUpdated(new Date());
		//插入到数据库
		itemMapper.insert(item);
		//添加商品描述信息
		TaotaoResult result=insertItemDesc(itemId,desc);
		if (result.getStatus()!=200) {
			throw new Exception();
		}
		//添加规格参数
		result=insertItemParamItem(itemId,itemParams);
		if (result.getStatus()!=200) {
			throw new Exception();
		}
		return TaotaoResult.ok();
	}

	/**
	 * 添加规格参数
	 * @param itemId
	 * @param itemParams
	 * @return
	 */
	private TaotaoResult insertItemParamItem(Long itemId, String itemParams) {
		TbItemParamItem itemParamItem=new TbItemParamItem();
		itemParamItem.setItemId(itemId);
		itemParamItem.setParamData(itemParams);
		itemParamItem.setCreated(new Date());
		itemParamItem.setUpdated(new Date());
		//向表中插入数据
		itemParamItemMapper.insert(itemParamItem);
		return TaotaoResult.ok();
	}

	/**
	 * 添加商品描述
	 * @param desc
	 * @return
	 */
	private TaotaoResult insertItemDesc(Long itemId,String desc) {
		TbItemDesc itemDesc=new TbItemDesc();
		itemDesc.setItemId(itemId);
		itemDesc.setItemDesc(desc);
		itemDesc.setCreated(new Date());
		itemDesc.setUpdated(new Date());
		itemDescMapper.insert(itemDesc);
		return TaotaoResult.ok();
	}

}
