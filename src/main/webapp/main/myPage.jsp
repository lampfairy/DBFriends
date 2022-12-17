<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>마이 페이지</title>
<style type="text/css">
.layout {
	margin: 0px auto;
	width: 1180px;
	padding: 10px;
	font-size: 18px
}

.table, td {
	border: 2px solid powderBlue;
	border-collapse: collapse;
}

.table {
	margin: 50px auto 0px auto
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

.new {
	width: 1180px;
	margin: 0px auto
}

.new div {
	overflow: scroll;
	text-align: center;
	font-size: 18px;
	width: 330px;
	height: 330px;
	border: 2px solid powderBlue;
	float: left;
	margin: 0px 28px;
}
</style>
<script>
	function userUpdate() {
		if (form.name.value == "") {
			alert("이름을 입력하십시오.");
			form.name.focus();
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
		} else {
			var birthDateExp = /^\d{4}-\d{2}-\d{2}$/;
			if (birthDateExp.test(form.birthDate.value) == false) {
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
		} else {
			var accountNumberExp = /^\d{5,50}$/;
			if (accountNumberExp.test(form.accountNumber.value) == false) {
				alert("계좌번호 형식이 올바르지 않습니다.");
				form.accountNumber.focus();
				return false;
			}
		}

		form.submit();
	}
</script>
</head>
<body>
	<!-- 로고와 메뉴 -->
	<jsp:include page="menu.jsp" />
	<hr>
	<div class="layout">
		<!-- 회원정보 폼 -->
		<form class="form" method="POST"
			action="<c:url value='/user/update' />">
			<!-- 회원가입이 실패한 경우 exception 객체에 저장된 오류 메시지를 출력 -->
			<c:if test="${updateFailed}">
				<font color="red"><c:out value="${exception.getMessage()}" /></font>
			</c:if>
			<table class="table">
				<caption
					style="text-align: center; font-size: 24px; margin: 0 0 50px 0">회원정보</caption>
				<tr>
					<td width="150" align="center">이름</td>
					<td width="250" style="padding-left: 10px"><input type="text"
						style="width: 230px;" name="name" value="${user.name}"
						<c:if test="${updateFailed}">value="${user.name}"</c:if>>
					</td>
				</tr>
				<tr>
					<td width="150" align="center">아이디</td>
					<td width="250" style="padding-left: 10px"><input type="text"
						style="width: 230px;" name="userId" value="${user.userId}"
						readonly></td>
				</tr>
				<tr>
					<td width="150" align="center">비밀번호</td>
					<td width="250" style="padding-left: 10px"><input
						type="password" style="width: 230px" name="userPw"
						value="${user.userPw}"></td>
				</tr>
				<tr>
					<td width="150" align="center">비밀번호 확인</td>
					<td width="250" style="padding-left: 10px"><input
						type="password" style="width: 230px" name="password2"
						value="${user.userPw}"></td>
				</tr>
				<tr>
					<td width="150" align="center">전화번호</td>
					<td width="250" style="padding-left: 10px"><input type="text"
						style="width: 230px" name="phoneNumber"
						value="${user.phoneNumber}"
						<c:if test="${updateFailed}">value="${user.phoneNumber}"</c:if>>
					</td>
				</tr>
				<tr>
					<td width="150" align="center">이메일 주소</td>
					<td width="250" style="padding-left: 10px"><input type="text"
						style="width: 230px" name="emailAddress"
						value="${user.emailAddress}"
						<c:if test="${updateFailed}">value="${user.emailAddress}"</c:if>>
					</td>
				</tr>
				<tr>
					<td width="150" align="center">생년월일</td>
					<td width="250" style="padding-left: 10px"><input type="date"
						style="width: 230px" name="birthDate" value="${user.birthDate}"
						<c:if test="${updateFailed}">value="${user.birthDate}"</c:if>>
					</td>
				</tr>
				<tr>
					<td width="150" align="center">은행명</td>
					<td width="250" style="padding-left: 10px"><input type="text"
						style="width: 230px" name="bankName" value="${user.bankName}"
						placeholder="국민/농협/우리/신한 중에 입력하세요."
						<c:if test="${updateFailed}">value="${user.bankName}"</c:if>>
					</td>
				</tr>
				<tr>
					<td width="150" align="center">예금주</td>
					<td width="250" style="padding-left: 10px"><input type="text"
						style="width: 230px" name="nameOnAccount"
						value="${user.nameOnAccount}"
						<c:if test="${updateFailed}">value="${user.nameOnAccount}"</c:if>>
					</td>
				</tr>
				<tr>
					<td width="150" align="center">계좌번호</td>
					<td width="250" style="padding-left: 10px"><input type="text"
						style="width: 230px" name="accountNumber"
						value="${user.accountNumber}"
						<c:if test="${updateFailed}">value="${user.accountNumber}"</c:if>>
					</td>

				</tr>
			</table>
			<br>
			<div class="btnBox">
				<input type="submit" value="수정" onClick="return userUpdate()"
					class="btn">
			</div>
		</form>
		<br>
		<br>
		<div style='background: gray; height: 1px;'></div>
		<br>
		<br>
		<!-- 목록 3개 -->
		<div style="text-align: center; font-size: 24px">목록</div>
		<br>
		<br>
		<div class="new">
			<div>
				<jsp:include page="../bookmark/list.jsp" />
			</div>
			<div>
				<jsp:include page="../reserve/list.jsp" />
			</div>
			<div>
				<jsp:include page="../reserve/visitedList.jsp" />
			</div>
		</div>
	</div>
</body>
</html>