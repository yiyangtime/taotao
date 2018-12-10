package com.taotao.portal.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.portal.service.ContentService;
import com.taotao.portal.service.UserService;
import com.taotao.utils.CookieUtils;

@Controller
public class IndexController {
	@Autowired
	private ContentService contentService;

	@Autowired
	private UserService userService;

	@RequestMapping("/index")
	public String showIndex(Model model) {
		String adJson = contentService.getContentList();
		model.addAttribute("ad1", adJson);
		return "index";
	}

	@RequestMapping(value = "/httpclient/post", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE
			+ ";charset=utf-8")
	@ResponseBody
	public String testPost(String username, String password) {
		String result = "username:" + username + "\tpassword:" + password;
		// System.out.println(result);
		return result;
	}

	@RequestMapping("/user/logout")
	public String logout(HttpServletRequest request,
			HttpServletResponse response) {
		String token = CookieUtils.getCookieValue(request, "TT_TOKEN");
		//System.out.println(token);
		userService.logout(token, request, response);
		return "redirect:/";
	}
}
