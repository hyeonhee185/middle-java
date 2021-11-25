<%@page import="kr.or.ddit.buyer.vo.BuyerVO"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@page import="kr.or.ddit.ibatis.config.BuildedSqlMapClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
request.setCharacterEncoding("utf-8");

//요청데이터 가져오기 -  id
String buyerId = request.getParameter("idid");

//SqlMapClienet 객체 얻어오기
SqlMapClient smc = BuildedSqlMapClient.getSqlMapClient();

//sql구문 실행
BuyerVO vo = (BuyerVO)smc.queryForObject("buyer.buyerDetail", buyerId);

//응답데이터 생성 - jsonObject
%>    

{
	"id"		: "<%=vo.getBuyer_id() %>",
	"name"		: "<%=vo.getBuyer_name() %>",
	"lgu"		: "<%=vo.getBuyer_lgu() %>",
	"bank"		: "<%=vo.getBuyer_bank() %>",
	"bankname"	: "<%=vo.getBuyer_bankname() %>",
	"bankno"	: "<%=vo.getBuyer_bankno() %>",
	"zip"		: "<%=vo.getBuyer_zip() %>",
	"add1"		: "<%=vo.getBuyer_add1() %>",
	"add2"		: "<%=vo.getBuyer_add2() %>"
}




