package com.taoxinhuan.main.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taoxinhuan.main.PO.Course;
import com.taoxinhuan.main.VO.CourseForStudentVO;
import com.taoxinhuan.main.VO.CourseVO;
import com.taoxinhuan.main.bl.CourseBL;
import com.taoxinhuan.main.query.CourseForStudentQuery;
import com.taoxinhuan.main.query.CourseQuery;
import com.taoxinhuan.main.service.CourseService;
import com.taoxinhuan.main.util.PageList;

@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseBL courseBL;
	
	@Override
	public void add(Course record) {
		courseBL.add(record);
	}
	
	@Override
	public void delete(String courseNum) {
		courseBL.delete(courseNum);
	}
	
	@Override
	public void update(Course record) {
		courseBL.update(record);
	}
	
	@Override
	public CourseVO get(String courseNum) {
		CourseVO courseVO = courseBL.get(courseNum);
		return courseVO;
	}

	@Override
	public PageList<CourseVO> listCourse(CourseQuery query) {
		PageList<CourseVO> listCourse = courseBL.listCourse(query);
		return listCourse;
	}

	@Override
	public PageList<CourseForStudentVO> listCourseForStudent(CourseForStudentQuery query) {
		PageList<CourseForStudentVO> listCourseForStudent = courseBL.listCourseForStudent(query);
		return listCourseForStudent;
	}

}
