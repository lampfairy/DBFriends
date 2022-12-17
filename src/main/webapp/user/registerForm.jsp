<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ȸ������ ��</title>
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
			alert("�̸��� �Է��Ͻʽÿ�.");
			form.name.focus();
			return false;
		}

		if (form.userId.value == "") {
			alert("����� ID�� �Է��Ͻʽÿ�.");
			form.userId.focus();
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
		}
		else{
			var birthDateExp = /^\d{4}-\d{2}-\d{2}$/;
			if(birthDateExp.test(form.birthDate.value)==false) {
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
		} else{
			var accountNumberExp = /^\d{5,50}$/;
			if(accountNumberExp.test(form.accountNumber.value)==false) {
				alert("���¹�ȣ ������ �ùٸ��� �ʽ��ϴ�.");
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
	<!-- �ΰ�� �޴� -->
	<jsp:include page="../main/menu.jsp" />
	<hr>
	<div class="layout">
		<!-- ȸ������ �� -->
		<form name="form" method="POST"
			action="<c:url value='/user/register' />">
			<!-- ȸ�������� ������ ��� exception ��ü�� ����� ���� �޽����� ��� -->
			<c:if test="${registerFailed}">
				<font color="red"><c:out value="${exception.getMessage()}" /></font>
			</c:if>
			<table>
				<tr>
					<td width="150" align="center">�̸�</td>
					<td width="250" style="padding-left: 10px"><input type="text"
						style="width: 230px;" name="name"
						<c:if test="${registerFailed}">value="${user.name}"</c:if>>
					</td>
				</tr>
				<tr>
					<td width="150" align="center">����� ID</td>
					<td width="250" style="padding-left: 10px"><input type="text"
						style="width: 230px;" name="userId"
						<c:if test="${registerFailed}">value="${user.userId}"</c:if>>
					</td>
				</tr>
				<tr>
					<td width="150" align="center">��й�ȣ</td>
					<td width="250" style="padding-left: 10px"><input
						type="password" style="width: 230px" name="userPw"
						<c:if test="${registerFailed}">value="${user.userPw}"</c:if>>
					</td>
				</tr>
				<tr>
					<td width="150" align="center">��й�ȣ Ȯ��</td>
					<td width="250" style="padding-left: 10px"><input
						type="password" style="width: 230px" name="password2"
						<c:if test="${registerFailed}">value="${user.userPw}"</c:if>>
					</td>
				</tr>
				<tr>
					<td width="150" align="center">��ȭ��ȣ</td>
					<td width="250" style="padding-left: 10px"><input type="text"
						style="width: 230px" name="phoneNumber"
						<c:if test="${registerFailed}">value="${user.phoneNumber}"</c:if>>
					</td>
				</tr>
				<tr>
					<td width="150" align="center">�̸��� �ּ�</td>
					<td width="250" style="padding-left: 10px"><input type="text"
						style="width: 230px" name="emailAddress"
						<c:if test="${registerFailed}">value="${user.emailAddress}"</c:if>>
					</td>
				</tr>
				<tr>
					<td width="150" align="center">�������</td>
					<td width="250" style="padding-left: 10px"><input type="date"
						style="width: 230px" name="birthDate"></td>
				</tr>
				<tr>
					<td width="150" align="center">����</td>
					<td width="250"><input type="radio" name="bankName" value="����"
						<c:if test="${registerFailed}">value="${user.bankName}"</c:if>>����
						<input type="radio" name="bankName" value="����"
						<c:if test="${registerFailed}">value="${user.bankName}"</c:if>>����
						<input type="radio" name="bankName" value="�츮"
						<c:if test="${registerFailed}">value="${user.bankName}"</c:if>>�츮
						<input type="radio" name="bankName" value="����"
						<c:if test="${registerFailed}">value="${user.bankName}"</c:if>>����
					</td>
				</tr>
				<tr>
					<td width="150" align="center">������</td>
					<td width="250" style="padding-left: 10px"><input type="text"
						style="width: 230px" name="nameOnAccount"
						<c:if test="${registerFailed}">value="${user.nameOnAccount}"</c:if>>
					</td>
				</tr>
				<tr>
					<td width="150" align="center">���¹�ȣ</td>
					<td width="250" style="padding-left: 10px"><input type="text"
						style="width: 230px" name="accountNumber"
						<c:if test="${registerFailed}">value="${user.accountNumber}"</c:if>>
					</td>
				</tr>
			</table>
			<br>
			<div class="btnBox">
				<input type="submit" value="ȸ�� ����" onClick="return userCreate()"
					class="btn"> &nbsp;
			</div>
		</form>
	</div>
</body>
</html>