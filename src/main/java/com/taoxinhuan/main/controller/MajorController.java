package com.taoxinhuan.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.taoxinhuan.main.PO.Major;
import com.taoxinhuan.main.VO.MajorVO;
import com.taoxinhuan.main.query.MajorQuery;
import com.taoxinhuan.main.service.MajorService;
import com.taoxinhuan.main.util.PageList;

@RestController
public class MajorController {
	@Autowired
	private MajorService majorService;


	@RequestMapping(value = "major/add", method = RequestMethod.POST)
	public void addMajor(@RequestBody Major major) {
		majorService.add(major);
	}

	@RequestMapping(value = "major/list", method = RequestMethod.POST)
	public PageList<MajorVO> listMajor(@RequestBody MajorQuery query) {
		PageList<MajorVO> listMajor = majorService.listMajor(query);
		return listMajor;
	}

	@RequestMapping(value = "major/get/{majorNum}", method = RequestMethod.POST)
	public MajorVO getDept(@PathVariable("majorNum") String majorNum) {
		MajorVO majorVO = majorService.get(majorNum);
		return majorVO;
	}

	@RequestMapping(value = "major/update", method = RequestMethod.POST)
	public void updateDept(@RequestBody Major major) {
		majorService.update(major);
	}


}
