package com.sapient.trg.service;

import java.util.List;

import com.sapient.trg.dao.EmployeeDaoImpl;

public class EmployeeManager {
	public Employee getEmployee(Integer empno){
		return new EmployeeDaoImpl().getEmployee(empno);
	}
	
	public String newEmployee(Employee employee){
		
		return new EmployeeDaoImpl().newEmployee(employee);
	}
	
	public List<Employee> getAllEmployees(){
		
		return new EmployeeDaoImpl().getAllEmployees();
	}
	
	public List<Employee> getEmployeesByDeptno(Integer deptno){
		return new EmployeeDaoImpl().getEmployeesByDeptno(deptno);
	}
	
	
	public String deleteEmployee(Integer empno){
		return new EmployeeDaoImpl().deleteEmployee(empno);
	
	}
	
}
