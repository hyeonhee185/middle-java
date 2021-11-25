<%@page import="kr.or.ddit.lprod.vo.LprodVO"%>
<%@page import="java.util.List"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@page import="kr.or.ddit.ibatis.config.BuildedSqlMapClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//sqlMapClient객체 얻기
SqlMapClient smc = BuildedSqlMapClient.getSqlMapClient();
//sql문 실행 - namespace.id로 접근
List<LprodVO> list = smc.queryForList("lprod.selectAll");

//응답데이터 생성 - list - jsonObjectArray
%>
[
<%
	for(int i=0; i<list.size(); i++){
		LprodVO vo = list.get(i);
		if(i>0) out.print(",");
%>		
	{
		"id"	: "<%=vo.getLprod_id() %>",
		"gu"	: "<%=vo.getLprod_gu() %>",
		"nm"	: "<%=vo.getLprod_nm() %>"
	}
<%		
	}
%>
]

