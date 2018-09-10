package com.taoxinhuan.main.conventer;

import com.taoxinhuan.main.PO.Dept;
import com.taoxinhuan.main.VO.DeptVO;

public class DeptConverter {
	public static DeptVO ToDeptVO(Dept po) {
		if (null != po) {
			DeptVO vo = new DeptVO();
			vo.setDeptChairman(po.getDeptChairman());
			vo.setDeptDesc(po.getDeptDesc());
			vo.setDeptName(po.getDeptName());
			vo.setDeptNum(po.getDeptNum());
			vo.setDeptTel(po.getDeptTel());
			return vo;
		}
		return null;
	}
}
