package com.taoxinhuan.main.dao;

import org.springframework.stereotype.Repository;

import com.taoxinhuan.main.PO.Control;

@Repository
public interface ControlMapper {
    /**
     * 
     * @Destribution:获取信息 是否可以选课,是否可以输入成绩
     * @param id
     * @return
     * @return Control
     */
    Control get(String id);
    /**
     * 
     * @Destribution:管理员更新信息
     * @param record
     * @return void
     */
	void update(Control record);
}