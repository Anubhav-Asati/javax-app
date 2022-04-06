package com.sapient.trg.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sapient.trg.service.Employee;
import com.sapient.trg.service.EmployeeManager;


@WebServlet("/es1")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			EmployeeManager manager = new EmployeeManager();
			int empno=Integer.parseInt(request.getParameter("empno"));
			Employee employee= manager.getEmployee(empno);
			//this.log(employee.getFormattedHiredate());
//			PrintWriter out = response.getWriter();
//			out.println("<table border=\"1\">"+"<tr><th>"+"Empno"+ "</th><td>"+employee.getEmpno()+"</td></tr>");
//			out.println("<tr><td>"+"<tr><th>"+"Ename"+ "</th><td>"+employee.getEname()+ "</td></tr>");
//			out.println("<tr><td>"+"<tr><th>"+"Hiredate"+ "</th><td>"+employee.getFormattedHiredate()+ "</td></tr>");
//			out.println("<tr><td>"+"<tr><th>"+"Job"+ "</th><td>"+employee.getJob()+ "</td></tr>");
//			out.println("<tr><td>"+"<tr><th>"+"Salary"+ "</th><td>"+employee.getSalary()+ "</td></tr>");
//			out.println("<tr><td>"+"<tr><th>"+"Commission"+ "</th><td>"+employee.getComm()+ "</td></tr>");
//			out.println("<tr><td>"+"<tr><th>"+"Deptno"+ "</th><td>"+employee.getDeptno()+ "</td></tr></table>");
		}
		catch(Exception exception){
			exception.printStackTrace();
			response.sendError(HttpServletResponse.SC_NOT_ACCEPTABLE, "Invalid Empno");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
