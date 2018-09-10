package com.taoxinhuan.main.PO;

import java.io.Serializable;

/**
 * @Description:选修课成绩
 * @author taoxinhuan
 * @date 2018年1月5日 上午11:12:16
 */
public class Grade implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1320929464909217061L;

	/**
	 * 学生编号
	 */
    private String studentNum;
	
	/**
	 * 课程编号
	 */
    private String courseNum;
	
	/**
	 * 教师编号
	 */
    private String teacherNum;
	
	/**
	 * 成绩
	 */
    private Integer grade;

    public String getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(String studentNum) {
        this.studentNum = studentNum == null ? null : studentNum.trim();
    }

    public String getCourseNum() {
        return courseNum;
    }

    public void setCourseNum(String courseNum) {
        this.courseNum = courseNum == null ? null : courseNum.trim();
    }

    public String getTeacherNum() {
        return teacherNum;
    }

    public void setTeacherNum(String teacherNum) {
        this.teacherNum = teacherNum == null ? null : teacherNum.trim();
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }
}