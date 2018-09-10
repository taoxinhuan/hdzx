package com.taoxinhuan.main.VO;

import java.io.Serializable;

/**
 * @Description:系部VO模型
 * @author taoxinhuan
 * @date 2018年1月5日 上午11:10:30
 */
public class DeptVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2103068111450224008L;

	/**
	 * 系部编号
	 */
    private String deptNum;
	
	/**
	 * 系部名称
	 */
    private String deptName;
	
	/**
	 * 系主任名称
	 */
    private String deptChairman;
	
	/**
	 * 系主任电话
	 */
    private String deptTel;
	
	/**
	 * 系部描述
	 */
    private String deptDesc;

    public String getDeptNum() {
        return deptNum;
    }

    public void setDeptNum(String deptNum) {
        this.deptNum = deptNum == null ? null : deptNum.trim();
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    public String getDeptChairman() {
        return deptChairman;
    }

    public void setDeptChairman(String deptChairman) {
        this.deptChairman = deptChairman == null ? null : deptChairman.trim();
    }

    public String getDeptTel() {
        return deptTel;
    }

    public void setDeptTel(String deptTel) {
        this.deptTel = deptTel == null ? null : deptTel.trim();
    }

    public String getDeptDesc() {
        return deptDesc;
    }

    public void setDeptDesc(String deptDesc) {
        this.deptDesc = deptDesc == null ? null : deptDesc.trim();
    }
	
	@Override
	public String toString() {
		return "DeptVO [deptNum=" + deptNum + ", deptName=" + deptName + ", deptChairman=" + deptChairman + ", deptTel="
				+ deptTel + ", deptDesc=" + deptDesc + "]";
	}
}