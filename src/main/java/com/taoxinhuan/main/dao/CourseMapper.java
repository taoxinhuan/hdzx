package com.taoxinhuan.main.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.github.pagehelper.Page;
import com.taoxinhuan.main.PO.Course;
import com.taoxinhuan.main.PO.CourseForStudent;
import com.taoxinhuan.main.query.CourseForStudentQuery;
import com.taoxinhuan.main.query.CourseQuery;

@Repository
public interface CourseMapper {
	/**
	 * 增加一门课程
	 * @param record
	 * @return void
	 */
	void add(Course record);
	
	/**
	 * 删除一门课程
	 * @param courseNum
	 * @return void
	 */
	void delete(String courseNum);
	
	/**
	 * 更改一门课程
	 * @param record
	 * @return void
	 */
	void update(Course record);
	
	/**
	 * 获得一门课程的详细信息
	 * @param courseNum
	 * @return
	 * @return Course
	 */
	Course get(String courseNum);

	/**
	 * 
	 * @Destribution: 查询课程列表管理員
	 * @return
	 * @return Page<Course>
	 */
	Page<Course> listCourse(@Param("query") CourseQuery query);

	/**
	 * 获取该学生系部的所有选修课
	 * 
	 * @param deptNum
	 * @return
	 */
	Page<CourseForStudent> listCourseForStudent(@Param("query") CourseForStudentQuery query);

}