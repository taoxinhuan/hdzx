package com.taoxinhuan.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.taoxinhuan.main.PO.Course;
import com.taoxinhuan.main.VO.CourseForStudentVO;
import com.taoxinhuan.main.VO.CourseVO;
import com.taoxinhuan.main.query.CourseForStudentQuery;
import com.taoxinhuan.main.query.CourseQuery;
import com.taoxinhuan.main.service.CourseService;
import com.taoxinhuan.main.util.PageList;

@RestController
public class CourseController {
	@Autowired
	private CourseService courseService;

	@RequestMapping(value = "course/add", method = RequestMethod.POST)
	public void addCourse(@RequestBody Course course) {
		courseService.add(course);
	}

	@RequestMapping(value = "course/list", method = RequestMethod.POST)
	public PageList<CourseVO> listCourse(@RequestBody CourseQuery query) {
		PageList<CourseVO> listCourse = courseService.listCourse(query);
		return listCourse;
	}

	@RequestMapping(value = "course/get/{courseNum}", method = RequestMethod.POST)
	public CourseVO getCourse(@PathVariable("courseNum") String courseNum) {
		CourseVO courseVO = courseService.get(courseNum);
		return courseVO;
	}

	@RequestMapping(value = "course/update", method = RequestMethod.POST)
	public void updateCourse(@RequestBody Course course) {
		courseService.update(course);
	}

	@RequestMapping(value = "course/listForStudent", method = RequestMethod.POST)
	public PageList<CourseForStudentVO> listCourseForStudent(@RequestBody CourseForStudentQuery query) {
		PageList<CourseForStudentVO> listCourseForStudent = courseService.listCourseForStudent(query);
		return listCourseForStudent;
	}


}
