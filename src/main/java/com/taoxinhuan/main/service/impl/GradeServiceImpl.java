package com.taoxinhuan.main.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taoxinhuan.main.PO.Grade;
import com.taoxinhuan.main.VO.GradeVO;
import com.taoxinhuan.main.bl.GradeBL;
import com.taoxinhuan.main.query.GradeQuery;
import com.taoxinhuan.main.service.GradeService;
import com.taoxinhuan.main.util.PageList;

@Service
public class GradeServiceImpl implements GradeService {
	@Autowired
	private GradeBL gradeBL;
	
	@Override
	public void add(Grade record) {
		gradeBL.add(record);
	}
	
	@Override
	public void deleteByStuNumAndCourseNum(String stuNum,String courseNum) {
		gradeBL.deleteByStuNumAndCourseNum(stuNum, courseNum);
	}
	
	@Override
	public void update(Grade record) {
		gradeBL.update(record);
	}
	
	@Override
	public List<GradeVO> getStuGrades(String num) {
		List<GradeVO> stuGrades = gradeBL.getStuGrades(num);
		return stuGrades;
	}

	@Override
	public PageList<GradeVO> listForTeacher(GradeQuery query) {
		PageList<GradeVO> listForTeacher = gradeBL.listForTeacher(query);
		return listForTeacher;
	}

	@Override
	public GradeVO getByStuNumAndCourseNum(String stuNum, String courseNum) {
		return gradeBL.getByStuNumAndCourseNum(stuNum, courseNum);
	}

}
