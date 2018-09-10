package com.taoxinhuan.main.bl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.taoxinhuan.main.PO.Dept;
import com.taoxinhuan.main.PO.Teacher;
import com.taoxinhuan.main.VO.TeacherVO;
import com.taoxinhuan.main.dao.DeptMapper;
import com.taoxinhuan.main.dao.TeacherMapper;
import com.taoxinhuan.main.query.TeacherQuery;
import com.taoxinhuan.main.util.DateUtil;
import com.taoxinhuan.main.util.PageList;
import com.taoxinhuan.main.util.Pager;

@Service
public class TeacherBL {
	@Autowired
	private TeacherMapper teacherMapper;
	
	@Autowired
	private DeptMapper deptMapper;
	
	public void add(Teacher record) {
		teacherMapper.add(record);
	}
	
	public void delete(String teacherNum) {
		teacherMapper.delete(teacherNum);
	}
	
	public void update(Teacher record) {
		teacherMapper.update(record);
	}
	
	public TeacherVO get(String teacherNum) {
		Teacher teacher = teacherMapper.get(teacherNum);
		TeacherVO vo = ToVO(teacher);
		return vo;
	}

	public TeacherVO teacherLogin(String teacherNum, String password) {
		Teacher teacher = teacherMapper.teacherLogin(teacherNum, password);
		TeacherVO vo = ToVO(teacher);
		return vo;
	}
	/** 
	 * @param teacher
	 * @return
	 * @return TeacherVO
	 */
	private TeacherVO ToVO(Teacher teacher) {
		TeacherVO vo = null;
		Dept dept = null;
		if (null != teacher) {
			vo = new TeacherVO();
			Date teacherBirthday = teacher.getTeacherBirthday();
			String stringDateFormat = DateUtil.getStringDateFormat(teacherBirthday);
			vo.setTeacherBirthday(stringDateFormat);
			vo.setTeacherName(teacher.getTeacherName());
			vo.setTeacherNum(teacher.getTeacherNum());
			vo.setTeacherSex(teacher.getTeacherSex());
			vo.setTeacherTitle(teacher.getTeacherTitle());
			vo.setDeptNum(teacher.getDeptNum());
			vo.setTeacherPassword(teacher.getTeacherPassword());
			// 获取系部
			String deptNum = teacher.getDeptNum();
			dept = deptMapper.get(deptNum);
			if (null != dept) {
				vo.setDeptName(dept.getDeptName());
			}
		}
		return vo;
	}

	public PageList<TeacherVO> listTeacher(TeacherQuery query) {
		Integer currentPage = query.getPageIndex();
		Integer pageSize = query.getPageSize();
		PageHelper.startPage(currentPage, pageSize);
		Page<Teacher> listTeacher = teacherMapper.listTeacher(query);
		PageList<TeacherVO> pageList = new PageList<>();
		Long total = listTeacher.getTotal();
		List<TeacherVO> voList = new ArrayList<>();
		if (total.intValue() > 0) {
			listTeacher.forEach(teacher -> {
				TeacherVO toVO = ToVO(teacher);
				voList.add(toVO);
			});
		}
		Pager pager = new Pager(currentPage, pageSize, total.intValue());
		pageList.setDataList(voList);
		pageList.setPager(pager);
		return pageList;
	}
}
