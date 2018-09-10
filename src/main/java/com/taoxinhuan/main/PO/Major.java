package com.taoxinhuan.main.PO;

import java.io.Serializable;

/**
 * @Description:选修课
 * @author taoxinhuan
 * @date 2018年1月5日 上午11:04:44
 */
public class Major implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3522429544281140750L;

	/**
	 * 专业编号
	 */
    private String majorNum;
	
	/**
	 * 所属系部编号
	 */
    private String deptNum;
	
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

    public String getDeptNum() {
        return deptNum;
    }

    public void setDeptNum(String deptNum) {
        this.deptNum = deptNum == null ? null : deptNum.trim();
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
}