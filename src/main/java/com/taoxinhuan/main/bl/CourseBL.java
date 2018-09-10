package com.taoxinhuan.main.bl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.taoxinhuan.main.PO.Course;
import com.taoxinhuan.main.PO.CourseForStudent;
import com.taoxinhuan.main.VO.CourseForStudentVO;
import com.taoxinhuan.main.VO.CourseVO;
import com.taoxinhuan.main.VO.TeacherVO;
import com.taoxinhuan.main.conventer.CourseForStudentConverter;
import com.taoxinhuan.main.dao.CourseMapper;
import com.taoxinhuan.main.query.CourseForStudentQuery;
import com.taoxinhuan.main.query.CourseQuery;
import com.taoxinhuan.main.util.PageList;
import com.taoxinhuan.main.util.Pager;

@Service
public class CourseBL {

	@Autowired
	private CourseMapper courseMapper;
	
	@Autowired
	private TeacherBL teacherBL;
	
	public void add(Course record) {
		courseMapper.add(record);
	}
	
	public void delete(String courseNum) {
		courseMapper.delete(courseNum);
	}
	
	public void update(Course record) {
		courseMapper.update(record);
	}
	
	public CourseVO get(String courseNum) {
		Course course = courseMapper.get(courseNum);
		CourseVO vo = toVO(course);
		return vo;
	}

	private CourseVO toVO(Course course) {
		CourseVO vo = null;
		if (null != course) {
			vo = new CourseVO();
			vo.setCourseClass(course.getCourseClass());
			vo.setCourseCredit(course.getCourseCredit());
			vo.setCourseDesc(course.getCourseDesc());
			vo.setCourseName(course.getCourseName());
			vo.setCourseNum(course.getCourseNum());
			vo.setTeacherNum(course.getTeacherNum());
			String teacherNum = course.getTeacherNum();
			TeacherVO teacherVO = teacherBL.get(teacherNum);
			if (null != teacherVO) {
				vo.setTeacherName(teacherVO.getTeacherName());
			}

		}
		return vo;
	}

	public PageList<CourseVO> listCourse(CourseQuery query) {
		Integer currentPage = query.getPageIndex();
		Integer pageSize = query.getPageSize();
		PageHelper.startPage(currentPage, pageSize);
		Page<Course> listDept = courseMapper.listCourse(query);
		PageList<CourseVO> pageList = new PageList<>();
		Long total = listDept.getTotal();
		List<CourseVO> voList = new ArrayList<>();
		if (total.intValue() > 0) {
			listDept.forEach(course -> {
				CourseVO vo = toVO(course);
				voList.add(vo);
			});
		}
		Pager pager = new Pager(currentPage, pageSize, total.intValue());
		pageList.setDataList(voList);
		pageList.setPager(pager);
		return pageList;
	}

	public PageList<CourseForStudentVO> listCourseForStudent(CourseForStudentQuery query) {
		Integer currentPage = query.getPageIndex();
		Integer pageSize = query.getPageSize();
		PageHelper.startPage(currentPage, pageSize);
		PageList<CourseForStudentVO> pageList = new PageList<>();
		Page<CourseForStudent> listCourseForStudent = courseMapper.listCourseForStudent(query);
		List<CourseForStudentVO> toVOList = CourseForStudentConverter.ToVOList(listCourseForStudent);
		Long total = listCourseForStudent.getTotal();
		Pager pager = new Pager(currentPage, pageSize, total.intValue());
		pageList.setDataList(toVOList);
		pageList.setPager(pager);
		return pageList;
	}
}
