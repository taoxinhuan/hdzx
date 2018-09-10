package com.taoxinhuan.main.service;

import com.taoxinhuan.main.PO.Student;
import com.taoxinhuan.main.VO.StudentVO;
import com.taoxinhuan.main.query.StudentQuery;
import com.taoxinhuan.main.util.PageList;

public interface StudentService {
	/**
	 * 增加学生
	 * @param record
	 * @return void
	 */
	void add(Student record);
	
	/**
	 * 删除学生
	 * @param studentNum
	 * @return void
	 */
	void delete(String studentNum);
	
	/**
	 * 更改学生信息
	 * @param record
	 * @return void
	 */
	void update(Student record);
	
	/**
	 * 查询学生信息
	 * @param studentNum
	 * @return
	 * @return Student
	 */
	StudentVO get(String studentNum);
	
	/**
	 * 学生登陆
	 * 
	 * @param studentNum
	 * @param password
	 * @return
	 * @return Student
	 */
	StudentVO studentLogin(String studentNum, String password);

	/**
	 * 
	 * @Destribution: 查询学生列表
	 * @return
	 * @return Page<Student>
	 */
	PageList<StudentVO> listStudent(StudentQuery query);
}
