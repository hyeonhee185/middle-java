<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/basic/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$(function(){
	// 문자열
	$("#strBtn").on("click", function(){
		$.ajax({
			"url"  : "<%=request.getContextPath()%>/jsonServlet.do",
			"type" : "post",
			//"data" : "choice=str",
			"data" : {"choice" : "str"}, 
			"success" : function(data){
				
				$("#result").html(data);
				
			},
			"error" : function(hx){
				alert(hx.status);
			},
			"dataType" : "json"
		});
	});
	
	// 배열 
	$("#arrayBtn").on("click", function(){
		$.ajax({
			"url"  : "<%=request.getContextPath()%>/jsonServlet.do",
			"type" : "post",
			//"data" : "choice=array",
			"data" : {"choice" : "array"}, 
			"success" : function(data){
				var str = ""
				$.each(data, function(i,v){
					str += i + "번째 값: " + v + "<br>";
				});
				
				$("#result").html(str);
				
			},
			"error" : function(hx){
				alert(hx.status);
			},
			"dataType" : "json"
		});
	});
	
	// 객체
	$("#objBtn").on("click", function(){
		$.ajax({
			"url"  : "<%=request.getContextPath()%>/jsonServlet.do",
			"type" : "post",
			//"data" : "choice=obj",
			"data" : {"choice" : "obj"}, 
			"success" : function(data){
				var str = "번호: " + data.num + "<br>";
				str += "이름: " + data.name + "<br>";
				
				$("#result").html(str);
				
			},
			"error" : function(hx){
				alert(hx.status);
			},
			"dataType" : "json"
		});
	});
	
	// 리스트
	$("#listBtn").on("click", function(){
		$.ajax({
			"url"  : "<%=request.getContextPath()%>/jsonServlet.do",
			"type" : "post",
			//"data" : "choice=list",
			"data" : {"choice" : "list"}, 
			"success" : function(data){
				var str = "";
				$.each(data, function(i, v){ // v에 들어감 {"num":11,"name":"일지매"}
					str += i + "번째 데이터<br>";
					str += "번호 : " + v.num + "<br>";
					str += "이름 : " + v.name + "<hr>";
				}); 
				$("#result").html(str);
				
			},
			"error" : function(hx){
				alert(hx.status);
			},
			"dataType" : "json"
		});
	});
	
	// Map
	$("#mapBtn").on("click", function(){
		$.ajax({
			"url"  : "<%=request.getContextPath()%>/jsonServlet.do",
			"type" : "post",
			//"data" : "choice=map",
			"data" : {"choice" : "map"}, 
			"success" : function(data){
				var str = "name : " + data.name + "<br>";
				str += "tel : " + data.tel + "<br>";
				str += "addr : " + data.addr + "<br>";
				
				$("#result").html(str);
				
			},
			"error" : function(hx){
				alert(hx.status);
			},
			"dataType" : "json"
		});
	});
});
</script>
</head>
<body>
<form>
	<input type="button" id="strBtn" value="문자열">
	<input type="button" id="arrayBtn" value="배 열">
	<input type="button" id="objBtn" value="객 체">
	<input type="button" id="listBtn" value="리스트">
	<input type="button" id="mapBtn" value="Map객체">
</form>
<hr>
<h3>응답 데이터 출력 영역</h3>
<div id="result"></div>
</body>
</html>