package com.taotao.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.taotao.service.PictureService;
import com.taotao.utils.JsonUtils;

/**
 * 
 * 图片上传下载管理Controller
 * 
 * @ProjectName: [taotao-manager-web]
 * @Package: [com.taotao.controller]
 * @ClassName: [PictureController]
 * @Description: [一句话描述该类的功能]
 * @Author: [yiyan]
 * @CreateDate: [2017年9月18日 上午10:47:23]
 * @UpdateUser: [yiyan]
 * @UpdateDate: [2017年9月18日 上午10:47:23]
 * @UpdateRemark: [说明本次修改内容]
 * @Version: [v1.0]
 * 
 */
@Controller
public class PictureController {
	@Autowired
	private PictureService pictureService;

	@SuppressWarnings("rawtypes")
	@RequestMapping("/pic/upload")
	@ResponseBody
	public String pictureUpload(MultipartFile uploadFile) {
		Map result = pictureService.uploadPicture(uploadFile);
		//为了保证功能的兼容性，需要把Result转换成json格式的字符串
		String json=JsonUtils.objectToJson(result);
		return json;
	}
}
