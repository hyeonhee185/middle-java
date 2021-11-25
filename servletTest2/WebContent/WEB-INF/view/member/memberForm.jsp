<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 입력 폼</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#memListBtn").on("click", function(){
		location.href="<%=request.getContextPath()%>/member/memberList.do";
	});
	
	$("#idCheckBtn").on("click", function(){
		var memId = $("#mem_id").val();
		if(memId==""){
			alert("회원ID를 입력하세요.");
			$("#mem_id").focus();
			return;
		}
		
		$.ajax({
			url : "<%=request.getContextPath()%>/member/memberIdCheck.do",
				data : {
					"mem_id" : memId
				},
				dataType : "json",
				success : function(result) {
					if (result == "OK") {
						$("#idcheckResult").html("사용가능");

						// 사용가능한 ID면 ID입력칸을 읽기전용으로 만듬
						// $("#mem_id").prop("readOnly", true); // 수정불가

						oldMemberId = memId;
					} else {
						$("#idcheckResult").html("ID 중복 - 사용불가");
					}
				},
				error : function(xhr) {
					alert(xhr.status);
				}
			});

		});

		$("#mem_id").on("change", function() {
			$("#idCheckResult").text("");
		})

		// form에서 submit 이벤트가 발생했을때 처리
		$("#memberForm").on("submit", function() {
			// ID중복체크 결과 가져오기
			var idChk = $("#idcheckResult").text();

			/* 	if (idChk != "사용가능" || oldMemberId != $("#mem_id")) { */

			if (idChk != "사용가능") {
				alert("ID가 중복되거나 중복체크를 하지 않았습니다")
				return false; // 전송을 중단한다.
			}

			if ($("#mem_tel").val() == "") {
				alert("전화번호를 입력해라")
				return false; // 전송을 중단한다.
			}
			if ($("#mem_addr ").val() == "") {
				alert("주소를 입력해라")
				return false; // 전송을 중단한다.
			}

			return true; // 전송하셈
		})

	});
</script>
</head>
<body>
	<h2>회원 정보 입력 폼</h2>
	<form id="memberForm" action="<%=request.getContextPath()%>/member/memberInsert.do">
		<table border="1">
			<tbody>
				<tr>
					<td>회원ID</td>
					<td>
						<input type="text" name="mem_id" id="mem_id">
						<input type="button" value="중복확인" id="idCheckBtn">
						<br> <span id="idcheckResult"></span>
					</td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td>
						<input type="password" name="mem_pass" id="mem_pass">
					</td>
				</tr>
				<tr>
					<td>비밀번호 확인</td>
					<td>
						<input type="password" name="mem_pass2" id="mem_pass2">
					</td>
				</tr>
				<tr>
					<td>회원이름</td>
					<td>
						<input type="text" name="mem_name" id="mem_name">
					</td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td>
						<input type="text" name="mem_tel" id="mem_tel">
					</td>
				</tr>
				<tr>
					<td>주 소</td>
					<td>
						<input type="text" name="mem_addr" id="mem_addr">
					</td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: center;">
						<input type="submit" value="저장">
						<input type="reset" value="취소">
						<input type="button" value="회원목록" id="memListBtn">
					</td>
				</tr>

			</tbody>
		</table>
	</form>
</body>
</html>