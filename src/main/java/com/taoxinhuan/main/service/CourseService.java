package com.taoxinhuan.main.service;

import com.taoxinhuan.main.PO.Course;
import com.taoxinhuan.main.VO.CourseForStudentVO;
import com.taoxinhuan.main.VO.CourseVO;
import com.taoxinhuan.main.query.CourseForStudentQuery;
import com.taoxinhuan.main.query.CourseQuery;
import com.taoxinhuan.main.util.PageList;

public interface CourseService {
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
	CourseVO get(String courseNum);

	/**
	 * 
	 * @Destribution: 查询课程列表
	 * @return
	 * @return Page<Course>
	 */
	PageList<CourseVO> listCourse(CourseQuery query);

	/**
	 * 获取该学生系部选修课
	 * 
	 * @param query
	 * @return
	 */
	PageList<CourseForStudentVO> listCourseForStudent(CourseForStudentQuery query);
}
