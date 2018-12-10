package com.taotao.pojo;

/**
 * 
 * easyUI树形控件节点格式
 * 
 * @ProjectName: [taotao-common]
 * @Package: [com.taotao.pojo]
 * @ClassName: [EUTreeNode]
 * @Description: [一句话描述该类的功能]
 * @Author: [yiyan]
 * @CreateDate: [2017年9月17日 下午5:09:23]
 * @UpdateUser: [yiyan]
 * @UpdateDate: [2017年9月17日 下午5:09:23]
 * @UpdateRemark: [说明本次修改内容]
 * @Version: [v1.0]
 * 
 */
public class EUTreeNode {
	private long id;
	private String text;
	private String state;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
