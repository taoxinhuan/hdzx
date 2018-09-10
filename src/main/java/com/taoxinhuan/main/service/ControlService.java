/**   
 * Copyright © 2018 北京易酒批电子商务有限公司. All rights reserved.
 */
package com.taoxinhuan.main.service;

import com.taoxinhuan.main.PO.Control;
import com.taoxinhuan.main.VO.ControlVO;

/**  
 * @Destribution: 
 * @author taoxinhuan
 * @date 2018年1月30日 下午2:54:03  
 */
public interface ControlService {
    /**
     * 
     * @Destribution:获取信息 是否可以选课,是否可以输入成绩
     * @param id
     * @return
     * @return Control
     */
    ControlVO get(String id);
    /**
     * 
     * @Destribution:管理员更新信息
     * @param record
     * @return void
     */
	void update(Control record);
}
