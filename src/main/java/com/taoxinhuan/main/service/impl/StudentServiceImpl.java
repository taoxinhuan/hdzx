package com.taoxinhuan.main.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taoxinhuan.main.PO.Student;
import com.taoxinhuan.main.VO.StudentVO;
import com.taoxinhuan.main.bl.StudentBL;
import com.taoxinhuan.main.query.StudentQuery;
import com.taoxinhuan.main.service.StudentService;
import com.taoxinhuan.main.util.PageList;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentBL studentBL;

	@Override
	public void add(Student record) {
		studentBL.add(record);
	}

	@Override
	public void delete(String studentNum) {
		studentBL.delete(studentNum);
	}

	@Override
	public void update(Student record) {
		studentBL.update(record);
	}

	@Override
	public StudentVO get(String studentNum) {
		StudentVO studentVO = studentBL.get(studentNum);
		return studentVO;
	}

	@Override
	public StudentVO studentLogin(String studentNum, String password) {
		StudentVO studentVO = studentBL.studentLogin(studentNum, password);
		return studentVO;
	}

	@Override
	public PageList<StudentVO> listStudent(StudentQuery query) {
		PageList<StudentVO> listStudent = studentBL.listStudent(query);
		return listStudent;
	}

}
