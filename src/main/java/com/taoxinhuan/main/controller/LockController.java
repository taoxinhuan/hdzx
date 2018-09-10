package com.taoxinhuan.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.taoxinhuan.main.PO.Control;
import com.taoxinhuan.main.VO.ControlVO;
import com.taoxinhuan.main.service.ControlService;

@RestController
public class LockController {

	@Autowired
	private ControlService controlService;

	@RequestMapping(value = "/getLockInfo", method = RequestMethod.GET)
	public ControlVO getControl() {
		ControlVO controlVO = controlService.get("1");
		return controlVO;
	}

	@RequestMapping(value = "/updateLockInfo", method = RequestMethod.POST)
	public void updateLockInfo(@RequestBody Control control) {
		controlService.update(control);
	}

}
