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
import com.taoxinhuan.main.PO.Control;
import com.taoxinhuan.main.VO.ControlVO;
import com.taoxinhuan.main.service.ControlService;

/**  
 * @Destribution: 开关测试
 * @author taoxinhuan
 * @date 2018年1月30日 下午3:18:34  
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TaoApp.class)
public class controlTest {
	
	@Autowired
	private ControlService controlService;
	
	@Test
	public void testGet() {
		ControlVO controlVO = controlService.get("1");
		System.out.println(controlVO);
	}
	@Test
	public void testUpdate() {
		Control c=new Control();
		c.setId("1");
		c.setInputGrade(true);
		controlService.update(c);
		
	}
}
