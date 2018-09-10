package www.taoxinhuan.com.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.taoxinhuan.main.TaoApp;
import com.taoxinhuan.main.PO.Grade;
import com.taoxinhuan.main.VO.GradeVO;
import com.taoxinhuan.main.query.GradeQuery;
import com.taoxinhuan.main.service.GradeService;
import com.taoxinhuan.main.util.PageList;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TaoApp.class)
public class GradeTest {
	@Autowired
	private GradeService gradeService;
	
	@Test
	public void testAdd() {
		Grade record=new Grade(); 
		record.setCourseNum("333");
		record.setStudentNum("666");
		record.setTeacherNum("777777777");
		record.setGrade(100);
		gradeService.add(record);
		
	}
	@Test
	public void testDelete() {
		gradeService.deleteByStuNumAndCourseNum("666","333");
		
	}
	@Test
	public void testUpdate() {
		Grade record=new Grade(); 
		record.setCourseNum("333");
		record.setStudentNum("666");
		record.setGrade(99);
		gradeService.update(record);
		
	}
	@Test
	public void testGetStuGrades() {
		List<GradeVO> stuGrades = gradeService.getStuGrades("1431390014");
		System.out.println("============");
		stuGrades.forEach(data -> {
			System.out.println(data);

		});
	}
	
	@Test
	public void testListForTeacher() {
		GradeQuery query = new GradeQuery();
		query.setTeacherNum("669988");
		query.setPageIndex(1);
		query.setPageSize(20);
		PageList<GradeVO> listForTeacher = gradeService.listForTeacher(query);
		System.out.println("============");
		listForTeacher.getDataList().forEach(data -> {
			System.out.println(data);

		});
	}

}
