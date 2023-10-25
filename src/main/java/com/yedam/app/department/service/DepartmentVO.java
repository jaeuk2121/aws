package com.yedam.app.department.service;

import lombok.Data;

@Data
public class DepartmentVO {
	private int departmentId;
	private String departmentName;
	private int managerId;
	private int locationId;
}
