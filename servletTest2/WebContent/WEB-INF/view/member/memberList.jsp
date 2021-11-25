<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#addBtn").on("click", function(){
		location.href="<%=request.getContextPath()%>/member/memberForm.do";
						});

	});
</script>
</head>
<body>
	<%
		List<MemberVO> memList = (List<MemberVO>) request.getAttribute("memberList");
	%>
	<table border="1">
		<tr>
			<td colspan="5">
				<input type="button" id="addBtn" value="회원추가">
			</td>
		</tr>
		<tr>
			<td>ID</td>
			<td>비밀번호</td>
			<td>이름</td>
			<td>전화</td>
			<td>주소</td>
		</tr>
		<%
			if (memList == null || memList.size() == 0) {
		%>
		<tr>
			<td colspan="5">회원이 한명도 없습니다.</td>
		</tr>
		<%
			} else {
				for (MemberVO memVo : memList) {
		%>
		<tr>
			<td>
				<a href="<%=request.getContextPath()%>/member/memberView.do?mem_id=<%=memVo.getMem_id()%>"><%=memVo.getMem_id()%></a>
			</td>
			<td><%=memVo.getMem_pass()%></td>
			<td><%=memVo.getMem_name()%></td>
			<td><%=memVo.getMem_tel()%></td>
			<td><%=memVo.getMem_addr()%></td>
		</tr>
		<%
			}
			}
		%>
	</table>
</body>
</html>