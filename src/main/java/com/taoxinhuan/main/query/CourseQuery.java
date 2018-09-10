package com.taoxinhuan.main.query;

import java.io.Serializable;

public class CourseQuery implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2478373474168858275L;
	/**
	 * 课程编号
	 */
	private String courseNum;
	/**
	 * 课程编号
	 */
	private String courseName;

	/**
	 * 教师编号
	 */
	private String teacherNum;

	/**
	 * 学分
	 */
	private Float courseCredit;
	/**
	 * 学分
	 */
	private Float courseClass;

	/**
	 * 页面页码
	 */
	private Integer pageIndex;
	/**
	 * 页面数据量
	 */
	private Integer pageSize;

	public String getCourseNum() {
		return courseNum;
	}

	public void setCourseNum(String courseNum) {
		this.courseNum = courseNum;
	}

	public String getTeacherNum() {
		return teacherNum;
	}

	public void setTeacherNum(String teacherNum) {
		this.teacherNum = teacherNum;
	}

	public Float getCourseCredit() {
		return courseCredit;
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

}
