<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<script src="./ckeditor/ckeditor.js" ></script>
</head>
<body>
	<h3>게시글정보수정mybatis</h3>
	<a href="getBoardList">게시글목록보기</a>
	<form action="updateBoard" method="post">
		<%-- ${board}<br> --%>
		순번:<input type="text" name="seq" value='${board.getSeq()}' /><br>
		제목:<input type="text" name="title" value='${board.title}' /><br>
		작성자:<input type="text" name="writer" value='${board.writer}' /><br>
		내용:<textarea id="content" name="content" >${board.content}</textarea>
		<%-- <input type="text" name="content" value='${board.content}' /><br> --%>
		<input type="submit" value="수정" />
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