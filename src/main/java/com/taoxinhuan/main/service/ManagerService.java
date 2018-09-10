/**   
 * Copyright © 2018 北京易酒批电子商务有限公司. All rights reserved.
 */
package com.taoxinhuan.main.service;

import com.taoxinhuan.main.PO.Manager;
import com.taoxinhuan.main.VO.ManagerVO;

/**  
 * @Destribution: 
 * @author taoxinhuan
 * @date 2018年1月30日 下午2:25:40  
 */
public interface ManagerService {
	
	   
    /**
	 * 
	 * @Destribution:获取管理员
	 * @param managerNum
	 * @return
	 * @return Manager
	 */
	ManagerVO get(String managerNum);

	/**
	 * 
	 * @Destribution:获取管理员
	 * @param managerNum
	 * @return
	 * @return Manager
	 */
	ManagerVO managerLogin(String managerNum, String password);

  
    /**
     * 
     * @Destribution:管理员密码修改用
     * @param record
     * @return void
     */
    void update(Manager record);
}
