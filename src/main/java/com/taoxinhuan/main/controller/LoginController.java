package com.taoxinhuan.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.taoxinhuan.main.VO.ManagerVO;
import com.taoxinhuan.main.VO.StudentVO;
import com.taoxinhuan.main.VO.TeacherVO;
import com.taoxinhuan.main.service.ManagerService;
import com.taoxinhuan.main.service.StudentService;
import com.taoxinhuan.main.service.TeacherService;

@RestController
public class LoginController {

	@Autowired
	private StudentService studentService;
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private ManagerService managerService;

	@RequestMapping(value = "/studentLogin/{studentNum}/{password}", method = RequestMethod.GET)
	public StudentVO studentLogin(@PathVariable("studentNum") String studentNum,
			@PathVariable("password") String password) {
		StudentVO studentVO = studentService.studentLogin(studentNum, password);
		return studentVO;

	}

	@RequestMapping(value = "/teacherLogin/{teacherNum}/{password}", method = RequestMethod.GET)
	public TeacherVO teacherLogin(@PathVariable("teacherNum") String teacherNum,
			@PathVariable("password") String password) {
		TeacherVO teacherVO = teacherService.teacherLogin(teacherNum, password);
		return teacherVO;

	}

	@RequestMapping(value = "/managerLogin/{managerNum}/{password}", method = RequestMethod.GET)
	public ManagerVO managerLogin(@PathVariable("managerNum") String managerNum,
			@PathVariable("password") String password) {
		ManagerVO managerVO = managerService.managerLogin(managerNum, password);
		return managerVO;

	}

}
