package com.taoxinhuan.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.taoxinhuan.main.PO.Grade;
import com.taoxinhuan.main.VO.GradeVO;
import com.taoxinhuan.main.query.GradeQuery;
import com.taoxinhuan.main.service.GradeService;
import com.taoxinhuan.main.util.PageList;

@RestController
public class GradeController {

	@Autowired
	private GradeService gradeService;

	@RequestMapping(value = "grade/add", method = RequestMethod.POST)
	public void addGrade(@RequestBody Grade grade) {
		gradeService.add(grade);
	}

	@RequestMapping(value = "grade/delete/{stuNum}/{courseNum}", method = RequestMethod.POST)
	public void deleteByStuNumAndCourseNum(@PathVariable("stuNum") String stuNum,
			@PathVariable("courseNum") String courseNum) {
		gradeService.deleteByStuNumAndCourseNum(stuNum, courseNum);
	}

	@RequestMapping(value = "grade/getStuGrades/{studentNum}", method = RequestMethod.POST)
	public List<GradeVO> getStuGrades(@PathVariable("studentNum") String studentNum) {
		List<GradeVO> stuGrades = gradeService.getStuGrades(studentNum);
		return stuGrades;
	}

	@PostMapping("grade/listForTeacher")
	public PageList<GradeVO> listForTeacher(@RequestBody GradeQuery query) {
		PageList<GradeVO> listForTeacher = gradeService.listForTeacher(query);
		return listForTeacher;
	}

	@PostMapping("grade/update")
	public void updateGrade(@RequestBody Grade record) {
		gradeService.update(record);
	}

	@PostMapping("grade/get/{stuNum}/{courseNum}")
	public GradeVO getByStuNumAndCourseNum(@PathVariable("stuNum") String stuNum,
			@PathVariable("courseNum") String courseNum) {
		GradeVO vo = gradeService.getByStuNumAndCourseNum(stuNum, courseNum);
		return vo;
	}

}
