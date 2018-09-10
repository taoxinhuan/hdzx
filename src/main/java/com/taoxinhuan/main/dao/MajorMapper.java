package com.taoxinhuan.main.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.github.pagehelper.Page;
import com.taoxinhuan.main.PO.Major;
import com.taoxinhuan.main.query.MajorQuery;

@Repository
public interface MajorMapper {
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
	Major get(String majorNum);

	/**
	 * 
	 * @Destribution: 查询专业列表
	 * @return
	 * @return Page<Major>
	 */
	Page<Major> listMajor(@Param("query") MajorQuery query);

}