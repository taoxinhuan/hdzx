package com.taoxinhuan.main.VO;

import java.io.Serializable;

/**
 * @Description:选修课成绩
 * @author taoxinhuan
 * @date 2018年1月5日 上午11:12:16
 */
public class GradeVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 247426036373772258L;

	/**
	 * 学生编号
	 */
    private String studentNum;
    
    /**
     * 学生姓名
     */
    private String studentName;
	
	/**
	 * 课程编号
	 */
	private String courseNum;
	
	/**
	 * 课程名称
	 */
	private String courseName;
	
	/**
	 * 教师编号
	 */
    private String teacherNum;
	
	
	/**
	 * 教师名称
	 */
	private String teacherName;
	
	/**
	 * 成绩
	 */
    private Integer grade;

	/**
	 * 学分
	 */
	private Float courseCredit;

	/**
	 * 学时
	 */
	private Short courseClass;

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
	
	public String getCourseName() {
		return courseName;
	}
	
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	public String getTeacherName() {
		return teacherName;
	}
	
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	
	
	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
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

	@Override
	public String toString() {
		return "GradeVO [studentNum=" + studentNum + ", studentName=" + studentName + ", courseNum=" + courseNum
				+ ", courseName=" + courseName + ", teacherNum=" + teacherNum + ", teacherName=" + teacherName
				+ ", grade=" + grade + ", courseCredit=" + courseCredit + ", courseClass=" + courseClass + "]";
	}



}