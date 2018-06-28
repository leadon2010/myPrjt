<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body>
	<h3>게시판목록(getEmpList)</h3>

	<table border="1">
		<c:forEach items="${empList}" var="emp">
			<tr>
				<td>${emp.EMPLOYEE_ID}</td>
				<td>${emp.FIRST_NAME}</td>
				<td>${emp.LAST_NAME}</td>
				<td>${emp.SALARY}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>