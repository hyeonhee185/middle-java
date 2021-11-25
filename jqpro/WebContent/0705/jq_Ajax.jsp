<%@page import="java.util.Map"%>
<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@page import="kr.or.ddit.ibatis.config.BuildedSqlMapClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");

//요청데이터 가져오기 - id, pw
String userId = request.getParameter("id");
String userPw = request.getParameter("pw");

//sqlMapClient객체 얻기
SqlMapClient smc = BuildedSqlMapClient.getSqlMapClient();

//sql실행(namespapce.id)
Map<String, String> map = new HashMap<String, String>();

map.put("mid", userId);
map.put("mpw", userPw);

MemberVO vo = (MemberVO)smc.queryForObject("mem.login",map);

//결과를 vo객체로 받아서 응답데이터 생성
if(vo != null){
//jsonObject생성	
%>
	{
		"sw"	: "ok",
		"name"	: "<%=vo.getMem_name() %>"	
	}
<%	
}else{
%>
	{
		"sw"	: "no"
	}
<%
}
%>





