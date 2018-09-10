package com.taoxinhuan.main.bl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.taoxinhuan.main.PO.Dept;
import com.taoxinhuan.main.PO.Major;
import com.taoxinhuan.main.VO.MajorVO;
import com.taoxinhuan.main.dao.DeptMapper;
import com.taoxinhuan.main.dao.MajorMapper;
import com.taoxinhuan.main.query.MajorQuery;
import com.taoxinhuan.main.util.PageList;
import com.taoxinhuan.main.util.Pager;

@Service
public class MajorBL {
	@Autowired
	private MajorMapper majorMapper;
	
	@Autowired
	private DeptMapper deptMapper;
	
	public void add(Major record) {
		majorMapper.add(record);
	}
	
	public void delete(String majorNum) {
		majorMapper.delete(majorNum);
	}
	
	public void update(Major record) {
		majorMapper.update(record);
	}
	
	public MajorVO get(String majorNum) {
		Major major = majorMapper.get(majorNum);
		MajorVO vo = toVO(major);
		return vo;
	}

	private MajorVO toVO(Major major) {
		MajorVO vo = null;
		if (null != major) {
			String deptNum = major.getDeptNum();
			Dept dept = deptMapper.get(deptNum);
			vo = new MajorVO();
			if (null != dept) {
			vo.setDeptName(dept.getDeptName());
			}
			vo.setDeptNum(major.getDeptNum());
			vo.setMajorAssistant(major.getMajorAssistant());
			vo.setMajorName(major.getMajorName());
			vo.setMajorNum(major.getMajorNum());
			vo.setMajorTel(major.getMajorTel());
			vo.setDeptName(dept.getDeptName());
			return vo;
		}
		return vo;
	}

	public PageList<MajorVO> listDept(MajorQuery query) {
		Integer currentPage = query.getPageIndex();
		Integer pageSize = query.getPageSize();
		PageHelper.startPage(currentPage, pageSize);
		Page<Major> listMajor = majorMapper.listMajor(query);
		PageList<MajorVO> pageList = new PageList<>();
		Long total = listMajor.getTotal();
		List<MajorVO> voList = new ArrayList<>();
		if (total.intValue() > 0) {
			listMajor.forEach(major -> {
				MajorVO majorVO = toVO(major);
				voList.add(majorVO);
			});
		}
		Pager pager = new Pager(currentPage, pageSize, total.intValue());
		pageList.setDataList(voList);
		pageList.setPager(pager);
		return pageList;
	}
}
