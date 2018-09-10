package com.taoxinhuan.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.taoxinhuan.main.PO.Teacher;
import com.taoxinhuan.main.VO.TeacherVO;
import com.taoxinhuan.main.query.TeacherQuery;
import com.taoxinhuan.main.service.TeacherService;
import com.taoxinhuan.main.util.PageList;

@RestController
public class TeacherController {
	@Autowired
	private TeacherService teacherService;


	@RequestMapping(value = "teacher/add", method = RequestMethod.POST)
	public void addTeacher(@RequestBody Teacher Teacher) {
		teacherService.add(Teacher);
	}

	@RequestMapping(value = "teacher/list", method = RequestMethod.POST)
	public PageList<TeacherVO> listTeacher(@RequestBody TeacherQuery query) {
		PageList<TeacherVO> listTeacher = teacherService.listTeacher(query);
		return listTeacher;
	}

	@RequestMapping(value = "teacher/get/{teacherNum}", method = RequestMethod.POST)
	public TeacherVO getDept(@PathVariable("teacherNum") String teacherNum) {
		TeacherVO teacherVO = teacherService.get(teacherNum);
		return teacherVO;
	}

	@RequestMapping(value = "teacher/update", method = RequestMethod.POST)
	public void updateDept(@RequestBody Teacher teacher) {
		teacherService.update(teacher);
	}


}
