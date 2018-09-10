/**   
 * Copyright © 2018 北京易酒批电子商务有限公司. All rights reserved.
 */
package com.taoxinhuan.main.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taoxinhuan.main.PO.Manager;
import com.taoxinhuan.main.VO.ManagerVO;
import com.taoxinhuan.main.bl.ManagerBL;
import com.taoxinhuan.main.service.ManagerService;

/**  
 * @Destribution: 
 * @author taoxinhuan
 * @date 2018年1月30日 下午2:26:54  
 */
@Service
public class ManagerServiceImpl implements ManagerService{

	@Autowired
	private ManagerBL managerBL;

	@Override
	public ManagerVO get(String managerNum) {
		ManagerVO managerVO = managerBL.get(managerNum);
		return managerVO;
	}

	@Override
	public ManagerVO managerLogin(String managerNum, String password) {
		ManagerVO managerVO = managerBL.managerLogin(managerNum, password);
		return managerVO;
	}


	@Override
	public void update(Manager record) {
		managerBL.update(record);
	}

}
