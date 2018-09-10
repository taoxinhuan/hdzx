package www.taoxinhuan.com.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.taoxinhuan.main.TaoApp;
import com.taoxinhuan.main.PO.Dept;
import com.taoxinhuan.main.VO.DeptVO;
import com.taoxinhuan.main.query.DeptQuery;
import com.taoxinhuan.main.service.DeptService;
import com.taoxinhuan.main.util.PageList;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TaoApp.class)
public class DeptTest {
	@Autowired
	private DeptService deptService;
	
	@Test
	public void testGetDept() {
		DeptVO vo = deptService.get("10010");
		System.out.println("=========================" + vo);
		Assert.assertNotNull(vo);
	}
	
	@Test
	public void testAddDept() {
		Dept record=new Dept();
		record.setDeptNum("10010");
		record.setDeptName("计算机");
		record.setDeptChairman("112");
		record.setDeptTel("5112121");
		record.setDeptDesc("你好时节");
		deptService.add(record);
	}
	
	@Test
	public void testDeleteDept() {
		deptService.delete("118");
	}
	
	@Test
	public void testUpdateDept() {
		Dept record = new Dept();
		record.setDeptNum("110");
		record.setDeptName("计算机");
		record.setDeptDesc("你好时节");
		deptService.update(record);
	}

	@Test
	public void testListDept() {
		DeptQuery query = new DeptQuery();
		query.setPageIndex(1);
		query.setPageSize(10);
		PageList<DeptVO> listDept = deptService.listDept(query);
		List<DeptVO> dataList = listDept.getDataList();
		dataList.forEach(data -> {
			System.out.println(data);
		});
	}
}
