package com.mxp.util;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * 类名称：DataGridJson    
 * 类描述：     easyUI的dataGrid返回结果对象
 * @version </pre>
 */
public class DataGridJson implements Serializable {

	private static final long serialVersionUID = -9067720532898696161L;
	
	private Integer total;
	
	private List rows;
	
	private List footer;
	
	public DataGridJson() {
		// TODO Auto-generated constructor stub
	}
	
	

	public DataGridJson(Integer total, List rows) {
		super();
		this.total = total;
		this.rows = rows;
	}
	

	public DataGridJson(Integer total, List rows, List footer) {
		super();
		this.total = total;
		this.rows = rows;
		this.footer = footer;
	}



	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public List getRows() {
		return rows;
	}

	public void setRows(List rows) {
		this.rows = rows;
	}

	public List getFooter() {
		return footer;
	}

	public void setFooter(List footer) {
		this.footer = footer;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
	
	

}
