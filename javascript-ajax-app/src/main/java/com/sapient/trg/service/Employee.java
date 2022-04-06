package com.sapient.trg.service;

import java.util.Calendar;

public class Employee {
	private Integer empno;
	private String ename;
	private String job;
	private Calendar hiredate;
	private Double salary;
	private Double comm;
	private Integer deptno;
	
	public Employee(){
		
	}

	public Employee(Integer empno, String ename, String job, Calendar hiredate,
			Double salary, Double comm, Integer deptno) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.hiredate = hiredate;
		this.salary = salary;
		this.comm = comm;
		this.deptno = deptno;
	}

	public Integer getEmpno() {
		return empno;
	}

	public void setEmpno(Integer empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Calendar getHiredate() {
		return hiredate;
	}
	
	public String getCustomHiredate() {
		return hiredate.get(Calendar.DATE) +"/"+hiredate.get(Calendar.MONTH)+ "/"+ hiredate.get(Calendar.YEAR);
	}
	
	public String getFormattedHiredate(){
		String hdate=hiredate.get(Calendar.DATE)+"/"+ (hiredate.get(Calendar.MONTH)+1)+"/"+hiredate.get(Calendar.YEAR);
		return hdate;
	}

	public void setHiredate(Calendar hiredate) {
		this.hiredate = hiredate;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Double getComm() {
		return comm;
	}

	public void setComm(Double comm) {
		this.comm = comm;
	}

	public Integer getDeptno() {
		return deptno;
	}

	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}

	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", ename=" + ename + ", job=" + job + ", hiredate=" + hiredate + ", salary="
				+ salary + ", comm=" + comm + ", deptno=" + deptno + "]";
	}
	
	
	
}
