package www.taoxinhuan.com.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.taoxinhuan.main.TaoApp;
import com.taoxinhuan.main.PO.Course;
import com.taoxinhuan.main.VO.CourseForStudentVO;
import com.taoxinhuan.main.VO.CourseVO;
import com.taoxinhuan.main.query.CourseForStudentQuery;
import com.taoxinhuan.main.query.CourseQuery;
import com.taoxinhuan.main.service.CourseService;
import com.taoxinhuan.main.util.PageList;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TaoApp.class)
@Transactional
public class CourseTest {

	@Autowired
	private CourseService courseService;
	
	@Test
	public void testAddCourse() {
		Course record = new Course();
		record.setCourseNum("333");
		record.setCourseClass(new Short("40"));
		record.setCourseCredit(2.5F);
		record.setCourseDesc("这堂课很好");
		record.setCourseName("计算机导论");
		record.setTeacherNum("777777777");
		courseService.add(record);
	}
	
	@Test
	public void testDeleteCourse() {
		courseService.delete("1515");
	}
	
	@Test
	public void testUpdateCourse() {
		Course record = new Course();
		record.setCourseNum("333");
		record.setCourseClass(new Short("28"));
		record.setCourseCredit(2.5F);
		record.setCourseDesc("这堂课很渣");
		record.setCourseName("计算机导论");
		record.setTeacherNum("777777777");
		courseService.update(record);
	}
	
	@Test
	public void testGetCourse() {
		CourseVO courseVO = courseService.get("333");
		System.out.println(courseVO);
		Assert.assertNotNull(courseVO);
	}

	@Test
	public void testListCourse() {
		CourseQuery query = new CourseQuery();
		query.setCourseCredit(3F);
		query.setPageIndex(1);
		query.setPageSize(20);
		PageList<CourseVO> listCourse = courseService.listCourse(query);
		List<CourseVO> dataList = listCourse.getDataList();
		dataList.forEach(data -> {
			System.out.println(data);
		});
	}

	@Test
	public void testListForStudent() {
		CourseForStudentQuery query = new CourseForStudentQuery();
		query.setCourseCredit(2F);
		query.setPageIndex(1);
		query.setPageSize(20);
		query.setCourseClass(78F);
		query.setDeptNum("10012");
		PageList<CourseForStudentVO> listCourseForStudent = courseService.listCourseForStudent(query);
		List<CourseForStudentVO> dataList = listCourseForStudent.getDataList();
		dataList.forEach(data -> {
			System.out.println(data);
		});
	}
}
