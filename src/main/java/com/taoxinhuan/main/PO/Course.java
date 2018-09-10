package com.taoxinhuan.main.PO;

import java.io.Serializable;

/**
 * @Description:选修课程模型
 * @author taoxinhuan
 * @date 2018年1月5日 上午11:09:03
 */
public class Course implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3550130105535883614L;

	/**
	 * 课程编号
	 */
    private String courseNum;
	
	/**
	 * 教师编号
	 */
	private String teacherNum;
	
	/**
	 * 课程名称
	 */
    private String courseName;
	
	/**
	 * 学分
	 */
    private Float courseCredit;
	
	/**
	 * 学时
	 */
    private Short courseClass;
	
	/**
	 * 描述
	 */
    private String courseDesc;

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

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Float getCourseCredit() {
		return courseCredit;
	}

	public void setCourseCredit(Float courseCredit) {
		this.courseCredit = courseCredit;
	}

	public Short getCourseClass() {
		return courseClass;
	}

	public void setCourseClass(Short courseClass) {
		this.courseClass = courseClass;
	}

	public String getCourseDesc() {
		return courseDesc;
	}
	
	public void setCourseDesc(String courseDesc) {
		this.courseDesc = courseDesc;
	}

}