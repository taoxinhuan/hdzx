package com.taoxinhuan.main.service;

import com.taoxinhuan.main.PO.Teacher;
import com.taoxinhuan.main.VO.TeacherVO;
import com.taoxinhuan.main.query.TeacherQuery;
import com.taoxinhuan.main.util.PageList;

public interface TeacherService {
	/**
	 * 添加老师
	 * @param record
	 * @return void
	 */
	void add(Teacher record);
	
	/**
	 * 删除老师
	 * @param teacherNum
	 * @return void
	 */
	void delete(String teacherNum);
	
	/**
	 * 跟新老师信息
	 * @param record
	 * @return void
	 */
	void update(Teacher record);
	
	/**
	 * 查询单个老师信息
	 * @param teacherNum
	 * @return
	 * @return Teacher
	 */
	TeacherVO get(String teacherNum);

	/**
	 * 教师登陆
	 * 
	 * @param studentNum
	 * @param password
	 * @return
	 * @return Student
	 */
	TeacherVO teacherLogin(String teacherNum, String password);

	/**
	 * 
	 * @Destribution: 查询教师列表
	 * @return
	 * @return Page<Student>
	 */
	PageList<TeacherVO> listTeacher(TeacherQuery query);
}
