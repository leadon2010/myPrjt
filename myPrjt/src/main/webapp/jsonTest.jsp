<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<script>

	obj = {id:"test", name:"lch"};
	str = JSON.stringify(obj);
	document.write(str);
	document.write("<hr>");
	document.write(typeof str);
	document.write("<hr>");
	document.write(typeof obj);
	result = JSON.parse(str);
	document.write("<hr>");
	document.write(result.id + " / " + result.name);

</script>
</head>
<body>

</body>
</html>