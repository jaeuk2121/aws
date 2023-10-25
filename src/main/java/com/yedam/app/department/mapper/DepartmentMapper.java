package com.yedam.app.department.mapper;

import java.util.List;

import com.yedam.app.department.service.DepartmentVO;

public interface DepartmentMapper {
	// 전체조회 (다건조회)
		public List<DepartmentVO> delpartmentAllSelect();
		
		// 사원조회 (단건조회)
		public DepartmentVO delpartmentSelect(DepartmentVO departVO);
}
