package com.taoxinhuan.main.service;

import java.util.List;

import com.taoxinhuan.main.PO.Grade;
import com.taoxinhuan.main.VO.GradeVO;
import com.taoxinhuan.main.query.GradeQuery;
import com.taoxinhuan.main.util.PageList;

public interface GradeService {
	/**
	 * 增加一条成绩
	 * @param record
	 * @return
	 * @return int
	 */
	void add(Grade record);
	
	/**
	 * 删除一条成绩
	 * @param num
	 * @return void
	 */
	void deleteByStuNumAndCourseNum(String stuNum,String courseNum);

	/**
	 * 获取单个学生的成绩
	 * 
	 * @param stuNum
	 * @param courseNum
	 * @return
	 */
	GradeVO getByStuNumAndCourseNum(String stuNum, String courseNum);
	/**
	 * 更改一条成绩
	 * @param record
	 * @return void
	 */
	void update(Grade record);
	
	/**
	 * 获取学生成绩(根据学生编号)
	 * @param stuNum 
	 * @return
	 * @return GradeVO
	 */
	List<GradeVO> getStuGrades(String stuNum);
    /**
     * 获取教师手底下学生的成绩表
     * @param query
     * @return
     */
	PageList<GradeVO> listForTeacher(GradeQuery query);
	

}
