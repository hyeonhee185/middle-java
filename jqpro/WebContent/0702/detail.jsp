<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@page import="kr.or.ddit.ibatis.config.BuildedSqlMapClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");

//요청 데이터
String mid = request.getParameter("id");

//sqlMapClient객체 얻어오기
SqlMapClient smc = BuildedSqlMapClient.getSqlMapClient();

//sql구문 실행 - 결과 데이터 발생 - jsonObject 응답데이터 생성하기
MemberVO vo = (MemberVO)smc.queryForObject("mem.detail", mid);
%> 
	{
		"id"	: "<%=vo.getMem_id() %>",
		"hp" 	: "<%=vo.getMem_hp() %>",
		"mail"	: "<%=vo.getMem_mail() %>"
	}




  

