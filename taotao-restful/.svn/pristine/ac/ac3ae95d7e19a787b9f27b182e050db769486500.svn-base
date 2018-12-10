package com.taotao.restful.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.taotao.mapper.TbContentMapper;
import com.taotao.pojo.TbContent;
import com.taotao.pojo.TbContentExample;
import com.taotao.pojo.TbContentExample.Criteria;
import com.taotao.restful.dao.JedisClient;
import com.taotao.restful.service.ContentService;
import com.taotao.utils.JsonUtils;

/**
 * 
 * 内容管理服务层
 * 
 * @ProjectName: [taotao-restful]
 * @Package: [com.taotao.restful.service.impl]
 * @ClassName: [ContentServiceImpl]
 * @Description: [一句话描述该类的功能]
 * @Author: [yiyan]
 * @CreateDate: [2017年9月22日 下午3:00:35]
 * @UpdateUser: [yiyan]
 * @UpdateDate: [2017年9月22日 下午3:00:35]
 * @UpdateRemark: [说明本次修改内容]
 * @Version: [v1.0]
 * 
 */
@Service
public class ContentServiceImpl implements ContentService {

	@Autowired
	private TbContentMapper contentMapper;
	@Autowired
	private JedisClient jedisClient;

	@Value("${INDEX_CONTENT_REDIS_KEY}")
	private String INDEX_CONTENT_REDIS_KEY;

	@Override
	public List<TbContent> getContentList(long contentCid) {
		// 从缓存中取内容
		try {
			String result = jedisClient.hget(INDEX_CONTENT_REDIS_KEY,
					contentCid + "");
			if (!StringUtils.isBlank(result)) {
				//把字符串转换成list
				List<TbContent> resultList=JsonUtils.jsonToList(result, TbContent.class);
				return resultList;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 根据内容分类id查询内容列表
		TbContentExample example = new TbContentExample();
		Criteria criteria = example.createCriteria();
		criteria.andCategoryIdEqualTo(contentCid);
		// 执行查询
		List<TbContent> list = contentMapper.selectByExample(example);

		// 向缓存中添加内容
		try {
			// 将list转换成字符串
			String cacheString = JsonUtils.objectToJson(list);
			jedisClient.hset(INDEX_CONTENT_REDIS_KEY, contentCid + "",
					cacheString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
