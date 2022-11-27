<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>��� �� ������</title>
</head>
<body>
	<!-- �ΰ�� �޴� -->
	<jsp:include page="menu.jsp" />
	<hr>
	<div class="layout">
		<!-- ȸ������ �� -->
		<form class="table" method="POST"
			action="<c:url value='/user/update' />">
			<!-- ȸ�������� ������ ��� exception ��ü�� ����� ���� �޽����� ��� -->
			<c:if test="${registerFailed}">
				<font color="red"><c:out value="${exception.getMessage()}" /></font>
			</c:if>
			<table>
				<caption
					style="text-align: center; font-size: 24px; margin: 0 0 50px 0">ȸ������</caption>
				<tr>
					<td width="150" align="center">�̸�</td>
					<td width="250" style="padding-left: 10px"><input type="text"
						style="width: 230px;" name="name" value="${user.name}"
						<c:if test="${registerFailed}">value="${user.name}"</c:if>>
					</td>
				</tr>
				<tr>
					<td width="150" align="center">����� ID</td>
					<td width="250" style="padding-left: 10px"><input type="text"
						style="width: 230px;" name="userId" value="${user.userId}"
						readonly></td>
				</tr>
				<tr>
					<td width="150" align="center">��й�ȣ</td>
					<td width="250" style="padding-left: 10px"><input
						type="password" style="width: 230px" name="userPw"
						value="${user.userPw}"></td>
				</tr>
				<tr>
					<td width="150" align="center">��й�ȣ Ȯ��</td>
					<td width="250" style="padding-left: 10px"><input
						type="password" style="width: 230px" name="password2"
						value="${user.userPw}"></td>
				</tr>
				<tr>
					<td width="150" align="center">��ȭ��ȣ</td>
					<td width="250" style="padding-left: 10px"><input type="text"
						style="width: 230px" name="phoneNumber"
						value="${user.phoneNumber}"
						<c:if test="${registerFailed}">value="${user.phoneNumber}"</c:if>>
					</td>
				</tr>
				<tr>
					<td width="150" align="center">�̸��� �ּ�</td>
					<td width="250" style="padding-left: 10px"><input type="text"
						style="width: 230px" name="emailAddress"
						value="${user.emailAddress}"
						<c:if test="${registerFailed}">value="${user.emailAddress}"</c:if>>
					</td>
				</tr>
				<tr>
					<td width="150" align="center">�������</td>
					<td width="250" style="padding-left: 10px"><input type="text"
						style="width: 230px" name="birthDate" value="${user.birthDate}"
						<c:if test="${registerFailed}">value="${user.birthDate}"</c:if>>
					</td>
				</tr>
			</table>
			<br>
			<div class="btnBox">
				<input type="submit" value="����" onClick="userCreate()" class="btn">
			</div>
		</form>
		<br>
		<br>
		<div style='background: gray; height: 1px;'></div>
		<br>
		<br>
		<!-- ��� 3�� -->
		<div style="text-align: center; font-size: 24px">���</div>
		<br>
		<br>
		<div class="new">
			<div>����</div>
			<div>������</div>
			<div>�����ٳ�°�</div>
		</div>


	</div>
</body>
</html>