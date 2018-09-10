package com.taoxinhuan.main.conventer;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.taoxinhuan.main.PO.CourseForStudent;
import com.taoxinhuan.main.VO.CourseForStudentVO;

public class CourseForStudentConverter {

	public static CourseForStudentVO ToVO(CourseForStudent po) {
		if (null != po) {
			CourseForStudentVO vo = new CourseForStudentVO();
			vo.setCourseName(po.getCourseName());
			vo.setCourseNum(po.getCourseNum());
			vo.setDeptName(po.getDeptName());
			vo.setDeptNum(po.getDeptNum());
			vo.setTeacherName(po.getTeacherName());
			vo.setTeacherNum(po.getTeacherNum());
			vo.setCourseClass(po.getCourseClass());
			vo.setCourseCredit(po.getCourseCredit());
			vo.setCourseDesc(po.getCourseDesc());
			return vo;
		}
		return null;
	}

	public static List<CourseForStudentVO> ToVOList(List<CourseForStudent> poList){
		if(CollectionUtils.isNotEmpty(poList)) {
			List<CourseForStudentVO> voList=new ArrayList<>();
			poList.forEach(po->{
				CourseForStudentVO vo = ToVO(po);
				voList.add(vo);
			});
			return voList;
		}
		return null;
	}

}
