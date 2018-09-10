/**   
 * Copyright © 2018 北京易酒批电子商务有限公司. All rights reserved.
 */
package com.taoxinhuan.main.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taoxinhuan.main.PO.Control;
import com.taoxinhuan.main.VO.ControlVO;
import com.taoxinhuan.main.bl.ControlBL;
import com.taoxinhuan.main.service.ControlService;

/**
 * @Destribution:
 * @author taoxinhuan
 * @date 2018年1月30日 下午2:56:13
 */
@Service
public class ControlServiceImpl implements ControlService {
	@Autowired
	private ControlBL controlBL;
	
	@Override
	public ControlVO get(String id) {
		ControlVO controlVO = controlBL.get(id);
		return controlVO;
	}
	
	@Override
	public void update(Control record) {
		controlBL.update(record);
	}
}
