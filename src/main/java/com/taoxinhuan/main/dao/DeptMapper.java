package com.taoxinhuan.main.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.github.pagehelper.Page;
import com.taoxinhuan.main.PO.Dept;
import com.taoxinhuan.main.query.DeptQuery;

@Repository
public interface DeptMapper {
	/**
	 * 增加系部
	 * @param record
	 * @return void
	 */
	void add(Dept record);
	
	/**
	 * 删除系部
	 * @param deptNum
	 * @return void
	 */
	void delete(String deptNum);
	
	/**
	 * 更改系部信息
	 * @param record
	 * @return void
	 */
	void update(Dept record);
	
	/**
	 * 查询单个系部
	 * @param deptNum
	 * @return
	 * @return Dept
	 */
	Dept get(String deptNum);
	
	/**
	 * 
	 * @Destribution: 查询系部列表
	 * @return
	 * @return Page<Dept>
	 */
	Page<Dept> listDept(@Param("query") DeptQuery query);

}