package com.yedam.app.department.service;

import java.util.List;

public interface DepartmentService {

	// 전체조회 (다건조회)
		public List<DepartmentVO> delpartmentAllSelect();
		
		// (단건조회)
		public DepartmentVO delpartmentSelect(DepartmentVO departVO);
}
