package com.taotao.restful.service;

import com.taotao.pojo.TaotaoResult;

public interface RedisService {
	TaotaoResult syncContent(long contentCid);
}
