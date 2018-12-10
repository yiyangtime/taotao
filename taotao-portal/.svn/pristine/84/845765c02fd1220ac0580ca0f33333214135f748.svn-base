package com.taotao.portal.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.taotao.pojo.TbUser;
import com.taotao.portal.service.impl.UserServiceImpl;
import com.taotao.utils.CookieUtils;
/**
 * 用户登录拦截器   
 * @ProjectName:  [taotao-portal]   
 * @Package:      [com.taotao.portal.interceptor]    
 * @ClassName:    [LoginInterceptor]     
 * @Description:  [一句话描述该类的功能]     
 * @Author:       [yiyan]     
 * @CreateDate:   [2017年9月26日 上午8:36:57]     
 * @UpdateUser:   [yiyan]     
 * @UpdateDate:   [2017年9月26日 上午8:36:57]     
 * @UpdateRemark: [说明本次修改内容]    
 * @Version:      [v1.0]   
 *
 */
public class LoginInterceptor implements HandlerInterceptor {
	@Autowired
	private UserServiceImpl userService;

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// 在handler执行之前
		// 从cookie中获取token
		String token = CookieUtils.getCookieValue(request, "TT_TOKEN");
		// 根据token获取用户信息，调用sso系统接口
		TbUser user = userService.getUserByToken(token);
		// 取不到用户信息
		if (null == user) {
			// 跳转到登录页面，把用户请求的url作为参数传递给登录页面
			response.sendRedirect(userService.SSO_BASE_URL
					+ userService.SSO_PAGE_LOGIN + "?redirect="
					+ request.getRequestURL());
			// 返回false
			return false;
		}
		// 取到用户信息，放行
		//把用户信息放入request
		request.setAttribute("user", user);
		// 返回值决定handler是否执行，true：执行，flase：不执行
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// 在handler执行之后，返回ModelAndView之前

	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// 在handler执行之后

	}
}
