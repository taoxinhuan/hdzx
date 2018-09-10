package com.taoxinhuan.main.service;

import com.taoxinhuan.main.PO.Dept;
import com.taoxinhuan.main.VO.DeptVO;
import com.taoxinhuan.main.query.DeptQuery;
import com.taoxinhuan.main.util.PageList;

public interface DeptService {
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
	 * 查询单个系部
	 * @param deptNum
	 * @return
	 * @return Dept
	 */
	DeptVO get(String deptNum);
	
	/**
	 * 更改系部信息
	 * @param record
	 * @return void
	 */
	void update(Dept record);

	/**
	 * 
	 * @Destribution: 查询系部列表
	 * @return
	 * @return Page<Student>
	 */
	PageList<DeptVO> listDept(DeptQuery query);
}
