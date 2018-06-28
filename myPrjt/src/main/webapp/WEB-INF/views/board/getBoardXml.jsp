<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<script src="${pageContext.request.contextPath}/resources/scripts/jquery-3.2.1.min.js"></script>
<script>
$(function(){
	function getCommentsList(){
		var requestData = {"boardSeq": "${board.seq}"}
		
		$.ajax({
			url:"../getCommentsXml",
			data:requestData,
			dataType:'xml',
			success:function(data){
				var commentsList = $(data).find("comments");
				for(i=0;i<commentsList.length;i++){
					var name = $(commentsList[i]).find("name").html();
					var content = $(commentsList[i]).find("content").html();
					var seq = $(commentsList[i]).attr("seq");
					var html = '<div style="border:1px solid blue;" class="article" id="'+seq+'">'
								+seq+' '+name+' '+content+'</div>';
					$("#commentsList").append(html);
				}
			}
		})
	};
	
	getCommentsList();
	//$(window).bind("load",getCommentsList);
	
	
	$("#btnCommentAdd").click(function(){
		var requestData = {"name":$("[name=name]").val(), "content":$("[name=content]").val(), boardSeq:"${board.seq}"};
		$.ajax({
			url:"../insertComments",
			data:requestData,
			dataType:'json',
			success:function(data){
				var html = '<div style="border:1px solid blue;" class="article" id="'+data.seq+'">'
					+data.seq+' '+data.name+' '+data.content+'</div>';
				$("#commentsList").prepend(html);
				document.getElementById("name").value="";
				$("[name=content]").val("");
			}
		})
	});

})

</script>
</head>
<body>
${boardVO}
	<h3>게시글정보조회mybatis</h3>
	<a href="../getBoardList">게시판목록보기</a>
	<br> ${board}<hr>
	<br> 순번: ${board.seq}
	<br> 제목: ${board.title}
	<br> 작성자: ${board.writer}
	<br> 내용: ${board.content}
	<br> 등록일: ${board.regDate}
	<hr><a href="../updateBoard">수정</a><br>
	<hr>
	게시판답글<hr>
	<div style="border:1px solid green">
		<form id="commentFrm">
			<input name="name" id="name" size="10">
			<input name="content" id="content" size="50">
			<input type="button" id="btnCommentAdd" value="댓글등록"/>
		</form>
	</div><br>
	<div id="commentsList"></div>
</body>
</html>
