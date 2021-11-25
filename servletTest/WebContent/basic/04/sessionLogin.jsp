<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session 로그인 폼 페이지</title>
</head>
<body>
<%
	// JSP문서에서 세션은 'session'이라는 이름으로 저장되어 있다.
	
	// 로그인이 성공되면 해당 로그인한 사람의 id값이 'userId'라는 키값으로 
	// 세션에 저장한다.
	String userid = (String)session.getAttribute("userId");
	
%>
<%
	if(userid==null){	// null이면 해당 세션값이 없으면...
	
	%>
	<form method="post"
		action="<%=request.getContextPath()%>/sessionLogin.do">
	<table style="margin:0 auto;" border="1">
	<tr>
		<td> ID : </td>
		<td> <input type="text" name="userid" " placeholder="ID를 입력하세요"> </td>
	</tr>
	<tr>
		<td> PASS : </td>
		<td> <input type="password" name="pass" placeholder="PassWord를 입력하세요"> </td>
	</tr>
	<tr>
		<td colspan="2" style="text-align: center;"> 
			<input type="submit" value="Login"> </td>
	</tr>
	</table>
	</form>
<%
}else{	// 세션에 값이 있을 때... (즉, 로그인 성공했을 때)
%>
	<%=userid %>님 반갑습니다.<br><br>
	<a href="<%=request.getContextPath()%>/sessionLogout.do">로그아웃</a>

<%
}
%>


</body>
</html>