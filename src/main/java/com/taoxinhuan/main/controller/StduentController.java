package com.taoxinhuan.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.taoxinhuan.main.PO.Student;
import com.taoxinhuan.main.VO.StudentVO;
import com.taoxinhuan.main.query.StudentQuery;
import com.taoxinhuan.main.service.StudentService;
import com.taoxinhuan.main.util.PageList;

@RestController
public class StduentController {

	@Autowired
	private StudentService StudentService;

	@RequestMapping(value = "student/add", method = RequestMethod.POST)
	public void addStudent(@RequestBody Student student) {
		StudentService.add(student);
	}

	@RequestMapping(value = "student/list", method = RequestMethod.POST)
	public PageList<StudentVO> listStudent(@RequestBody StudentQuery query) {
		PageList<StudentVO> listStudent = StudentService.listStudent(query);
		return listStudent;
	}

	@RequestMapping(value = "student/get/{studentNum}", method = RequestMethod.POST)
	public StudentVO getStudent(@PathVariable("studentNum") String studentNum) {
		StudentVO studentVO = StudentService.get(studentNum);
		return studentVO;
	}

	@RequestMapping(value = "student/update", method = RequestMethod.POST)
	public void updateStudent(@RequestBody Student student) {
		StudentService.update(student);
	}



}
