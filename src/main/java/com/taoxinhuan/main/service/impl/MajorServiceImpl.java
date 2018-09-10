package com.taoxinhuan.main.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taoxinhuan.main.PO.Major;
import com.taoxinhuan.main.VO.MajorVO;
import com.taoxinhuan.main.bl.MajorBL;
import com.taoxinhuan.main.query.MajorQuery;
import com.taoxinhuan.main.service.MajorService;
import com.taoxinhuan.main.util.PageList;

@Service
public class MajorServiceImpl implements MajorService {
	@Autowired
	private MajorBL majorBL;
	
	@Override
	public void add(Major record) {
		majorBL.add(record);
	}
	
	@Override
	public void delete(String majorNum) {
		majorBL.delete(majorNum);
	}
	
	@Override
	public void update(Major record) {
		majorBL.update(record);
	}
	
	@Override
	public MajorVO get(String majorNum) {
		MajorVO vo = majorBL.get(majorNum);
		return vo;
	}

	@Override
	public PageList<MajorVO> listMajor(MajorQuery query) {
		PageList<MajorVO> listDept = majorBL.listDept(query);
		return listDept;
	}
}
