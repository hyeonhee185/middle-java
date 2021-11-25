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
	List<JdbcBoardVO> boardList =
		(List<JdbcBoardVO>) request.getAttribute("boardList");
%>

<h1>게시판 목록</h1>
<br><br>


<table width="100%" cellpadding="0" cellspacing="0" border="1" >

<tr border="1" >
   <th>번호</th>
   <th>제목</th>
   <th>작성자</th>
   <th>조회수</th>
  </tr>

<%
 	if(boardList==null || boardList.size()==0) {
%>	
	<tr><td colspan="5">등록된 게시글이 없습니다.</td></tr>
<%
 	}else {
 		for(JdbcBoardVO boardVo : boardList) {
%>
<tr border="1">
	<td align="center"><%=boardVo.getBoard_no() %></td>
	<td align="center"><a href="<%=request.getContextPath()%>/boardSelect.do?idx=<%=boardVo.getBoard_no() %>"><%=boardVo.getBoard_title() %></a></td>
	<td align="center"><%=boardVo.getBoard_writer() %></td>
	<td align="center"><%=boardVo.getBoard_cnt() %></td>
</tr>
<% 			
 		}
 	}
%>
</table>

  <tr align="center">
   <td><a href="<%=request.getContextPath() %>/boardInsert.do"><input type=button value="글쓰기" id="writeBtn"></a></td>
   <td><input type="text" name="searchTitle" id="searchTitle"></td>
   <td>
   	<input type="button" value="검색" onclick="search()">
   </td>
  </tr>
</table>
<script type="text/javascript">
function search(){
	let searchTitle = document.getElementById('searchTitle').value;
	location.href = '<%=request.getContextPath() %>/boardList.do?searchTitle='+searchTitle;
}
</script>
  
</body>

</html>