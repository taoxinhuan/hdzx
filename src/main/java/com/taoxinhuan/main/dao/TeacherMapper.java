package com.taoxinhuan.main.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.github.pagehelper.Page;
import com.taoxinhuan.main.PO.Teacher;
import com.taoxinhuan.main.query.TeacherQuery;

@Repository
public interface TeacherMapper {
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
	Teacher get(String teacherNum);

	/**
	 * 教师登陆
	 * 
	 * @param teacherNum
	 * @param password
	 * @return
	 * @return Teacher
	 */
	Teacher teacherLogin(@Param("teacherNum") String teacherNum, @Param("password") String password);

	/**
	 * 分页查询教师
	 * 
	 * @param query
	 * @return
	 * @return Page<Teacher>
	 */
	Page<Teacher> listTeacher(@Param("query") TeacherQuery query);
}