package com.taoxinhuan.main.PO;

import java.io.Serializable;

/**
 * @Description:控制是否能选修或者设置成绩的开关
 * @author taoxinhuan
 * @date 2018年1月5日 上午11:07:18
 */
public class Control implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1640376149052801925L;

	/**
	 * 开关ID
	 */
    private String id;
	
	/**
	 * 选课标志位 0可选 1不可选
	 */
	private Boolean selectCourse;
	
	/**
	 * 输入成绩标志位0可输入1不可输入
	 */
	private Boolean inputGrade;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Boolean getSelectCourse() {
		return selectCourse;
	}

	public void setSelectCourse(Boolean selectCourse) {
		this.selectCourse = selectCourse;
	}

	public Boolean getInputGrade() {
		return inputGrade;
	}

	public void setInputGrade(Boolean inputGrade) {
		this.inputGrade = inputGrade;
	}


}