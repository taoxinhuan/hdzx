package com.taoxinhuan.main.query;

import java.io.Serializable;

public class MajorQuery implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2863274242360956153L;

	/**
	 * 系部编号
	 */
	private String deptNum;

	/**
	 * 专业名臣
	 */
	private String majorName;
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

	public String getMajorName() {
		return majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
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
