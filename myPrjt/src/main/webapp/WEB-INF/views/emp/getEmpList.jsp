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
	<a href="./empExcelCreate">엑셀출력</a><br>
	<a href="./empExcelView">엑셀View출력</a>
	<table border="1">
		<c:forEach items="${empList}" var="emp">
			<tr>
				<td>${emp.employeeId}</td>
				<td>${emp.firstName}</td>
				<td>${emp.lastName}</td>
				<td>${emp.salary}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>