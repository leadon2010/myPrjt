<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<script src="./ckeditor/ckeditor.js" ></script>
</head>
<body>
	<h3>게시글등록하기mybatis</h3>
	<a href="getBoardList">게시글목록보기</a>
	<form action="./insertBoard" method="post" enctype="multipart/form-data" onsubmit="return submitCheck()" name="boardFrm">
		title:<input type="text" name="title" /> 
		writer:<input type="text" name="writer" /> 
		content:<textarea name="content" id="content"></textarea>
		fileUpload:<input type="file" name="tempUploadFile" /> 
		<input type="submit" value="게시글등록" />
	</form>
	
	<script>
		// Replace the <textarea id="editor1"> with a CKEditor
		// instance, using default configuration.
		CKEDITOR.replace('content',{
			filebrowserUploadUrl:"${pageContext.request.contextPath}/resources/fileUpload.jsp"
		});
		
		function submitCheck(){
			if (document.boardFrm.writer.value == ""){
				alert("작성자 등록!!!");
				document.boardFrm.writer.focus();
				return false;
			}
			if (document.boardFrm.title.value == ""){
				alert("제목 등록!!!");
				document.boardFrm.writer.focus();
				return false;
			}
			var editor_data = CKEDITOR.instances.content.getData();
			if (editor_data == ""){
				alert("내용 등록!!!");
				document.boardFrm.writer.focus();
				return false;
			}
			return true;

		}
	</script>
</body>
</html>