package com.taoxinhuan.main.VO;

import java.io.Serializable;

/**
 * @Description:学生模型
 * @author taoxinhuan
 * @date 2018年1月5日 上午11:14:21
 */
public class StudentVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -175220577514003514L;

	/**
	 * 学生账号,学号
	 */
    private String studentNum;
	
	/**
	 * 专业编号
	 */
	private String majorNum;
	/**
	 * 专业名称
	 */
	private String majorName;
	
	/**
	 * 系部编号
	 */
	private String deptNum;
	
	/**
	 * 系部名称
	 */
	private String deptName;
	
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
	private String studentBirthday;
	
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

	public String getMajorName() {
		return majorName;
	}
	
	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}
	
	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
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

	public String getStudentBirthday() {
		return studentBirthday;
	}

	public void setStudentBirthday(String studentBirthday) {
		this.studentBirthday = studentBirthday;
	}

	public String getStudentPassword() {
        return studentPassword;
    }

    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword == null ? null : studentPassword.trim();
    }
	
	public String getMajorNum() {
		return majorNum;
	}
	
	public void setMajorNum(String majorNum) {
		this.majorNum = majorNum;
	}
	
	public String getDeptNum() {
		return deptNum;
	}
	
	public void setDeptNum(String deptNum) { 
		this.deptNum = deptNum;
	}
	
	@Override
	public String toString() {
		return "StudentVO [studentNum=" + studentNum + ", majorNum=" + majorNum + ", majorName=" + majorName
				+ ", deptNum=" + deptNum + ", deptName=" + deptName + ", studentName=" + studentName + ", studentSex="
				+ studentSex + ", studentBirthday=" + studentBirthday + ", studentPassword=" + studentPassword + "]";
	}

}