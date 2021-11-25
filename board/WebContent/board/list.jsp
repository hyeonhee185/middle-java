<%@page import="kr.or.ddit.board.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
List<BoardVO> list = (List<BoardVO>)request.getAttribute("list");

int sPage = (int)request.getAttribute("startPage");
int ePage = (int)request.getAttribute("endPage");
int ttPage = (int)request.getAttribute("totalPage");
%>

	{
		"sp"	: "<%=sPage %>",
		"ep"	: "<%=ePage %>",
		"tp"	: "<%=ttPage %>",
		"datas"	: [
<%
	for(int i=0; i<list.size(); i++){
		BoardVO vo = list.get(i);
		if(i>0) out.print(",");
%>		
		{
			"num"		: "<%=vo.getNum() %>",	
			"subject"	: "<%=vo.getSubject() %>",	
			"writer"	: "<%=vo.getWriter() %>",	
			"mail"		: "<%=vo.getMail() %>",	
			"cont"		: "<%=vo.getContent() %>",	
			"hit"		: "<%=vo.getHit() %>",	
			"wdate"		: "<%=vo.getWdate() %>"	
		}
<%
	}//for end
%>
		]
	}
