package com.taoxinhuan.main.query;

import java.io.Serializable;

public class CourseForStudentQuery implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2478373474168858275L;
	/**
	 * 课程编号
	 */
	private String deptNum;

	private String teacherNum;
	/**
	 * 课程名称
	 */
	private String courseName;
	/**
	 * 学时
	 */
	private Float courseClass;

	/**
	 * 学分
	 */
	private Float courseCredit;

	/**
	 * 页面页码
	 */
	private Integer pageIndex;
	/**
	 * 页面数据量
	 */
	private Integer pageSize;



	public Float getCourseCredit() {
		return courseCredit;
	}

	public String getDeptNum() {
		return deptNum;
	}

	public void setDeptNum(String deptNum) {
		this.deptNum = deptNum;
	}

	public void setCourseCredit(Float courseCredit) {
		this.courseCredit = courseCredit;
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

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Float getCourseClass() {
		return courseClass;
	}

	public void setCourseClass(Float courseClass) {
		this.courseClass = courseClass;
	}

	public String getTeacherNum() {
		return teacherNum;
	}

	public void setTeacherNum(String teacherNum) {
		this.teacherNum = teacherNum;
	}


}
