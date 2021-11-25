<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	String a[] = request.getParameterValues("hobby");
	
	System.out.print(a);
	
	String str = "";
	for(int i=0; i<a.length; i++){
		str += a[i] + " ";
	}
	System.out.print(str);
%>

<%=str %>


</body>
</html>