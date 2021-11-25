<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 
	'id기억하기' 체크박스를 체크한 후 'Login'버튼을 클릭하면 입력했던 'ID'를 쿠키에 저장하고
	쿠키에 'ID'값이 저장되어 있으면 'ID' 입력 창에 쿠키에 저장되었던 'ID'가 나타나도록 하고
	체크박스도 체크가 된 상태로 유지되도록 한다.
	
	체크박스를 해제한 후 로그인을 하면 쿠키에 저장된 'ID'를 삭제하고 체크박스도 해제된
	상태가 되도록 한다.
	
	로그인 성공 ID와 PassWord는 'test', '1234'이고, 로그인이 성공하면
	'cookieMain.jsp'로 이동하고 실패하면 'cookieLogin.jsp'로 이동되도록 한다.

 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Cookie[] cookies = request.getCookies(); // 쿠키 가져오기
	String userId = "";
	String chk = "";
	if(cookies!=null){
		for(Cookie cookie : cookies){
			if("userId".equals(cookie.getName())){ 
				userId = cookie.getValue();
				chk = "checked";
			}
		}
	}
%>
<form method="post"
	action="<%=request.getContextPath()%>/CookieLoginServlet.do">
<table style="margin:0 auto;">
<tr>
	<td> ID : </td>
	<td> <input type="text" name="userid" value="<%=userId %>" placeholder="ID를 입력하세요"> </td>
</tr>
<tr>
	<td> PASS : </td>
	<td> <input type="password" name="pass" placeholder="PassWord를 입력하세요"> </td>
</tr>
<tr>
	<td colspan="2"> <input type="checkbox" name="checkid" <%=chk %> value="check">Id 기억하기 </td>
</tr>
<tr>
	<td colspan="2" style="text-align: center;"> 
		<input type="submit" value="Login"> </td>
</tr>
</table>
</form>
</body>
</html>