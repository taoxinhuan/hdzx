package com.taoxinhuan.main.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.github.pagehelper.Page;
import com.taoxinhuan.main.PO.Grade;
import com.taoxinhuan.main.query.GradeQuery;

@Repository
public interface GradeMapper {
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
	void deleteByStuNumAndCourseNum(@Param("stuNum")String stuNum,@Param("courseNum")String courseNum);
	
	/**
	 * 更改一条成绩
	 * @param record
	 * @return void
	 */
	void update(Grade record);

	/**
	 * 获取学生成绩
	 * 
	 * @param stuNum
	 * @param courseNum
	 * @return
	 */
	Grade getByStuNumAndCourseNum(@Param("stuNum") String stuNum, @Param("courseNum") String courseNum);

	/**
	 * 获取单个学生的成绩
	 * 
	 * @param num
	 * @return
	 * @return Grade
	 */
	List<Grade> listByStudentNum(String studentNum);

	/**
	 * 获取教师教的课程的成绩
	 * 
	 * @param num
	 * @return
	 * @return Grade
	 */
	Page<Grade> listForTeacher(@Param("query") GradeQuery query);


}