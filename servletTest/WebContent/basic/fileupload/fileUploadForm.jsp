<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Servlet을 이용한 File Upload 연습</title>
</head>
<body>
<h1>File Upload 연습</h1>
<!-- 파일 업로드 할 때 반드시 form태그에 설정해야하는 속성
	==> enctype="multipart/form-data"
 -->
<form method="post" enctype="multipart/form-data" 
	action="<%=request.getContextPath()%>/fileUpload.do">
  ID : <input type="text" name ="memid"><br><br>
  Upload File 선택1 : <input type="file" name="uploadFile1" multiple><br><br>
  Upload File 선택2 : <input type="file" name="uploadFile2"><br><br>
  <input type="submit" value="파일Upload">  
</form>
<br><hr><br>
<a href="<%=request.getContextPath() %>/uploadFileList.do">
전체 Upload파일 보기</a>


</body>
</html>










