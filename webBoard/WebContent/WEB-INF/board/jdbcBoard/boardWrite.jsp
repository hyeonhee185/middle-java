<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form id = "boardInsert" method="post" action = "<%=request.getContextPath() %>/boardInsert.do">
<br><br><br><br><br>
<!-- <table> -->
<!--   <tr> -->
<!--    <td> -->
    <table width="100%" cellpadding="0" cellspacing="0" border="0">
      <td id="write">글쓰기</td>
     </tr>
    </table>
    <br>
    
   <table class="table table-hover table-sttiped text-center a-hover a-link" style = "border : 1">
     <thead>
     <tr>
      <td>&nbsp;</td>
      <td id="tt">제목</td>
      <td><input name="title" id="title" size="50" maxlength="100"></td>
      <td>&nbsp;</td>
     </tr>
     
     
     <tr>
      <td>&nbsp;</td>
      <td align="center">내용</td>
      <td><textarea name="content" id="content" cols="50" rows="13"></textarea></td>
      <td>&nbsp;</td>
     </tr>
     <tr align="center">
      <td>&nbsp;</td>
      <td colspan="2"><input type="submit" value="등록" name="sub" id="sub">
       <input type=button value="취소" id="cancleBtn">
      <td>&nbsp;</td>
     </tr>
    </table>
    
<!--    </td> -->
<!--   </tr> -->
<!--  </table> -->
 <br><br>
</form>
</body>
</html>