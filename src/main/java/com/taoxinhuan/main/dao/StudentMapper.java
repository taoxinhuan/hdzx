package com.taoxinhuan.main.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.github.pagehelper.Page;
import com.taoxinhuan.main.PO.Student;
import com.taoxinhuan.main.query.StudentQuery;

@Repository
public interface StudentMapper {
	/**
	 * 增加学生
	 * 
	 * @param record
	 * @return void
	 */
	void add(Student record);

	/**
	 * 删除学生
	 * 
	 * @param studentNum
	 * @return void
	 */
	void delete(String studentNum);

	/**
	 * 更改学生信息
	 * 
	 * @param record
	 * @return void
	 */
	void update(Student record);

	/**
	 * 查询学生信息
	 * 
	 * @param studentNum
	 * @return
	 * @return Student
	 */
	Student get(String studentNum);

	/**
	 * 学生登陆
	 * 
	 * @param studentNum
	 * @param password
	 * @return
	 * @return Student
	 */
	Student studentLogin(@Param("studentNum") String studentNum, @Param("password") String password);


	/**
	 * 
	 * @Destribution: 查询学生列表
	 * @return
	 * @return Page<Student>
	 */
	Page<Student> listStudent(@Param("query") StudentQuery query);
}
