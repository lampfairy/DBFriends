<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>장소 상세 페이지</title>
</head>
<body>
	<!-- 로고와 메뉴 -->
	<jsp:include page="menu.jsp" />
	<hr>
	<div class="layout">
		<!-- 회원정보 폼 -->
		<form class="table" method="POST"
			action="<c:url value='/user/update' />">
			<!-- 회원가입이 실패한 경우 exception 객체에 저장된 오류 메시지를 출력 -->
			<c:if test="${registerFailed}">
				<font color="red"><c:out value="${exception.getMessage()}" /></font>
			</c:if>
			<table>
				<caption
					style="text-align: center; font-size: 24px; margin: 0 0 50px 0">회원정보</caption>
				<tr>
					<td width="150" align="center">이름</td>
					<td width="250" style="padding-left: 10px"><input type="text"
						style="width: 230px;" name="name" value="${user.name}"
						<c:if test="${registerFailed}">value="${user.name}"</c:if>>
					</td>
				</tr>
				<tr>
					<td width="150" align="center">사용자 ID</td>
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
						<c:if test="${registerFailed}">value="${user.phoneNumber}"</c:if>>
					</td>
				</tr>
				<tr>
					<td width="150" align="center">이메일 주소</td>
					<td width="250" style="padding-left: 10px"><input type="text"
						style="width: 230px" name="emailAddress"
						value="${user.emailAddress}"
						<c:if test="${registerFailed}">value="${user.emailAddress}"</c:if>>
					</td>
				</tr>
				<tr>
					<td width="150" align="center">생년월일</td>
					<td width="250" style="padding-left: 10px"><input type="text"
						style="width: 230px" name="birthDate" value="${user.birthDate}"
						<c:if test="${registerFailed}">value="${user.birthDate}"</c:if>>
					</td>
				</tr>
			</table>
			<br>
			<div class="btnBox">
				<input type="submit" value="수정" onClick="userCreate()" class="btn">
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
			<div>찜목록</div>
			<div>예약목록</div>
			<div>내가다녀온곳</div>
		</div>


	</div>
</body>
</html>