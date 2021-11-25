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
	//실제로는 요청 데이터를 통해 DB와 연결 후 crud 작업 후 수행 결과로 응답 데이터를 받아야 하지만
	//과정을 생략하고 임의로 데이터를 받았다고 가정하여 작성된 데이터
	String aa[] = {"홍길동","개나리","진달래","무궁화","수선화"};
%>
  <ul>
<%
	for(int i=0; i<aa.length; i++){
%>
<%-- html코드 삽입 --%>
		<li><%=aa[i]%></li>
<%		
	}
%>
  </ul>
</body>
</html>