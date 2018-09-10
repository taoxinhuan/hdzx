package com.taoxinhuan.main.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taoxinhuan.main.PO.Teacher;
import com.taoxinhuan.main.VO.TeacherVO;
import com.taoxinhuan.main.bl.TeacherBL;
import com.taoxinhuan.main.query.TeacherQuery;
import com.taoxinhuan.main.service.TeacherService;
import com.taoxinhuan.main.util.PageList;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private TeacherBL teacherBL;
	
	@Override
	public void add(Teacher record) {
		teacherBL.add(record);
	}
	
	@Override
	public void delete(String teacherNum) {
		teacherBL.delete(teacherNum);
	}
	
	@Override
	public void update(Teacher record) {
		teacherBL.update(record);
	}
	
	@Override
	public TeacherVO get(String teacherNum) {
		TeacherVO teacherVO = teacherBL.get(teacherNum);
		return teacherVO;
	}

	@Override
	public TeacherVO teacherLogin(String teacherNum, String password) {
		TeacherVO teacherVO = teacherBL.teacherLogin(teacherNum, password);
		return teacherVO;
	}

	@Override
	public PageList<TeacherVO> listTeacher(TeacherQuery query) {
		PageList<TeacherVO> listTeacher = teacherBL.listTeacher(query);
		return listTeacher;
	}
}
