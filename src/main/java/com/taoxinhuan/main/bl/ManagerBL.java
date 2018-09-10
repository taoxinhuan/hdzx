/**   
 * Copyright © 2018 北京易酒批电子商务有限公司. All rights reserved.
 */
package com.taoxinhuan.main.bl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taoxinhuan.main.PO.Manager;
import com.taoxinhuan.main.VO.ManagerVO;
import com.taoxinhuan.main.dao.ManagerMapper;

/**
 * @Destribution: 管理员业务逻辑层
 * @author taoxinhuan
 * @date 2018年1月30日 下午2:27:29
 */
@Service
public class ManagerBL {

	@Autowired
	private ManagerMapper managerMapper;

	public ManagerVO get(String managerNum) {
		Manager manager = managerMapper.get(managerNum);
		ManagerVO vo = toVO(manager);
		return vo;
	}

	public ManagerVO managerLogin(String managerNum, String password) {
		Manager manager = managerMapper.managerLogin(managerNum, password);
		ManagerVO vo = toVO(manager);
		return vo;
	}

	public void update(Manager record) {
		managerMapper.update(record);
	}

	/**
	 * @param manager
	 * @return
	 * @return ManagerVO
	 */
	private ManagerVO toVO(Manager manager) {
		ManagerVO vo = null;
		if (null != manager) {
			vo = new ManagerVO();
			vo.setManagerName(manager.getManagerName());
			vo.setManagerNum(manager.getManagerNum());
			vo.setManagerPassword(manager.getManagerPassword());
		}
		return vo;
	}
}
