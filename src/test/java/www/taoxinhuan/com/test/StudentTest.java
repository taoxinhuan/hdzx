package www.taoxinhuan.com.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.taoxinhuan.main.TaoApp;
import com.taoxinhuan.main.PO.Student;
import com.taoxinhuan.main.VO.StudentVO;
import com.taoxinhuan.main.query.StudentQuery;
import com.taoxinhuan.main.service.StudentService;
import com.taoxinhuan.main.util.PageList;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TaoApp.class)
@Transactional
public class StudentTest {
	@Autowired
	private StudentService studentService;
	
	@Test
	public void testAddStudent() throws ParseException {
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		Student record = new Student();
		record.setMajorNum("111");
		Date date = f.parse("1996-07-09");
		record.setStudentBirthday(date);
		record.setStudentName("一叶知秋");
		record.setStudentNum("1431390019");
		record.setStudentPassword("19960709");
		record.setStudentSex("男");
		studentService.add(record);
	}
	
	@Test
	public void testDeleteStudent() {
		studentService.delete("1431390018");
	}
	
	@Test
	public void testUpdateStudent() throws ParseException {
		Student record = new Student();
		record.setMajorNum("113");
		record.setStudentName("嘻嘻嘻");
		record.setStudentSex("男");
		studentService.update(record);
	}
	
	@Test
	public void testSelectStudent() {
		StudentVO studentVO = studentService.get("1431390015");
		System.out.println(studentVO);
		Assert.assertNotNull(studentVO);
	}
	@Test
	public void testListStudent() {
		StudentQuery query = new StudentQuery();
		query.setPageIndex(1);
		query.setPageSize(20);
		PageList<StudentVO> listStudent = studentService.listStudent(query);
		List<StudentVO> dataList = listStudent.getDataList();
		dataList.forEach(data -> {
			System.out.println("============" + data);
		});
	}
}
