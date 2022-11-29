<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>로그인 페이지</title>
	<style type="text/css">
		.layout{margin:0px auto;width:1180px;padding:10px;font-size:18px}
		table, td{border:2px solid powderBlue;border-collapse:collapse;}
		table{margin:250px auto 0px auto}
		td{height:40px}
		.btn{text-align:center;font-size:18px;border-radius:10px;background-color:powderBlue;
		border:1px solid black;width:100px;height:30px}
		.btnBox{width:350px;height:30px;margin:auto;background-color:white;text-align:center}
	</style>
	<script>
		function login() {
			if (form.userId.value == "") {
				alert("사용자 ID를 입력하십시오.");
				form.userId.focus();
				return false;
			} 
			if (form.password.value == "") {
				alert("비밀번호를 입력하십시오.");
				form.password.focus();
				return false;
			}		
			form.submit();
		}
		
		function userCreate(targetUri) {
			form.action = targetUri;
			form.submit();
		}
	</script>
</head>
<body>
	<!-- 로고와 메뉴 -->
	<jsp:include page = "../main/menu.jsp"/>
	<hr>
	<div class = "layout">
		<!-- 로그인 폼 -->
		<form name="form" method="POST" action="<c:url value='/user/login' />">
			<!-- 로그인이 실패한 경우 exception 객체에 저장된 오류 메시지를 출력 -->
	        <c:if test="${loginFailed}">
		  	  <br><font color="red"><c:out value="${exception.getMessage()}" /></font><br>
		    </c:if>
			<table>
				<tr>
					<td width="100" align="center">아이디</td>
					<td width="250" style="padding-left:10px">
						<input type="text" style="width:230px" name="userId">
					</td>
				</tr>
				<tr>
					<td width="100" align="center">비밀번호</td>
					<td width="250" style="padding-left:10px">
						<input type="password" style="width:230px" name="userPw">
					</td>
				</tr>
			</table><br>
			<div class = "btnBox">
				<input type="submit" value="로그인" onClick="login()" class = "btn"> &nbsp;
				<input type="button" value="회원가입" onClick="userCreate('<c:url value='/user/register/form' />')" class = "btn">
			</div>
		</form>
	</div>
</body>
</html>