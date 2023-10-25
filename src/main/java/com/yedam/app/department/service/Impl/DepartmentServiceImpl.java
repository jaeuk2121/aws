package com.yedam.app.department.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.yedam.app.department.mapper.DepartmentMapper;
import com.yedam.app.department.service.DepartmentService;
import com.yedam.app.department.service.DepartmentVO;

public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	DepartmentMapper departmentMapper;

	@Override
	public List<DepartmentVO> delpartmentAllSelect() {
		return departmentMapper.delpartmentAllSelect();
	}

	@Override
	public DepartmentVO delpartmentSelect(DepartmentVO departVO) {
		return departmentMapper.delpartmentSelect(departVO);
	}

}
