package com.taoxinhuan.main.PO;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description:学生模型
 * @author taoxinhuan
 * @date 2018年1月5日 上午11:14:21
 */
public class Student implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5374791596048044007L;

	/**
	 * 学生账号,学号
	 */
    private String studentNum;
	/**
	 * 系部标号
	 */
	private String deptNum;
	
	/**
	 * 专业编号
	 */
    private String majorNum;
	
	/**
	 * 学生名称
	 */
    private String studentName;
	
	/**
	 * 学生性别
	 */
    private String studentSex;
	
	/**
	 * 学生生日
	 */
    private Date studentBirthday;
	
	/**
	 * 学生密码
	 */
    private String studentPassword;

    public String getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(String studentNum) {
        this.studentNum = studentNum == null ? null : studentNum.trim();
    }

    public String getMajorNum() {
        return majorNum;
    }

    public void setMajorNum(String majorNum) {
        this.majorNum = majorNum == null ? null : majorNum.trim();
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName == null ? null : studentName.trim();
    }

    public String getStudentSex() {
        return studentSex;
    }

    public void setStudentSex(String studentSex) {
        this.studentSex = studentSex == null ? null : studentSex.trim();
    }

    public Date getStudentBirthday() {
        return studentBirthday;
    }

    public void setStudentBirthday(Date studentBirthday) {
        this.studentBirthday = studentBirthday;
    }

    public String getStudentPassword() {
        return studentPassword;
    }

    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword == null ? null : studentPassword.trim();
    }

	public String getDeptNum() {
		return deptNum;
	}

	public void setDeptNum(String deptNum) {
		this.deptNum = deptNum;
	}

}