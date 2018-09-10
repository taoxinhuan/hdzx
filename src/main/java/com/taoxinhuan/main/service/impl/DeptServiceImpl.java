package com.taoxinhuan.main.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taoxinhuan.main.PO.Dept;
import com.taoxinhuan.main.VO.DeptVO;
import com.taoxinhuan.main.bl.DeptBL;
import com.taoxinhuan.main.query.DeptQuery;
import com.taoxinhuan.main.service.DeptService;
import com.taoxinhuan.main.util.PageList;

@Service
public class DeptServiceImpl implements DeptService {
	@Autowired
	private DeptBL deptBL;
	
	@Override
	public void add(Dept record) {
		deptBL.add(record);
	}
	
	@Override
	public void delete(String deptNum) {
		deptBL.delete(deptNum);
	}
	
	@Override
	public DeptVO get(String deptNum) {
		DeptVO deptVO = deptBL.get(deptNum);
		return deptVO;
	}
	
	@Override
	public void update(Dept record) {
		deptBL.update(record);
	}

	@Override
	public PageList<DeptVO> listDept(DeptQuery query) {
		PageList<DeptVO> listDept = deptBL.listDept(query);
		return listDept;
	}
}
