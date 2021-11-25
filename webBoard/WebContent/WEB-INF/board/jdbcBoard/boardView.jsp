<%@page import="vo.JdbcBoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

	JdbcBoardVO boardVo =
		(JdbcBoardVO) request.getAttribute("boardVo");
	
%>

<h1>상세보기</h1>
<br><br>

	<tr>글번호</td>&nbsp;
	<tr><%=boardVo.getBoard_no() %></tr><br>
	<tr>제목</td>&nbsp;
	<tr><%=boardVo.getBoard_title() %></tr><br>
	<tr>작성자</td>&nbsp;
	<tr><%=boardVo.getBoard_writer() %></tr><br>
	<tr>내용</td>&nbsp;<br>
	<tr><%=boardVo.getBoard_content() %></tr><br>
	<tr>조회수</td>&nbsp;
	<tr><%=boardVo.getBoard_cnt() %></tr><br><br>


	<a href="<%=request.getContextPath()%>/boardList.do"><input type="button" value="목록"></a>
	<a href="<%=request.getContextPath()%>/boardUpdate.do?idx=<%=boardVo.getBoard_no() %>"><input type="button" value="수정"></a>
	<a href="<%=request.getContextPath()%>/boardDelete.do?idx=<%=boardVo.getBoard_no() %>"><input type="button" value="삭제"></a>

  
</body>

</html>