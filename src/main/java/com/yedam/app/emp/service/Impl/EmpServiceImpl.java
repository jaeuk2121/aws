package com.yedam.app.emp.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

@Service
public class EmpServiceImpl implements EmpService{
	
	@Autowired
	EmpMapper empMapper;	//매퍼불러옴	(이름지정시 명확하게 어떤 테이블에 접근하는지 알 수 있게)

	@Override
	public List<EmpVO> getEmpAll() {
		return empMapper.selectAllEmpInfo();
	}

	@Override
	public EmpVO getEmpInfo(EmpVO empVO) {
		return empMapper.selectEmpInfo(empVO);
	}

	@Override
	public int insertEmpInfo(EmpVO empVO) {
		int result = empMapper.insertEmpInfo(empVO);
		
		if(result == 1) {
			return empVO.getEmployeeId();
		}else {
			return -1;
		}
	}

	@Override
	public Map<String, Object> updateEmpInfo(EmpVO empVO) {
		Map<String, Object> map = new HashMap<>();	//map알아보기
		boolean inSuccessed = false;
		
		int result = empMapper.updateEmpInfo(empVO);
		if(result == 1) {
			inSuccessed = true;
		}
		map.put("result", inSuccessed);
		map.put("target", empVO);
		
		
		return map;
	}

	@Override
	public boolean deleteEmpInfo(int empId) {
		int result = empMapper.deleteEmpInfo(empId);
		
		if(result == 1) {
			return true;
		}else {
			return false;
		}
	}

}
