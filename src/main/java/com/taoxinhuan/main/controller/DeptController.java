package com.taoxinhuan.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.taoxinhuan.main.PO.Dept;
import com.taoxinhuan.main.VO.DeptVO;
import com.taoxinhuan.main.query.DeptQuery;
import com.taoxinhuan.main.service.DeptService;
import com.taoxinhuan.main.util.PageList;

@RestController
public class DeptController {

	@Autowired
	private DeptService deptService;

	@RequestMapping(value = "dept/add", method = RequestMethod.POST)
	public void addDept(@RequestBody Dept dept) {
		deptService.add(dept);
	}

	@RequestMapping(value = "dept/list", method = RequestMethod.POST)
	public PageList<DeptVO> listDept(@RequestBody DeptQuery query) {
		PageList<DeptVO> listDept = deptService.listDept(query);
		return listDept;
	}

	@RequestMapping(value = "dept/get/{deptNum}", method = RequestMethod.POST)
	public DeptVO getDept(@PathVariable("deptNum") String deptNum) {
		DeptVO deptVO = deptService.get(deptNum);
		return deptVO;
	}

	@RequestMapping(value = "dept/update", method = RequestMethod.POST)
	public void updateDept(@RequestBody Dept dept) {
		deptService.update(dept);
	}


}
