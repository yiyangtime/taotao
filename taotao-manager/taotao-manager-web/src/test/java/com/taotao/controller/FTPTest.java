package com.taotao.controller;

import java.io.File;
import java.io.FileInputStream;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;

public class FTPTest {
	@Test
	public void testFtpClient() throws Exception {
		//创建一个FtpClient对象
		FTPClient ftpClient=new FTPClient();
		//创建ftp连接
		ftpClient.connect("192.168.0.128", 21);
		//登录ftp服务器，使用用户名及密码
		ftpClient.login("ftpuser", "13978426");
		//上传文件
		//读取本地文件
		FileInputStream inputStream=new FileInputStream(new File("F:\\照片\\图片\\QQ_Images\\1.jpeg"));
		//设置上传服务器端路径
		ftpClient.changeWorkingDirectory("/home/ftpuser/images");
		//设置文件保存类型
		ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
		//第一个参数：服务器端文档名
		//第二个参数:上传文档的inputStream
		ftpClient.storeFile("123.jpg", inputStream);
		//关闭连接
		inputStream.close();
		ftpClient.logout();
	}
}
