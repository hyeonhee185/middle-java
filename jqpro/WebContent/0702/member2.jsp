<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@page import="kr.or.ddit.ibatis.config.BuildedSqlMapClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- 기호 이름 '릿' --%>
<%
//요청 데이터 없음

//SqlMapClient객체 얻기
SqlMapClient smc = BuildedSqlMapClient.getSqlMapClient();

//sql문 실행 - namespace명.id명
//결과받기
List<MemberVO> list = smc.queryForList("mem.selectAll");

//결과데이터를 이용해서 응답데이터 생성하기 - [{}, {}, {}] jsonObjectArray형태
%>
[
<%
for(int i=0; i<list.size(); i++){
	MemberVO vo = list.get(i);
	
	if(i>0) out.print(",");
%>	
	{
		"id"	: "<%=vo.getMem_id() %>",
		"name"	: "<%=vo.getMem_name() %>",
		"add1"	: "<%=vo.getMem_add1() %>",
		"add2"	: "<%=vo.getMem_add2() %>",
		"hp"	: "<%=vo.getMem_hp() %>",
		"email" : "<%=vo.getMem_mail() %>"
	}
<%	
}//for end
%> 
]








