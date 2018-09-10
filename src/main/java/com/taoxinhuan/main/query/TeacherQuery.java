package com.taoxinhuan.main.query;

import java.io.Serializable;

public class TeacherQuery implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2863274242360956153L;

	/**
	 * 系部编号
	 */
	private String deptNum;

	/**
	 * 教师工号
	 */
	private String teacherNum;

	/**
	 * 教师名称
	 */
	private String teacherName;
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

	/**
	 * @return the teacherNum
	 */
	public String getTeacherNum() {
		return teacherNum;
	}

	/**
	 * @param teacherNum
	 *            the teacherNum to set
	 */
	public void setTeacherNum(String teacherNum) {
		this.teacherNum = teacherNum;
	}

	/**
	 * @return the teacherName
	 */
	public String getTeacherName() {
		return teacherName;
	}

	/**
	 * @param teacherName
	 *            the teacherName to set
	 */
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
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
