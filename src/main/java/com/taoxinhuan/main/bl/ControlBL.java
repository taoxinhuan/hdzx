/**   
 * Copyright © 2018 北京易酒批电子商务有限公司. All rights reserved.
 */
package com.taoxinhuan.main.bl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taoxinhuan.main.PO.Control;
import com.taoxinhuan.main.VO.ControlVO;
import com.taoxinhuan.main.dao.ControlMapper;

/**  
 * @Destribution: 
 * @author taoxinhuan
 * @date 2018年1月30日 下午2:57:06  
 */
@Service
public class ControlBL {
	
	@Autowired
	private ControlMapper controlMapper;

	public ControlVO get(String id) {
		Control control = controlMapper.get(id);
		ControlVO vo=new ControlVO();
		vo.setId(control.getId());
		vo.setInputGrade(control.getInputGrade());
		vo.setSelectCourse(control.getSelectCourse());
		return vo;
	}


	public void update(Control record) {
		controlMapper.update(record);
		
	}
}
