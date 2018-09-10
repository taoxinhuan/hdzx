package com.taoxinhuan.main.VO;

import java.io.Serializable;

/**
 * @Description:管理员
 * @author taoxinhuan
 * @date 2018年1月5日 上午11:13:29
 */
public class ManagerVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3152248225572875924L;

	/**
	 * 管理员账号
	 */
    private String managerNum;
	
	/**
	 * 管理员密码
	 */
    private String managerPassword;
	
	/**
	 * 管理员名称
	 */
    private String managerName;

    public String getManagerNum() {
        return managerNum;
    }

    public void setManagerNum(String managerNum) {
        this.managerNum = managerNum == null ? null : managerNum.trim();
    }

    public String getManagerPassword() {
        return managerPassword;
    }

    public void setManagerPassword(String managerPassword) {
        this.managerPassword = managerPassword == null ? null : managerPassword.trim();
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName == null ? null : managerName.trim();
    }

	@Override
	public String toString() {
		return "ManagerVO [managerNum=" + managerNum + ", managerPassword=" + managerPassword + ", managerName="
				+ managerName + "]";
	}
    
}