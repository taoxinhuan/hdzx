package com.taoxinhuan.main.bl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.taoxinhuan.main.PO.Dept;
import com.taoxinhuan.main.VO.DeptVO;
import com.taoxinhuan.main.conventer.DeptConverter;
import com.taoxinhuan.main.dao.DeptMapper;
import com.taoxinhuan.main.query.DeptQuery;
import com.taoxinhuan.main.util.PageList;
import com.taoxinhuan.main.util.Pager;

@Service
public class DeptBL {
	@Autowired
	private DeptMapper deptMapper;

	public void add(Dept record) {
		deptMapper.add(record);
	}

	public void delete(String deptNum) {
		deptMapper.delete(deptNum);
	}

	public DeptVO get(String deptNum) {
		Dept dept = deptMapper.get(deptNum);
		DeptVO deptVO = DeptConverter.ToDeptVO(dept);
		return deptVO;
	}

	public void update(Dept record) {
		deptMapper.update(record);
	}

	public PageList<DeptVO> listDept(DeptQuery query) {
		Integer currentPage = query.getPageIndex();
		Integer pageSize = query.getPageSize();
		PageHelper.startPage(currentPage, pageSize);
		Page<Dept> listDept = deptMapper.listDept(query);
		PageList<DeptVO> pageList = new PageList<>();
		Long total = listDept.getTotal();
		List<DeptVO> voList = new ArrayList<>();
		if (total.intValue() > 0) {
			listDept.forEach(dept -> {
				DeptVO toDeptVO = DeptConverter.ToDeptVO(dept);
				voList.add(toDeptVO);
			});
		}
		Pager pager = new Pager(currentPage, pageSize, total.intValue());
		pageList.setDataList(voList);
		pageList.setPager(pager);
		return pageList;
	}

}
