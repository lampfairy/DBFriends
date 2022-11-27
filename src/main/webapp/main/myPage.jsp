<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.User" %>
<%
	User user = (User)session.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>마이 페이지</title>
	<style type="text/css">
		.layout{margin:0px auto;width:1180px;padding:10px;font-size:18px}
		table, td{border:2px solid skyBlue;border-collapse:collapse;}
		table{margin:50px auto 0px auto}
		td{height:40px}
		.btn{text-align:center;font-size:18px;border-radius:10px;background-color:skyBlue;
		border:1px solid black;width:100px;height:30px}
		.btnBox{width:350px;height:30px;margin:auto;background-color:white;text-align:center}
		.new{width:1180px;margin: 0px auto}
		.new div{text-align:center;font-size:18px;width:330px;height:330px;
		background-color:skyBlue;float:left;margin:0px 30px;line-height:330px;}
	</style>
	<script>
		function userCreate() {
			if (form.userPw.value == "") {
				alert("비밀번호를 입력하십시오.");
				form.password.focus();
				return false;
			}
			if (form.userPw.value != form.password2.value) {
				alert("비밀번호가 일치하지 않습니다.");
				form.name.focus();
				return false;
			}
			if (form.name.value == "") {
				alert("이름을 입력하십시오.");
				form.name.focus();
				return false;
			}
			<!-- var phoneExp = /^\d{2,3}-\d{3,4}-\d{4}$/;
			if(phoneExp.test(form.phone.value)==false) {
				alert("전화번호 형식이 올바르지 않습니다.");
				form.phone.focus();
				return false;
			} -->
			
			var emailExp = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
			if(emailExp.test(form.email.value)==false) {
				alert("이메일 형식이 올바르지 않습니다.");
				form.email.focus();
				return false;
			}
			
			<!-- var birthExp = /^[10000000-99999999]/;
			if(birthExp.test(form.birth.value)==false) {
				alert("생년월일 형식이 올바르지 않습니다.");
				form.birth.focus();
				return false;
			} -->
			
			form.submit();
		}
		
	</script>
</head>
<body>
	<!-- 로고와 메뉴 -->
	<jsp:include page = "menu.jsp"/>
	<hr>
	<div class = "layout">
		<!-- 회원정보 폼 -->
		<form class = "form" method="POST" action="<c:url value='/user/update' />">
			<!-- 회원가입이 실패한 경우 exception 객체에 저장된 오류 메시지를 출력 -->
	       <c:if test="${registerFailed}">
		      <font color="red"><c:out value="${exception.getMessage()}" /></font>
		   </c:if>
			<table>
				<caption style="text-align:center;font-size:24px;margin:0 0 50px 0">회원정보</caption>
				<tr>
					<td width="150" align="center">이름</td>
					<td width="250" style="padding-left:10px">
						<input type="text" style="width:230px;" name="name" placeholder="ex.20130101" value="${user.getName()}"
						<c:if test="${registerFailed}">value="${user.name}"</c:if>>
					</td>
				</tr>
			    <tr>
				<td width="150" align="center">사용자 ID</td>
				<td width="250" style="padding-left:10px">
					<input type="text" style="width:230px;" name="userId" value="${user.userId}" readonly>
				</td>
			  </tr>
		  	  <tr>
				<td width="150" align="center">비밀번호</td>
				<td width="250" style="padding-left:10px">
					<input type="password" style="width:230px" name="userPw" value="${user.userPw}">
				</td>
			  </tr>
			   <tr>
					<td width="150" align="center">비밀번호 확인</td>
					<td width="250" style="padding-left:10px">
						<input type="password" style="width:230px" name="password2" value="${user.userPw}">
					</td>
				  </tr>
			  <tr>
				<td width="150" align="center">전화번호</td>
				<td width="250" style="padding-left:10px">
					<input type="text" style="width:230px" name="phone" value="${user.phoneNumber}"
						<c:if test="${registerFailed}">value="${user.phoneNumber}"</c:if>>
				</td>
			  </tr>
		  	  <tr>
				<td width="150" align="center">이메일 주소</td>
				<td width="250" style="padding-left:10px">
					<input type="text" style="width:230px" name="email" value="${user.emailAddress}"
						<c:if test="${registerFailed}">value="${user.emailAddress}"</c:if>>
				</td>
			  </tr>
			  <tr>
				<td width="150" align="center">생년월일</td>
				<td width="250" style="padding-left:10px">
					<input type="text" style="width:230px" name="birth" value="${user.birthDate}"
						<c:if test="${registerFailed}">value="${user.birthDate}"</c:if>>
				</td>
			  </tr>
		    </table><br>
			<div class = "btnBox">
				<input type="submit" value="수정" onClick="userCreate()" class = "btn">
			</div>
		</form><br><br>
		<div style='background:gray; height:1px;'></div>
		<br><br>
		<!-- 목록 3개 -->
		<div style="text-align:center;font-size:24px">목록</div><br><br>
		<div class = "new">
			<div>찜목록</div>
			<div>예약목록</div>
			<div>내가다녀온곳</div>
		</div>
	</div>
</body>
</html>