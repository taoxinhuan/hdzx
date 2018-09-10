package com.taoxinhuan.main.VO;

import java.io.Serializable;

/**
 * @Description:选修课程模型
 * @author taoxinhuan
 * @date 2018年1月5日 上午11:09:03
 */
public class CourseVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7446212504912311080L;

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

    public String getCourseNum() {
        return courseNum;
    }

    public void setCourseNum(String courseNum) {
        this.courseNum = courseNum == null ? null : courseNum.trim();
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName == null ? null : courseName.trim();
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
        this.courseDesc = courseDesc == null ? null : courseDesc.trim();
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
	
	@Override
	public String toString() {
		return "CourseVO [courseNum=" + courseNum + ", teacherNum=" + teacherNum + ", teacherName=" + teacherName
				+ ", courseName=" + courseName + ", courseCredit=" + courseCredit + ", courseClass=" + courseClass
				+ ", courseDesc=" + courseDesc + "]";
	}
}