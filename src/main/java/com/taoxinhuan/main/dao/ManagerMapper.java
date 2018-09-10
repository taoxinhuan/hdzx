package com.taoxinhuan.main.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.taoxinhuan.main.PO.Manager;

@Repository
public interface ManagerMapper {

	/**
	 * 
	 * @Destribution:获取管理员信息
	 * @param managerNum
	 * @return
	 * @return Manager
	 */
	Manager get(String managerNum);

	/**
	 * 
	 * @Destribution:管理员登陆用
	 * @param managerNum
	 * @return
	 * @return Manager
	 */
	Manager managerLogin(@Param("managerNum") String managerNum, @Param("password") String password);

	/**
	 * 
	 * @Destribution:管理员密码修改用
	 * @param record
	 * @return void
	 */
	void update(Manager record);
}