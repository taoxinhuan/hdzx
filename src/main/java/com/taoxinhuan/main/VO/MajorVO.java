package com.taoxinhuan.main.VO;

import java.io.Serializable;

/**
 * @Description:选修课
 * @author taoxinhuan
 * @date 2018年1月5日 上午11:04:44
 */
public class MajorVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5937545019859940489L;

	/**
	 * 专业编号
	 */
    private String majorNum;
	
    /**
     * 所属系部编号
     */
	private String deptNum;
	/**
	 * 所属系部名称
	 */
	private String deptName;
	
	/**
	 * 专业名称
	 */
    private String majorName;
	
	/**
	 * 辅导员
	 */
    private String majorAssistant;
	
	/**
	 * 专业电话
	 */
    private String majorTel;

    public String getMajorNum() {
        return majorNum;
    }

    public void setMajorNum(String majorNum) {
        this.majorNum = majorNum == null ? null : majorNum.trim();
    }


	public String getDeptName() {
		return deptName;
	}
	
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName == null ? null : majorName.trim();
    }

    public String getMajorAssistant() {
        return majorAssistant;
    }

    public void setMajorAssistant(String majorAssistant) {
        this.majorAssistant = majorAssistant == null ? null : majorAssistant.trim();
    }

    public String getMajorTel() {
        return majorTel;
    }

    public void setMajorTel(String majorTel) {
        this.majorTel = majorTel == null ? null : majorTel.trim();
    }
	
	public String getDeptNum() {
		return deptNum;
	}
	
	public void setDeptNum(String deptNum) {
		this.deptNum = deptNum;
	}
	
	@Override
	public String toString() {
		return "MajorVO [majorNum=" + majorNum + ", deptNum=" + deptNum + ", deptName=" + deptName + ", majorName="
				+ majorName + ", majorAssistant=" + majorAssistant + ", majorTel=" + majorTel + "]";
	}
}