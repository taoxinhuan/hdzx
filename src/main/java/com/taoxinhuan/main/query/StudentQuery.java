package com.taoxinhuan.main.query;

import java.io.Serializable;

public class StudentQuery implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5839680164832770295L;
	/**
	 * 系部编号
	 */
	private String deptNum;
	/**
	 * 学生账号,学号
	 */
	private String studentNum;

	/**
	 * 专业编号
	 */
	private String majorNum;

	/**
	 * 学生名称
	 */
	private String studentName;

	private Integer pageIndex;

	private Integer pageSize;

	public String getDeptNum() {
		return deptNum;
	}

	public void setDeptNum(String deptNum) {
		this.deptNum = deptNum;
	}

	public String getStudentNum() {
		return studentNum;
	}

	public void setStudentNum(String studentNum) {
		this.studentNum = studentNum;
	}

	public String getMajorNum() {
		return majorNum;
	}

	public void setMajorNum(String majorNum) {
		this.majorNum = majorNum;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
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
