package com.taoxinhuan.main.bl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.taoxinhuan.main.PO.Student;
import com.taoxinhuan.main.VO.DeptVO;
import com.taoxinhuan.main.VO.MajorVO;
import com.taoxinhuan.main.VO.StudentVO;
import com.taoxinhuan.main.dao.StudentMapper;
import com.taoxinhuan.main.query.StudentQuery;
import com.taoxinhuan.main.util.DateUtil;
import com.taoxinhuan.main.util.PageList;
import com.taoxinhuan.main.util.Pager;

@Service
public class StudentBL {
	@Autowired
	private StudentMapper studentMapper;

	@Autowired
	private MajorBL majorBL;

	@Autowired
	private DeptBL deptBL;

	public void add(Student record) {
		studentMapper.add(record);
	}

	public void delete(String studentNum) {
		studentMapper.delete(studentNum);
	}

	public void update(Student record) {
		studentMapper.update(record);
	}

	public StudentVO get(String studentNum) {
		Student student = studentMapper.get(studentNum);
		StudentVO studentVO = new StudentVO();
		converter(student, studentVO);
		searchMore(student, studentVO);
		return studentVO;
	}

	public StudentVO studentLogin(String studentNum, String password) {
		Student student = studentMapper.studentLogin(studentNum, password);
		if (null != student) {
			StudentVO studentVO = new StudentVO();
			converter(student, studentVO);
			searchMore(student, studentVO);
			return studentVO;
		} else {
			return null;
		}
	}

	private void converter(Student student, StudentVO studentVO) {
		Date studentBirthday = student.getStudentBirthday();
		String stringDateFormat = DateUtil.getStringDateFormat(studentBirthday);
		studentVO.setStudentBirthday(stringDateFormat);
		studentVO.setStudentName(student.getStudentName());
		studentVO.setStudentNum(student.getStudentNum());
		studentVO.setStudentPassword(student.getStudentPassword());
		studentVO.setStudentSex(student.getStudentSex());
		studentVO.setMajorNum(student.getMajorNum());
		studentVO.setDeptNum(student.getDeptNum());
	}

	private StudentVO searchMore(Student student, StudentVO studentVO) {
		// 专业
		String majorNum = student.getMajorNum();
		MajorVO majorVO = majorBL.get(majorNum);
		studentVO.setMajorName(majorVO.getMajorName());
		// 系部
		String deptNum = student.getDeptNum();
		DeptVO deptVO = deptBL.get(deptNum);
		studentVO.setDeptName(deptVO.getDeptName());
		return studentVO;
	}


	public PageList<StudentVO> listStudent(StudentQuery query) {
		Integer currentPage = query.getPageIndex();
		Integer pageSize = query.getPageSize();
		PageHelper.startPage(currentPage, pageSize);
		Page<Student> listMajorStudent = studentMapper.listStudent(query);
		PageList<StudentVO> pageList = new PageList<>();
		Long total = listMajorStudent.getTotal();
		List<StudentVO> voList = new ArrayList<>();
		if (total.intValue() > 0) {
			listMajorStudent.forEach(student -> {
				StudentVO studentVO = new StudentVO();
				converter(student, studentVO);
				searchMore(student, studentVO);
				voList.add(studentVO);
			});
		}
		Pager pager = new Pager(currentPage, pageSize, total.intValue());
		pageList.setDataList(voList);
		pageList.setPager(pager);
		return pageList;
	}

}
