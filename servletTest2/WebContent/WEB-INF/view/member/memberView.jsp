<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>
<script>
$(function(){
	$("#memListBtn").on("click", function(){
		location.href="<%=request.getContextPath()%>/member/memberView.do";		
		});

	$("#memUpdateBtn").on("click", function(){
	      $("#memberForm").attr("action", "<%=request.getContextPath()%>/member/memberUpdateForm.do");
	      $("#memberForm").submit(); // form 데이터를 서버로 전송한다.
	   });

	   $("#memDeleteBtn").on("click", function(){
	      $("#memberForm").attr("action", "<%=request.getContextPath()%>/member/memberDelete.do");
	      $("#memberForm").submit(); // form 데이터를 서버로 전송한다.
	   });
	});
</script>
</head>
<body>
	<%
		MemberVO memVo = (MemberVO) request.getAttribute("memberVo");
	%>
	<h2>회원 정보 조회</h2>
	<form id="memberForm">
		<input type="hidden" name="mem_id" id="mem_id" value="<%=memVo.getMem_id()%>">
		<table border="1">
			<tbody>
				<tr>
					<td>회원ID</td>
					<td>
						<%=memVo.getMem_id()%>
					</td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td></td>
				</tr>
				<tr>
					<td>비밀번호 확인</td>
					<td><%=memVo.getMem_pass()%></td>
				</tr>
				<tr>
					<td>회원이름</td>
					<td><%=memVo.getMem_name()%></td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td><%=memVo.getMem_tel()%></td>
				</tr>
				<tr>
					<td>주 소</td>
					<td><%=memVo.getMem_addr()%></td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: center;">
						<input type="button" value="수정" id="memUpdateBtn">
						<input type="button" value="삭제" id="memDeleteBtn">
						<input type="button" value="회원목록" id="memListBtn">
					</td>
				</tr>

			</tbody>
		</table>
	</form>
</body>
</html>