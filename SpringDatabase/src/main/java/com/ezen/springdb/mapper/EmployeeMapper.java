package com.ezen.springdb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.ezen.springdb.dto.Employee;

public interface EmployeeMapper {

	@Select("SELECT * FROM employees")
	public List<Employee> getList();
	// mybatis에 List를 실어가라고 요청?
	
}
