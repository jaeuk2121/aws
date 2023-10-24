package com.yedam.app.emp.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

@Controller
public class EmpController {

	@Autowired
	EmpService empService;
	// get :조회,페이지호출
	// post :데이터 조작관련 기능(등록,수정,삭제)

	// 전체조회
	@GetMapping("empList")
	public String getEmpList(Model model) {
		List<EmpVO> list = empService.getEmpAll();
		model.addAttribute("empList", list);
		return "emp/empList";
	}

	// 사원조회
	@GetMapping("empInfo")
	public String getEmpInfo(EmpVO empVO, Model model) { // 커맨드객체사용
		EmpVO findVO = empService.getEmpInfo(empVO);
		model.addAttribute("empInfo", findVO);
		return "emp/empInfo";
	}

	// 등록 -form
	@GetMapping("empInsert")
	public String insertEmpInfoForm() {
		return "emp/empInsert";
	}

	// 등록 -process/처리
	@PostMapping("empInsert")
	public String insertEmpInfoProcess(EmpVO empVO) { // 커맨드객체사용 //동기 커맨드객체 //비동기 제이슨
		int empId = empService.insertEmpInfo(empVO);

		String path = null;
		if (empId > -1) {
			path = "redirect:empInfo?employeeId=" + empId;
		} else {
			path = "redirect:empList";
		}
		return path;
	}

	// 수정 - process //Ajax이용시(ResponseBody)
	// 데이터 받을 시=>
	// 1) +QueryString => 커맨드객체
	@PostMapping("empUpdate")
	@ResponseBody // <=바디부분에 json 형태로 뿌려달라
	public Map<String, Object> empUpdateProcess(EmpVO empVO) {
		return empService.updateEmpInfo(empVO);
	}

	// 2) Json => RequestBody
	@PostMapping("empUpdateAjax")
	@ResponseBody
	public Map<String, Object> empUpdateAjaxProcess(@RequestBody EmpVO empVO) {
		return empService.updateEmpInfo(empVO);
	}

	// 삭제
	@GetMapping("empDelete")
	public String empDeleteProcess(@RequestParam Integer employeeId,
									RedirectAttributes ratt) {
		boolean result = empService.deleteEmpInfo(employeeId);
		String msg = null;
		if(result) {
			msg = "정상적으로 삭제되었습니다.\n삭제대상 : " + employeeId;
		}else {
			msg="정상적으로 삭제되지않았습니다.\n정보를 확인해주시기바랍니다.\n삭제요청 : " + employeeId;	
		}
		ratt.addFlashAttribute("result", msg);
		return "redirect:empList";
	}
}
