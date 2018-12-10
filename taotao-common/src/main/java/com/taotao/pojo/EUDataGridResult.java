package com.taotao.pojo;

import java.util.List;
/**
 * 
 * 分页实体类    
 * @ProjectName:  [taotao-common]   
 * @Package:      [com.taotao.pojo]    
 * @ClassName:    [EUDataGridResult]     
 * @Description:  [一句话描述该类的功能]     
 * @Author:       [yiyan]     
 * @CreateDate:   [2017年9月17日 下午3:28:22]     
 * @UpdateUser:   [yiyan]     
 * @UpdateDate:   [2017年9月17日 下午3:28:22]     
 * @UpdateRemark: [说明本次修改内容]    
 * @Version:      [v1.0]   
 *
 */
public class EUDataGridResult {
	private long total;
	private List<?> rows;

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}
}
