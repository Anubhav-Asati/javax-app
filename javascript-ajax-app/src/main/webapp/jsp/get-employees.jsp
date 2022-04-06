<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.sapient.trg.service.*,java.util.List"   %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<table border="1" width="100%" bgColor="cyan">
		<tr>
			<th>Empno</th>
			<th>Ename</th>
			<th>Job</th>
			<th>Hiredate</th>
			<th>Salary</th>
			<th>Commission</th>
			<th>Deptno</th>
		</tr>

		<c:forEach var="emp" items="${employeeList}">
			<tr>
				<td><c:out value="${emp.empno}" /></td>
				<td><c:out value="${emp.ename}" /></td>
				<td><c:out value="${emp.job}" /></td>
				<td><c:out value="${emp.customHiredate}" /></td>
				<td><c:out value="${emp.salary}" /></td>
				<td><c:out value="${emp.comm}" /></td>
				<td><c:out value="${emp.deptno}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>