<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<script src="./ckeditor/ckeditor.js"></script>
</head>
<body>
	<h3>게시글등록하기2mybatis</h3>
	<a href="getBoardList2">게시글목록보기2</a>
	<form action="./insertBoard2" method="post"
		enctype="multipart/form-data" onsubmit="return submitCheck()"
		name="boardFrm">
		<table border="1" width="80%">
			<tr>
				<td>제목</td>
				<td><input type="text" name="title" /></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="writer" /></td>
			</tr>
			<tr height="500">
				<td>내용</td>
				<td><textarea name="content" id="content"></textarea></td>
			</tr>
			<tr>
				<td>파일첨부</td>
				<td><input type="file" name="tempUploadFile" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="게시글등록" /></td>
			</tr>
		</table>
	</form>

	<script>
		// Replace the <textarea id="editor1"> with a CKEditor
		// instance, using default configuration.
		CKEDITOR.replace(
						'content', {
							filebrowserUploadUrl : "${pageContext.request.contextPath}/resources/fileUpload.jsp"
						});

		function submitCheck() {
			if (document.boardFrm.writer.value == "") {
				alert("작성자 등록!!!");
				document.boardFrm.writer.focus();
				return false;
			}
			if (document.boardFrm.title.value == "") {
				alert("제목 등록!!!");
				document.boardFrm.writer.focus();
				return false;
			}
			var editor_data = CKEDITOR.instances.content.getData();
			if (editor_data == "") {
				alert("내용 등록!!!");
				document.boardFrm.writer.focus();
				return false;
			}
			return true;

		}
	</script>
</body>
</html>