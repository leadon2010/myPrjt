<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<script src="${pageContext.request.contextPath}/resources/scripts/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script>
	 
	var options = {
		title : '부서별 사원정보',
		width : 400,
		height : 500
	};
	google.charts.load('visualization', '1.0', {'packages' : [ 'corechart' ]});
	google.charts.setOnLoadCallback(function() {
		var chartData = [];
		chartData.push(['사원명','사원수']);
		$.ajax({
			url:"${pageContext.request.contextPath}/emp/getDeptCnt",
			dataType:'json',
			success:function(result){
				for(i=0;i<result.length;i++){
					var deptNm = result[i].department_name;
					var cnt = result[i].cnt;
					
					var temp = [deptNm, parseInt(cnt)];
					console.log(deptNm);
					chartData.push(temp);
				}
				var chart = new google.visualization.LineChart(document.querySelector('#chart_div'));
				chart.draw(google.visualization.arrayToDataTable(chartData), options);
			}
		})
		
	});

</script>
</head>
<body>
	차트연습
	<div id="chart_div"></div>
</body>
</html>