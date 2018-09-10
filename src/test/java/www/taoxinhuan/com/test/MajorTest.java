package www.taoxinhuan.com.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.taoxinhuan.main.TaoApp;
import com.taoxinhuan.main.PO.Major;
import com.taoxinhuan.main.VO.MajorVO;
import com.taoxinhuan.main.query.MajorQuery;
import com.taoxinhuan.main.service.MajorService;
import com.taoxinhuan.main.util.PageList;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TaoApp.class)
public class MajorTest {
	@Autowired
	private MajorService majorService;
	
	@Test
	public void testAddMajor() {
		Major record = new Major();
		record.setDeptNum("10010");
		record.setMajorAssistant("好好先生");
		record.setMajorName("软件工程");
		record.setMajorNum("111");
		record.setMajorTel("13030303300");
		majorService.add(record);
	}
	
	@Test
	public void testDeleteMajor() {
		majorService.delete("111");
	}
	
	@Test
	public void testUpdateMajor() {
		Major record = new Major();
		record.setDeptNum("110");
		record.setMajorAssistant("好好先生");
		record.setMajorNum("113");
		record.setMajorTel("13030303301");
		majorService.update(record);
	}
	
	@Test
	public void testGetMajor() {
		MajorVO majorVO = majorService.get("114");
		System.out.println(majorVO);
		Assert.assertNotNull(majorVO);
	}

	@Test
	public void testListMajor() {
		MajorQuery query = new MajorQuery();
		query.setPageIndex(1);
		query.setPageSize(10);
		PageList<MajorVO> listMajor = majorService.listMajor(query);
		List<MajorVO> dataList = listMajor.getDataList();
		dataList.forEach(data -> {
			System.out.println(data);
		});
	}
}
