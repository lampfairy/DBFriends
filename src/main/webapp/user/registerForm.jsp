<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>회원가입 폼</title>
	<style type="text/css">
		.layout{margin:0px auto;width:1180px;padding:10px;font-size:18px}
		table, td{border:2px solid powderBlue;border-collapse:collapse;}
		table{margin:100px auto 0px auto}
		td{height:40px}
		.btn{text-align:center;font-size:18px;border-radius:10px;background-color:powderBlue;
		border:1px solid black;width:100px;height:30px}
		.btnBox{width:350px;height:30px;margin:auto;background-color:white;text-align:center}
	</style>
	<script>
		function userCreate() {
			if (form.userId.value == "") {
				alert("사용자 ID를 입력하십시오.");
				form.userId.focus();
				return false;
			} 
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
			<!--var phoneExp = /^\d{2,3}-\d{3,4}-\d{4}$/;
			if(phoneExp.test(form.phone.value)==false) {
				alert("전화번호 형식이 올바르지 않습니다.");
				form.phone.focus();
				return false;
			}-->
			var emailExp = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
			if(emailExp.test(form.email.value)==false) {
				alert("이메일 형식이 올바르지 않습니다.");
				form.email.focus();
				return false;
			}
			form.submit();
		}
		
		function userList(targetUri) {
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
		<!-- 회원가입 폼 -->
		<form name="form" method="POST" action="<c:url value='/user/register' />">
			<!-- 회원가입이 실패한 경우 exception 객체에 저장된 오류 메시지를 출력 -->
	        <c:if test="${registerFailed}">
		      <font color="red"><c:out value="${exception.getMessage()}" /></font>
		    </c:if>
		    <table>
		    	<tr>
					<td width="150" align="center">이름</td>
					<td width="250" style="padding-left:10px">
						<input type="text" style="width:230px;" name="name"
						<c:if test="${registerFailed}">value="${user.name}"</c:if>>
					</td>
			    </tr>
		    	<tr>
				<td width="150" align="center">사용자 ID</td>
				<td width="250" style="padding-left:10px">
					<input type="text" style="width:230px;" name="userId"
					<c:if test="${registerFailed}">value="${user.userId}"</c:if>>
				</td>
			  </tr>
		  	  <tr>
				<td width="150" align="center">비밀번호</td>
				<td width="250" style="padding-left:10px">
					<input type="password" style="width:230px" name="userPw"
					<c:if test="${registerFailed}">value="${user.userPw}"</c:if>>
				</td>
			  </tr>
		  	  <tr>
				<td width="150" align="center">비밀번호 확인</td>
				<td width="250" style="padding-left:10px">
					<input type="password" style="width:230px" name="password2"
					<c:if test="${registerFailed}">value="${user.password2}"</c:if>>
				</td>
			  </tr>
			  <tr>
				<td width="150" align="center">전화번호</td>
				<td width="250" style="padding-left:10px">
					<input type="text" style="width:230px" name="phoneNumber" 
						<c:if test="${registerFailed}">value="${user.phoneNumber}"</c:if>>
				</td>
			  </tr>
		  	  <tr>
				<td width="150" align="center">이메일 주소</td>
				<td width="250" style="padding-left:10px">
					<input type="text" style="width:230px" name="emailAddress" 
						<c:if test="${registerFailed}">value="${user.emailAddress}"</c:if>>
				</td>
			  </tr>
			  <tr>
				<td width="150" align="center">생년월일</td>
				<td width="250" style="padding-left:10px">
					<input type="text" style="width:230px" name="birthDate" placeholder="ex.20130101">
				</td>
			  </tr>
		  	  <tr>
				<td width="150" align="center">은행</td>
				<td width="250">
					<input type="radio" name="bankName" value="kookmin">국민
					<input type="radio" name="bankName" value="nonghyup">농협
					<input type="radio" name="bankName" value="woori">우리
					<input type="radio" name="bankName" value="shinhan">신한
				</td>
			  </tr>
			  <tr>
				<td width="150" align="center">계좌번호</td>
				<td width="250" style="padding-left:10px">
					<input type="text" style="width:230px" name="accountNumber" >
				</td>
			  </tr>
		    </table><br>
			<div class = "btnBox">
				<input type="submit" value="회원 가입" onClick="userCreate()" class = "btn"> &nbsp;
				<input type="button" value="목록" onClick="userList('<c:url value='/user/list' />')" class = "btn">
			</div>
		</form>
	</div>
</body>
</html>