package com.sapient.trg.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.sapient.trg.service.Employee;
import com.sapient.trg.service.EmployeeManager;

@WebServlet("/ge")
public class GetEmployees extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		EmployeeManager manager=new EmployeeManager();
		Integer deptno= Integer.parseInt(request.getParameter("deptno"));
		System.out.println(deptno);
		List<Employee> employeeList= manager.getEmployeesByDeptno(deptno);
		employeeList.stream().forEach(System.out::println);
//		request.setAttribute("employeeList", employeeList);
//		request.getRequestDispatcher("jsp/get-employees.jsp")
//								.forward(request, response);
		
		if(employeeList.size() != 0){			
			String employees= new Gson().toJson(employeeList);
			System.out.println(employees);
			out.println("{\"EmployeeList\":"+employees+"}");		
			
		}else{
			out.println("<html><body<h1>"+"No Records Found"+"</h1></body></html>");
		}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
