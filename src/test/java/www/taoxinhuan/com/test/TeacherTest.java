package www.taoxinhuan.com.test;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.taoxinhuan.main.TaoApp;
import com.taoxinhuan.main.PO.Teacher;
import com.taoxinhuan.main.VO.TeacherVO;
import com.taoxinhuan.main.query.TeacherQuery;
import com.taoxinhuan.main.service.TeacherService;
import com.taoxinhuan.main.util.PageList;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TaoApp.class)
public class TeacherTest {
	@Autowired
	private TeacherService TeacherService;
	
	@Test
	public void testAddTeacher() {
		Teacher t = new Teacher();
		t.setTeacherNum("777777777");
		t.setTeacherPassword("19960709");
		t.setTeacherBirthday(new Date());
		t.setTeacherName("你");
		t.setTeacherSex("女");
		t.setTeacherTitle("教授");
		t.setDeptNum("10010");
		TeacherService.add(t);
	}
	
	@Test
	public void testUpdateTeacher() {
		Teacher t = new Teacher();
		t.setTeacherNum("2215421245");
		t.setTeacherPassword("19960703");
		t.setTeacherBirthday(new Date());
		t.setTeacherName("你");
		t.setTeacherSex("女");
		t.setTeacherTitle("教授");
		t.setDeptNum("10010");
		TeacherService.update(t);
	}
	
	@Test
	public void testDeleteTeacher() {
		TeacherService.delete("2215421245");
	}
	
	@Test
	public void testGetTeacher() {
		TeacherVO teacherVO = TeacherService.get("777777777");
		System.out.println(teacherVO);
		Assert.assertNotNull(teacherVO);
	}

	@Test
	public void testListTeacher() {
		TeacherQuery query = new TeacherQuery();
		query.setPageSize(10);
		query.setPageIndex(1);
		PageList<TeacherVO> listTeacher = TeacherService.listTeacher(query);
		List<TeacherVO> dataList = listTeacher.getDataList();
		dataList.forEach(data -> {
			System.out.println("============" + data);
		});
	}
}
