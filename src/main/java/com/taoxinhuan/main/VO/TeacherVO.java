package com.taoxinhuan.main.VO;

import java.io.Serializable;

public class TeacherVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4911989192305008564L;

	/**
	 * 教师账号,工号
	 */
	private String teacherNum;
	
	/**
	 * 系部编号
	 */
	private String deptNum;
	
	/**
	 * 教师所属系部名称
	 */
	private String deptName;
	
	/**
	 * 教师名称
	 */
	private String teacherName;
	
	/**
	 * 教师性别
	 */
	private String teacherSex;
	
	/**
	 * 教师生日
	 */
	private String teacherBirthday;
	
	/**
	 * 教师职称
	 */
	private String teacherTitle;

	/**
	 * 教师职称
	 */
	private String teacherPassword;
	
	public String getTeacherNum() {
		return teacherNum;
	}
	
	public void setTeacherNum(String teacherNum) {
		this.teacherNum = teacherNum;
	}
	
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
	
	public String getTeacherName() {
		return teacherName;
	}
	
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	
	public String getTeacherSex() {
		return teacherSex;
	}
	
	public void setTeacherSex(String teacherSex) {
		this.teacherSex = teacherSex;
	}
	
	public String getTeacherBirthday() {
		return teacherBirthday;
	}

	public void setTeacherBirthday(String teacherBirthday) {
		this.teacherBirthday = teacherBirthday;
	}

	public String getTeacherTitle() {
		return teacherTitle;
	}
	
	public void setTeacherTitle(String teacherTitle) {
		this.teacherTitle = teacherTitle;
	}
	
	public String getTeacherPassword() {
		return teacherPassword;
	}

	public void setTeacherPassword(String teacherPassword) {
		this.teacherPassword = teacherPassword;
	}

	@Override
	public String toString() {
		return "TeacherVO [teacherNum=" + teacherNum + ", deptNum=" + deptNum + ", deptName=" + deptName
				+ ", teacherName=" + teacherName + ", teacherSex=" + teacherSex + ", teacherBirthday=" + teacherBirthday
				+ ", teacherTitle=" + teacherTitle + "]";
	}

}
