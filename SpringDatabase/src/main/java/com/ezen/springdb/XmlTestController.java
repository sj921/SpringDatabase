package com.ezen.springdb;

import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ezen.springdb.dto.Employee;
import com.ezen.springdb.mapper.EmployeeXmlMapper;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RequestMapping("/xml")
@Controller
public class XmlTestController {
	
	@Autowired
	EmployeeXmlMapper emp_mapper;
	
	@GetMapping("/employee/list")
	public String employeeList(Model model) {
		model.addAttribute("employees", emp_mapper.getAll());
		
		return "xml/emp_list";
	}
	
	
	@GetMapping("/employee/get")
	public String getEmployee(Model model, Integer employee_id) {
		
		if (employee_id != null) {			
			model.addAttribute("employee", emp_mapper.get(employee_id));
		}
		
		return "xml/emp";		
	}
	
	@GetMapping("/employee/where")
	public String getWhere(Model model) {
		model.addAttribute("employees", emp_mapper.getLessSalary(8000));
		
		return "xml/emp_list";
	}
	
	

	@GetMapping("/employee/insert")
	public String insert(Model model) {
		// Controller 한번에 여러개의 BusinessLogic을 일으킬 수 있다
		// BusinessLogic 하나에 DAO가 여러 개일 수도 있고, selct, insert, delete 등 여러 개일 수도 있다
		// 계층 구조를 나눠야 할 필요성이 있다
			
		// form 만들면 자동으로 들어오는 내용들이므로 평소에는 신경쓰지 않아도 된다
		// job_id는 실제 있는 것으로 적어야 함
			
		// 이메일 겹치는 것 막기 위한 임시조치
		
		// 보통은 null 값을 허용하는 경우가 잘 없음...????
		Integer last_id = emp_mapper.getLastId();
		
		Employee e = new Employee("Test", "Email" + last_id, new Date(), "IT_PROG");
		
		log.info("before insert(employee_id가 비어있음): " + e);
		
		Integer row = emp_mapper.insert(e);
		
		log.info(row + "행이 업데이트가 되었습니다...");
		
		log.info("after insert(employee_id가 채워져있음, <selectkey>의 기능): " + e);
		
		// 받아온 id로 다시 한번 select해서 모델에 실어놓음
		model.addAttribute("employee", emp_mapper.get(e.getEmployee_id()));		
		
		return "xml/emp";
		
	}
		
}
