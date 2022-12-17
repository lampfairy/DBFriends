<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>회원가입 폼</title>
<style type="text/css">
.layout {
	margin: 0px auto;
	width: 1180px;
	padding: 10px;
	font-size: 18px
}

table, td {
	border: 2px solid powderBlue;
	border-collapse: collapse;
}

table {
	margin: 100px auto 0px auto
}

td {
	height: 40px
}

.btn {
	text-align: center;
	font-size: 18px;
	border-radius: 10px;
	background-color: powderBlue;
	border: 1px solid black;
	width: 100px;
	height: 30px
}

.btnBox {
	width: 350px;
	height: 30px;
	margin: auto;
	background-color: white;
	text-align: center
}
</style>
<script>
	function userCreate() {
		if (form.name.value == "") {
			alert("이름을 입력하십시오.");
			form.name.focus();
			return false;
		}

		if (form.userId.value == "") {
			alert("사용자 ID를 입력하십시오.");
			form.userId.focus();
			return false;
		}

		if (form.userPw.value == "") {
			alert("비밀번호를 입력하십시오.");
			form.userPw.focus();
			return false;
		}

		if (form.userPw.value != form.password2.value) {
			alert("비밀번호가 일치하지 않습니다.");
			form.password2.focus();
			return false;
		}

		if (form.phoneNumber.value == "") {
			alert("전화번호를 입력하십시오.");
			form.phoneNumber.focus();
			return false;
		} else {
			var phoneExp = /^\d{2,3}\d{3,4}\d{4}$/;
			if (phoneExp.test(form.phoneNumber.value) == false) {
				alert("전화번호 형식이 올바르지 않습니다.");
				form.phoneNumber.focus();
				return false;
			}

		}
		if (form.emailAddress.value == "") {
			alert("이메일을 입력하십시오.");
			form.emailAddress.focus();
			return false;
		} else {
			var emailExp = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
			if (emailExp.test(form.emailAddress.value) == false) {
				alert("이메일 형식이 올바르지 않습니다.");
				form.emailAddress.focus();
				return false;
			}
		}
		if (form.birthDate.value == "") {
			alert("생년월일 입력하십시오.");
			form.birthDate.focus();
			return false;
		}
		else{
			var birthDateExp = /^\d{4}-\d{2}-\d{2}$/;
			if(birthDateExp.test(form.birthDate.value)==false) {
				alert("생년월일 형식이 올바르지 않습니다.");
				form.birthDate.focus();
				return false;
			}
		}
		
		if (form.bankName.value == "") {
			alert("은행명을 선택하십시오.");
			form.bankName.focus();
			return false;
		}
		if (form.nameOnAccount.value == "") {
			alert("예금주명을 입력하십시오.");
			form.nameOnAccount.focus();
			return false;
		} 
		if (form.accountNumber.value == "") {
			alert("계좌번호를 입력하십시오.");
			form.accountNumber.focus();
			return false;
		} else{
			var accountNumberExp = /^\d{5,50}$/;
			if(accountNumberExp.test(form.accountNumber.value)==false) {
				alert("계좌번호 형식이 올바르지 않습니다.");
				form.accountNumber.focus();
				return false;
			}
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
	<jsp:include page="../main/menu.jsp" />
	<hr>
	<div class="layout">
		<!-- 회원가입 폼 -->
		<form name="form" method="POST"
			action="<c:url value='/user/register' />">
			<!-- 회원가입이 실패한 경우 exception 객체에 저장된 오류 메시지를 출력 -->
			<c:if test="${registerFailed}">
				<font color="red"><c:out value="${exception.getMessage()}" /></font>
			</c:if>
			<table>
				<tr>
					<td width="150" align="center">이름</td>
					<td width="250" style="padding-left: 10px"><input type="text"
						style="width: 230px;" name="name"
						<c:if test="${registerFailed}">value="${user.name}"</c:if>>
					</td>
				</tr>
				<tr>
					<td width="150" align="center">사용자 ID</td>
					<td width="250" style="padding-left: 10px"><input type="text"
						style="width: 230px;" name="userId"
						<c:if test="${registerFailed}">value="${user.userId}"</c:if>>
					</td>
				</tr>
				<tr>
					<td width="150" align="center">비밀번호</td>
					<td width="250" style="padding-left: 10px"><input
						type="password" style="width: 230px" name="userPw"
						<c:if test="${registerFailed}">value="${user.userPw}"</c:if>>
					</td>
				</tr>
				<tr>
					<td width="150" align="center">비밀번호 확인</td>
					<td width="250" style="padding-left: 10px"><input
						type="password" style="width: 230px" name="password2"
						<c:if test="${registerFailed}">value="${user.userPw}"</c:if>>
					</td>
				</tr>
				<tr>
					<td width="150" align="center">전화번호</td>
					<td width="250" style="padding-left: 10px"><input type="text"
						style="width: 230px" name="phoneNumber"
						<c:if test="${registerFailed}">value="${user.phoneNumber}"</c:if>>
					</td>
				</tr>
				<tr>
					<td width="150" align="center">이메일 주소</td>
					<td width="250" style="padding-left: 10px"><input type="text"
						style="width: 230px" name="emailAddress"
						<c:if test="${registerFailed}">value="${user.emailAddress}"</c:if>>
					</td>
				</tr>
				<tr>
					<td width="150" align="center">생년월일</td>
					<td width="250" style="padding-left: 10px"><input type="date"
						style="width: 230px" name="birthDate"></td>
				</tr>
				<tr>
					<td width="150" align="center">은행</td>
					<td width="250"><input type="radio" name="bankName" value="국민"
						<c:if test="${registerFailed}">value="${user.bankName}"</c:if>>국민
						<input type="radio" name="bankName" value="농협"
						<c:if test="${registerFailed}">value="${user.bankName}"</c:if>>농협
						<input type="radio" name="bankName" value="우리"
						<c:if test="${registerFailed}">value="${user.bankName}"</c:if>>우리
						<input type="radio" name="bankName" value="신한"
						<c:if test="${registerFailed}">value="${user.bankName}"</c:if>>신한
					</td>
				</tr>
				<tr>
					<td width="150" align="center">예금주</td>
					<td width="250" style="padding-left: 10px"><input type="text"
						style="width: 230px" name="nameOnAccount"
						<c:if test="${registerFailed}">value="${user.nameOnAccount}"</c:if>>
					</td>
				</tr>
				<tr>
					<td width="150" align="center">계좌번호</td>
					<td width="250" style="padding-left: 10px"><input type="text"
						style="width: 230px" name="accountNumber"
						<c:if test="${registerFailed}">value="${user.accountNumber}"</c:if>>
					</td>
				</tr>
			</table>
			<br>
			<div class="btnBox">
				<input type="submit" value="회원 가입" onClick="return userCreate()"
					class="btn"> &nbsp;
			</div>
		</form>
	</div>
</body>
</html>