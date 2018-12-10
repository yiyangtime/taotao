package com.taotao.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.taotao.service.PictureService;
import com.taotao.utils.FtpUtil;
import com.taotao.utils.IDUtils;

/**
 * 
 * 图片上传服务
 * 
 * @ProjectName: [taotao-manager-service]
 * @Package: [com.taotao.service.impl]
 * @ClassName: [PictureServiceImpl]
 * @Description: [一句话描述该类的功能]
 * @Author: [yiyan]
 * @CreateDate: [2017年9月17日 下午10:51:14]
 * @UpdateUser: [yiyan]
 * @UpdateDate: [2017年9月17日 下午10:51:14]
 * @UpdateRemark: [说明本次修改内容]
 * @Version: [v1.0]
 * 
 */
@Service
public class PictureServiceImpl implements PictureService {
	@Value("${FTP_ADDRESS}")
	private String FTP_ADDRESS;
	@Value("${FTP_PORT}")
	private int FTP_PORT;
	@Value("${FTP_USERNAME}")
	private String FTP_USERNAME;
	@Value("${FTP_PASSWORD}")
	private String FTP_PASSWORD;
	@Value("${FTP_BASE_PATH}")
	private String FTP_BASE_PATH;
	@Value("${IMAGE_BASE_URL}")
	private String IMAGE_BASE_URL;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Map uploadPicture(MultipartFile uploadFile){
		Map resultMap=new HashMap<>();
		try {
			// 生成一个新的文件名
			// 取原始文件名
			String oldName = uploadFile.getOriginalFilename();
			// 生成新的文件名
			// UUID.randomUUID();
			String newName = IDUtils.genImageName();
			newName = newName + oldName.substring(oldName.lastIndexOf("."));
			// 图片上传
			String imagePath=new DateTime().toString("yyyy/MM/dd");
			boolean result=FtpUtil.uploadFile(FTP_ADDRESS, FTP_PORT, FTP_USERNAME, FTP_PASSWORD,
					FTP_BASE_PATH, imagePath, newName,
					uploadFile.getInputStream());
			//返回结果
			if (!result) {
				resultMap.put("error", 1);
				resultMap.put("message", "文件上传失败");
				return resultMap;
			}
			resultMap.put("error",0);
			resultMap.put("url", IMAGE_BASE_URL+"/"+imagePath+"/"+newName);
			return resultMap;
		} catch (Exception e) {
			resultMap.put("error", 1);
			resultMap.put("message", "文件上传发生异常");
			return resultMap;
		}
	}
}
