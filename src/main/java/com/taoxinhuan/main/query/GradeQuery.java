package com.taoxinhuan.main.query;

import java.io.Serializable;

public class GradeQuery implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3890414063666362520L;
	/**
	 * 教师编号
	 */
	private String teacherNum;

	/**
	 * 课程编号
	 */
	private String courseNum;
	/**
	 * 是否查询成绩已经输入的学生
	 */
	private Boolean flag;

	private Integer grade;

	/**
	 * 页面页码
	 */
	private Integer pageIndex;
	/**
	 * 页面数据量
	 */
	private Integer pageSize;

	public String getTeacherNum() {
		return teacherNum;
	}

	public void setTeacherNum(String teacherNum) {
		this.teacherNum = teacherNum;
	}

	public String getCourseNum() {
		return courseNum;
	}

	public void setCourseNum(String courseNum) {
		this.courseNum = courseNum;
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

	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

}
