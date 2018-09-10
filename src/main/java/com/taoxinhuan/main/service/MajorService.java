package com.taoxinhuan.main.service;

import com.taoxinhuan.main.PO.Major;
import com.taoxinhuan.main.VO.MajorVO;
import com.taoxinhuan.main.query.MajorQuery;
import com.taoxinhuan.main.util.PageList;

public interface MajorService {
	/**
	 * 添加专业
	 * @param record
	 * @return void
	 */
	void add(Major record);
	
	/**
	 * 删除专业
	 * @param majorNum
	 * @return void
	 */
	void delete(String majorNum);
	
	/**
	 * 修改专业
	 * @param record
	 * @return void
	 */
	void update(Major record);
	
	/**
	 * 查询单个专业信息
	 * @param majorNum
	 * @return
	 * @return Major
	 */
	MajorVO get(String majorNum);

	/**
	 * 
	 * @Destribution: 查询学生列表
	 * @return
	 * @return Page<Student>
	 */
	PageList<MajorVO> listMajor(MajorQuery query);
}
