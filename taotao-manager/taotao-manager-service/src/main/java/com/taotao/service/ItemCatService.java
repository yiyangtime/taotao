package com.taotao.service;

import java.util.List;

import com.taotao.pojo.EUTreeNode;

public interface ItemCatService {
	List<EUTreeNode> getItemCatList(Long parentId);
}
