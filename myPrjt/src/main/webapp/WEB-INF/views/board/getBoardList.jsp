<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="my" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body>
	<h3>게시판목록mybatis</h3>
	<a href="insertBoard">게시글등록하기</a>
	<form action="">
		<table border="1">
			<tr>
				<td colspan="3">검색조건</td>
			</tr>
			<tr>
				<td><select name="searchCondition">
						<c:forEach items="${conditionMap}" var="item">
							<option value="${item.value}">${item.key}</option>
						</c:forEach>
				</select></td>
				<td><input name="searchKeyword" type="text" /></td>
				<td><input type="submit" value="검색" /></td>
			</tr>
		</table>
	</form>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<!-- <th>내용</th> -->
			<th>등록일</th>
			<th>FileName</th>
		</tr>
		<c:forEach items="${boardList}" var="board">
			<tr>
				<td>${board.SEQ}</td>
				<td><a href="getBoard/${board.SEQ}">${board.TITLE}</a></td>
				<td>${board.WRITER}</td>
				<%-- <td>${board.CONTENT}</td> --%>
				<td>${board.REGDATE}</td>
				<td>${board.UPLOAD_FILE}</td>
			</tr>
		</c:forEach>
	</table>
	<my:paging paging="${paging}"></my:paging>
	<script >
		function doList(page){
			location.href = "./getBoardList?page="+page
		}
	</script>
</body>
</html>