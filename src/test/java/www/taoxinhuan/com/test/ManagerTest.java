/**   
 * Copyright © 2018 北京易酒批电子商务有限公司. All rights reserved.
 */
package www.taoxinhuan.com.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.taoxinhuan.main.TaoApp;
import com.taoxinhuan.main.PO.Manager;
import com.taoxinhuan.main.VO.ManagerVO;
import com.taoxinhuan.main.service.ManagerService;

/**
 * @Destribution: 管理员单元测试
 * @author taoxinhuan
 * @date 2018年1月30日 下午2:41:07
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TaoApp.class)
public class ManagerTest {
	@Autowired
	private ManagerService managerService;
	
	@Test
	public void testGet() {
		ManagerVO managerVO = managerService.get("admin");
        System.out.println(managerVO);
	}
	
	@Test
	public void testUpdate() {
		Manager record=new Manager();
		record.setManagerNum("admin");
		record.setManagerName("幻心桃");
		managerService.update(record);
	}
}
