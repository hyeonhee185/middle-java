<%@page import="kr.or.ddit.basic.fileupload.UploadDetail"%>
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
	String memId = (String)request.getAttribute("memId");
	List<UploadDetail> fileList = 
			(List<UploadDetail>)request.getAttribute("uploadFileList");
%>

<%
	if(memId != null){
%>
	<h1><%=memId %>님이 방금 업로드한 파일 목록</h1>
<%		
	}else{
%>
	<h1>전체 업로드 파일 목록</h1>
<%
	}
%>

<table border="1">
<tr>
	<td>파일 이름</td><td>파일 크기</td><td>업로드 상태</td><td>비 고</td>
</tr>
<% 
if(fileList != null){
	for(int i=0; i<fileList.size(); i++){
%>
	<tr>
		<td><%=fileList.get(i).getFileName() %></td>
		<td><%=fileList.get(i).getFileSize() %></td>
		<td><%=fileList.get(i).getUploadStatus() %></td>
		<td><a href="<%=request.getContextPath()%>/fileDownload.do?filename=<%=fileList.get(i).getFileName()%>">Download</a></td>
	</tr>
<%		
	}
}
%>

</table>
<br><hr><br>
<a href="<%= request.getContextPath()%>/basic/fileupload/fileUploadForm.jsp">업로드 문서로 가기</a>
</body>
</html>










