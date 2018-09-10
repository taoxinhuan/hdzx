package com.taoxinhuan.main.query;

import java.io.Serializable;

public class DeptQuery implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -357245839546111466L;
	/**
	 * 系部编号
	 */
	private String deptNum;

	/**
	 * 学生名称
	 */
	private String deptName;
	/**
	 * 页面页码
	 */
	private Integer pageIndex;
	/**
	 * 页面数据量
	 */
	private Integer pageSize;

	public String getDeptNum() {
		return deptNum;
	}

	public void setDeptNum(String deptNum) {
		this.deptNum = deptNum;
	}


	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

}
