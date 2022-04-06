package com.sapient.trg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.sapient.trg.service.Employee;
import com.sapient.trg.utility.MySQLConnection;


public class EmployeeDaoImpl {
	public Employee getEmployee(Integer empno){
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		String sql="select * from employee where empno=?";
		try{
			connection=MySQLConnection.getConnection();
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, empno);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				Employee employee= new Employee();
				employee.setEmpno(resultSet.getInt("empno"));
				employee.setEname(resultSet.getString("ename"));
				employee.setJob(resultSet.getString("job"));
				java.sql.Date sdate= resultSet.getDate("hiredate");
				java.util.Date udate=new java.util.Date(sdate.getTime());
				java.util.Calendar cdate= Calendar.getInstance();
				cdate.setTime(udate);
				employee.setHiredate(cdate);
				employee.setSalary(resultSet.getDouble("salary"));
				employee.setComm(resultSet.getDouble("comm"));
				employee.setDeptno(resultSet.getInt("deptno"));
				return employee;
				
			}else{
				return null;
			}
		}
		catch(Exception exception){
			exception.printStackTrace();
			return null;
		}
		
	}
	
	public String newEmployee(Employee employee){
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		String sql="insert into employee values(?,?,?,?,?,?,?)";
		try{
			connection=MySQLConnection.getConnection();
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, employee.getEmpno());
			preparedStatement.setString(2, employee.getEname());
			preparedStatement.setString(3, employee.getJob());
			//java.util.Calendar to java.util.Date to java.sql.Date
			Calendar hdate=employee.getHiredate();
			java.util.Date udate = new java.util.Date(hdate.getTimeInMillis());
			java.sql.Date sdate=new java.sql.Date(udate.getTime());
			preparedStatement.setDate(4, sdate);
			preparedStatement.setDouble(5, employee.getSalary());
			preparedStatement.setDouble(6, employee.getComm());
			preparedStatement.setInt(7, employee.getDeptno());
			int n=preparedStatement.executeUpdate();
			
			if(n>0){
				return "success";
			}else{
				return "error";
			}
			
		}
		catch(Exception exception){
			exception.printStackTrace();
			return "error";
		}	
	
	}
	
	public List<Employee> getAllEmployees(){
		//returns all the employee details as List of Employee objects
		Connection connection=null;
		Statement statement=null;
		ResultSet resultSet=null;
		
		try{
			List<Employee> employeeList=new ArrayList<>();
			connection=MySQLConnection.getConnection();
			statement=connection.createStatement();
			resultSet=statement.executeQuery("select * from employee");
			while(resultSet.next()){
				Employee employee= new Employee();
				employee.setEmpno(resultSet.getInt("empno"));
				employee.setEname(resultSet.getString("ename"));
				employee.setJob(resultSet.getString("job"));
				try{
					java.sql.Date sdate= resultSet.getDate("hiredate");
					java.util.Date udate=new java.util.Date(sdate.getTime());
					java.util.Calendar cdate= Calendar.getInstance();
					cdate.setTime(udate);
					employee.setHiredate(cdate);
				}
				catch(NullPointerException exception){
					employee.setHiredate(null);
				}
				employee.setSalary(resultSet.getDouble("salary"));
				employee.setComm(resultSet.getDouble("comm"));
				employee.setDeptno(resultSet.getInt("deptno"));
				employeeList.add(employee);
			}
			
			return employeeList;
		}
		catch(Exception exception){
			exception.printStackTrace();
			return null;
		}
	}
	
	
	
	public List<Employee> getEmployeesByDeptno(Integer deptno){
		//returns all the employee details as List of Employee objects
		Connection connection=null;
		PreparedStatement prepareStatement=null;
		ResultSet resultSet=null;
		
		try{
			List<Employee> employeeList=new ArrayList<>();
			connection=MySQLConnection.getConnection();
			prepareStatement=connection.prepareStatement("select * from employee where deptno=?");
			prepareStatement.setInt(1, deptno);
			resultSet=prepareStatement.executeQuery();
			while(resultSet.next()){
				Employee employee= new Employee();
				employee.setEmpno(resultSet.getInt("empno"));
				employee.setEname(resultSet.getString("ename"));
				employee.setJob(resultSet.getString("job"));
				try{
					java.sql.Date sdate= resultSet.getDate("hiredate");
					java.util.Date udate=new java.util.Date(sdate.getTime());
					java.util.Calendar cdate= Calendar.getInstance();
					cdate.setTime(udate);
					employee.setHiredate(cdate);
				}
				catch(NullPointerException exception){
					employee.setHiredate(null);
				}
				employee.setSalary(resultSet.getDouble("salary"));
				employee.setComm(resultSet.getDouble("comm"));
				employee.setDeptno(resultSet.getInt("deptno"));
				employeeList.add(employee);
			}
			
			return employeeList;
		}
		catch(Exception exception){
			exception.printStackTrace();
			return null;
		}
	}
	
	public String deleteEmployee(Integer empno){
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		String sql="delete from employee where empno=?";
		try{
			connection=MySQLConnection.getConnection();
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, empno);
			int n= preparedStatement.executeUpdate();
			if(n>0){
				return "success";
			}else{
				return "error";
			}
		}
		catch(Exception exception){
			exception.printStackTrace();
			return "error";
		}
	}
	
}
