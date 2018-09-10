package com.taoxinhuan.main.VO;

import java.io.Serializable;

public class CourseForStudentVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8187585895233113447L;

	private String deptNum;

	private String deptName;

	/**
	 * 课程编号
	 */
	private String courseNum;

	/**
	 * 教师编号
	 */
	private String teacherNum;

	/**
	 * 教师名称
	 */
	private String teacherName;

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

	public String getTeacherNum() {
		return teacherNum;
	}

	public void setTeacherNum(String teacherNum) {
		this.teacherNum = teacherNum;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getCourseNum() {
		return courseNum;
	}

	public void setCourseNum(String courseNum) {
		this.courseNum = courseNum;
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

	@Override
	public String toString() {
		return "CourseForStudentVO [deptNum=" + deptNum + ", deptName=" + deptName + ", courseNum=" + courseNum
				+ ", teacherNum=" + teacherNum + ", teacherName=" + teacherName + ", courseName=" + courseName
				+ ", courseCredit=" + courseCredit + ", courseClass=" + courseClass + ", courseDesc=" + courseDesc
				+ "]";
	}

}
