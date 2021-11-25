<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
request.setCharacterEncoding("utf-8");

//요청 데이터 - id, pw
String sid = request.getParameter("id");
String spw = request.getParameter("pw");

//DB와 연결 후 crud작업을 통해 수행 결과를 응답 데이터로 만들어야 한다

//수행결과를 통해 데이터를 받아와야 하지만 지금은 임의로 만든 응답데이터를 활용한다
String ss = "0"; //로그인이 성공일 때  

if(ss.equals("0")){
%>
	{
		"id" : "<%=sid %>",
		"sw" : "ok"
	}
<%
}else{
%>
	{
		"id" : "<%=sid %>",
		"sw" : "no"
	}
<%
}
%>


