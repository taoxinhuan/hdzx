package com.taoxinhuan.main.bl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.taoxinhuan.main.PO.Grade;
import com.taoxinhuan.main.VO.CourseVO;
import com.taoxinhuan.main.VO.GradeVO;
import com.taoxinhuan.main.VO.StudentVO;
import com.taoxinhuan.main.VO.TeacherVO;
import com.taoxinhuan.main.dao.GradeMapper;
import com.taoxinhuan.main.query.GradeQuery;
import com.taoxinhuan.main.util.PageList;
import com.taoxinhuan.main.util.Pager;

@Service
public class GradeBL {
	@Autowired
	private GradeMapper gradeMapper;
	
	@Autowired
	private StudentBL studentBL;
	
	@Autowired
	private TeacherBL teacherBL;
	
	@Autowired
	private CourseBL courseBL;
	
	public void add(Grade record) {
		gradeMapper.add(record);
	}
	
	public void deleteByStuNumAndCourseNum(String stuNum,String courseNum) {
		gradeMapper.deleteByStuNumAndCourseNum(stuNum, courseNum);
	}
	
	public void update(Grade record) {
		gradeMapper.update(record);
	}
	
	public List<GradeVO> getStuGrades(String studentNum) {
		List<Grade> listByStudentNum = gradeMapper.listByStudentNum(studentNum);
		List<GradeVO> voList = new ArrayList<>();
		listByStudentNum.forEach(grade -> {
			GradeVO gradeVO = toVO(grade);
			voList.add(gradeVO);
		});
		return voList;
	}

	public PageList<GradeVO> listForTeacher(GradeQuery query) {
		Integer currentPage = query.getPageIndex();
		Integer pageSize = query.getPageSize();
		PageHelper.startPage(currentPage, pageSize);
		Page<Grade> listByStudentNum = gradeMapper.listForTeacher(query);
		PageList<GradeVO> pageList = new PageList<>();
		Long total = listByStudentNum.getTotal();
		List<GradeVO> voList = new ArrayList<>();
		if (total.intValue() > 0) {
			listByStudentNum.forEach(grade -> {
				GradeVO gradeVO = toVO(grade);
				voList.add(gradeVO);
			});
		}
		Pager pager = new Pager(currentPage, pageSize, total.intValue());
		pageList.setDataList(voList);
		pageList.setPager(pager);
		return pageList;
	}

	private GradeVO toVO(Grade grade) {
		GradeVO gradeVO = new GradeVO();
		if (null != grade) {
			String courseNum = grade.getCourseNum();
			CourseVO courseVO = courseBL.get(courseNum);
			String studentNum = grade.getStudentNum();
			StudentVO studentVO = studentBL.get(studentNum);
			String teacherNum = grade.getTeacherNum();
			TeacherVO teacherVO = teacherBL.get(teacherNum);
			if (null != courseVO) {
				gradeVO.setCourseName(courseVO.getCourseName());
				gradeVO.setCourseClass(courseVO.getCourseClass());
				gradeVO.setCourseCredit(courseVO.getCourseCredit());
			}
			if (null != studentVO) {
				gradeVO.setStudentName(studentVO.getStudentName());
			}
			if (null != teacherVO) {
				gradeVO.setTeacherName(teacherVO.getTeacherName());
			}
			gradeVO.setCourseNum(grade.getCourseNum());
			gradeVO.setGrade(grade.getGrade());
			gradeVO.setStudentNum(grade.getStudentNum());
			gradeVO.setTeacherNum(grade.getTeacherNum());
		}
		return gradeVO;
	}

	public GradeVO getByStuNumAndCourseNum(String stuNum, String courseNum) {
		Grade grade = gradeMapper.getByStuNumAndCourseNum(stuNum, courseNum);
		GradeVO vo = toVO(grade);
		return vo;
	}
}
