<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>���� ������</title>
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
			alert("�̸��� �Է��Ͻʽÿ�.");
			form.name.focus();
			return false;
		}

		if (form.userPw.value == "") {
			alert("��й�ȣ�� �Է��Ͻʽÿ�.");
			form.userPw.focus();
			return false;
		}

		if (form.userPw.value != form.password2.value) {
			alert("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
			form.password2.focus();
			return false;
		}

		if (form.phoneNumber.value == "") {
			alert("��ȭ��ȣ�� �Է��Ͻʽÿ�.");
			form.phoneNumber.focus();
			return false;
		} else {
			var phoneExp = /^\d{2,3}\d{3,4}\d{4}$/;
			if (phoneExp.test(form.phoneNumber.value) == false) {
				alert("��ȭ��ȣ ������ �ùٸ��� �ʽ��ϴ�.");
				form.phoneNumber.focus();
				return false;
			}

		}
		if (form.emailAddress.value == "") {
			alert("�̸����� �Է��Ͻʽÿ�.");
			form.emailAddress.focus();
			return false;
		} else {
			var emailExp = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
			if (emailExp.test(form.emailAddress.value) == false) {
				alert("�̸��� ������ �ùٸ��� �ʽ��ϴ�.");
				form.emailAddress.focus();
				return false;
			}
		}
		if (form.birthDate.value == "") {
			alert("������� �Է��Ͻʽÿ�.");
			form.birthDate.focus();
			return false;
		} else {
			var birthDateExp = /^\d{4}-\d{2}-\d{2}$/;
			if (birthDateExp.test(form.birthDate.value) == false) {
				alert("������� ������ �ùٸ��� �ʽ��ϴ�.");
				form.birthDate.focus();
				return false;
			}
		}
		if (form.bankName.value == "") {
			alert("������� �����Ͻʽÿ�.");
			form.bankName.focus();
			return false;
		}
		if (form.nameOnAccount.value == "") {
			alert("�����ָ��� �Է��Ͻʽÿ�.");
			form.nameOnAccount.focus();
			return false;
		}
		if (form.accountNumber.value == "") {
			alert("���¹�ȣ�� �Է��Ͻʽÿ�.");
			form.accountNumber.focus();
			return false;
		} else {
			var accountNumberExp = /^\d{5,50}$/;
			if (accountNumberExp.test(form.accountNumber.value) == false) {
				alert("���¹�ȣ ������ �ùٸ��� �ʽ��ϴ�.");
				form.accountNumber.focus();
				return false;
			}
		}

		form.submit();
	}
</script>
</head>
<body>
	<!-- �ΰ�� �޴� -->
	<jsp:include page="menu.jsp" />
	<hr>
	<div class="layout">
		<!-- ȸ������ �� -->
		<form class="form" method="POST"
			action="<c:url value='/user/update' />">
			<!-- ȸ�������� ������ ��� exception ��ü�� ����� ���� �޽����� ��� -->
			<c:if test="${updateFailed}">
				<font color="red"><c:out value="${exception.getMessage()}" /></font>
			</c:if>
			<table class="table">
				<caption
					style="text-align: center; font-size: 24px; margin: 0 0 50px 0">ȸ������</caption>
				<tr>
					<td width="150" align="center">�̸�</td>
					<td width="250" style="padding-left: 10px"><input type="text"
						style="width: 230px;" name="name" value="${user.name}"
						<c:if test="${updateFailed}">value="${user.name}"</c:if>>
					</td>
				</tr>
				<tr>
					<td width="150" align="center">���̵�</td>
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
						<c:if test="${updateFailed}">value="${user.phoneNumber}"</c:if>>
					</td>
				</tr>
				<tr>
					<td width="150" align="center">�̸��� �ּ�</td>
					<td width="250" style="padding-left: 10px"><input type="text"
						style="width: 230px" name="emailAddress"
						value="${user.emailAddress}"
						<c:if test="${updateFailed}">value="${user.emailAddress}"</c:if>>
					</td>
				</tr>
				<tr>
					<td width="150" align="center">�������</td>
					<td width="250" style="padding-left: 10px"><input type="date"
						style="width: 230px" name="birthDate" value="${user.birthDate}"
						<c:if test="${updateFailed}">value="${user.birthDate}"</c:if>>
					</td>
				</tr>
				<tr>
					<td width="150" align="center">�����</td>
					<td width="250" style="padding-left: 10px"><input type="text"
						style="width: 230px" name="bankName" value="${user.bankName}"
						placeholder="����/����/�츮/���� �߿� �Է��ϼ���."
						<c:if test="${updateFailed}">value="${user.bankName}"</c:if>>
					</td>
				</tr>
				<tr>
					<td width="150" align="center">������</td>
					<td width="250" style="padding-left: 10px"><input type="text"
						style="width: 230px" name="nameOnAccount"
						value="${user.nameOnAccount}"
						<c:if test="${updateFailed}">value="${user.nameOnAccount}"</c:if>>
					</td>
				</tr>
				<tr>
					<td width="150" align="center">���¹�ȣ</td>
					<td width="250" style="padding-left: 10px"><input type="text"
						style="width: 230px" name="accountNumber"
						value="${user.accountNumber}"
						<c:if test="${updateFailed}">value="${user.accountNumber}"</c:if>>
					</td>

				</tr>
			</table>
			<br>
			<div class="btnBox">
				<input type="submit" value="����" onClick="return userUpdate()"
					class="btn">
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