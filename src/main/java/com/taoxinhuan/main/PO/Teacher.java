package com.taoxinhuan.main.PO;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description:教师模型
 * @author taoxinhuan
 * @date 2018年1月5日 上午11:15:47
 */
public class Teacher implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = -7173206408846740206L;

	/**
	 * 教师账号,工号
	 */
    private String teacherNum;
	
	/**
	 * 教师密码
	 */
	private String teacherPassword;
	
	/**
	 * 教师所属系部编号
	 */
    private String deptNum;
	
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
    private Date teacherBirthday;
	
	/**
	 * 教师职称
	 */
    private String teacherTitle;

    public String getTeacherNum() {
        return teacherNum;
    }

    public void setTeacherNum(String teacherNum) {
        this.teacherNum = teacherNum == null ? null : teacherNum.trim();
    }
	
	public String getTeacherPassword() {
		return teacherPassword;
	}

	public void setTeacherPassword(String teacherPassword) {
		this.teacherPassword = teacherPassword;
	}
	
	public String getDeptNum() {
        return deptNum;
    }

    public void setDeptNum(String deptNum) {
        this.deptNum = deptNum == null ? null : deptNum.trim();
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName == null ? null : teacherName.trim();
    }

    public String getTeacherSex() {
        return teacherSex;
    }

    public void setTeacherSex(String teacherSex) {
        this.teacherSex = teacherSex == null ? null : teacherSex.trim();
    }

    public Date getTeacherBirthday() {
        return teacherBirthday;
    }

    public void setTeacherBirthday(Date teacherBirthday) {
        this.teacherBirthday = teacherBirthday;
    }

    public String getTeacherTitle() {
        return teacherTitle;
    }

    public void setTeacherTitle(String teacherTitle) {
        this.teacherTitle = teacherTitle == null ? null : teacherTitle.trim();
    }
}