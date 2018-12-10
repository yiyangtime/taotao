package com.taotao.portal.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.taotao.pojo.TaotaoResult;
import com.taotao.pojo.TbUser;
import com.taotao.portal.service.UserService;
import com.taotao.utils.HttpClientUtil;

@Service
public class UserServiceImpl implements UserService {
	@Value("${SSO_BASE_URL}")
	public String SSO_BASE_URL;
	@Value("${SSO_USER_TOKEN}")
	private String SSO_USER_TOKEN;
	@Value("${SSO_PAGE_LOGIN}")
	public String SSO_PAGE_LOGIN;
	@Value("${SSO_PAGE_LOGOUT}")
	private String SSO_PAGE_LOGOUT;

	@Override
	public TbUser getUserByToken(String token) {
		try {
			// 调用sso服务，根据token获取用户信息
			String json = HttpClientUtil.doGet(SSO_BASE_URL + SSO_USER_TOKEN
					+ token);
			// 把json转换成TaotaoResult
			TaotaoResult result = TaotaoResult.formatToPojo(json, TbUser.class);
			if (result.getStatus() == 200) {
				TbUser user = (TbUser) result.getData();
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public TaotaoResult logout(String token, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			System.out.println(SSO_BASE_URL + SSO_PAGE_LOGOUT + token);
			String json = HttpClientUtil.doGet(SSO_BASE_URL + SSO_PAGE_LOGOUT
					+ token);
			System.out.println("json:--------------" + json);
			return TaotaoResult.ok(json);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
