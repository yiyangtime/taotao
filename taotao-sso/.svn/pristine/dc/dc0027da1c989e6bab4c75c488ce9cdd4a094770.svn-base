package com.taotao.sso.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taotao.pojo.TaotaoResult;
import com.taotao.pojo.TbUser;

public interface UserService {
	/**
	 * 数据校验
	 * @param content
	 * @param type
	 * @return
	 */
	TaotaoResult checkData(String content,Integer type);
	/**
	 * 创建用户
	 * @param user
	 * @return
	 */
	TaotaoResult createUser(TbUser user);
	/**
	 * 用户登录
	 * @param username
	 * @param password
	 * @return
	 */
	TaotaoResult userLogin(String username,String password,HttpServletRequest request,
	HttpServletResponse response);
	/**
	 * redis中查询token对应的用户信息
	 * @param token
	 * @return
	 */
	TaotaoResult getUserByToken(String token);
	//安全退出
	TaotaoResult logout(String token);
}
