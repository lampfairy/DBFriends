<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>�α��� ������</title>
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
				alert("����� ID�� �Է��Ͻʽÿ�.");
				form.userId.focus();
				return false;
			} 
			if (form.password.value == "") {
				alert("��й�ȣ�� �Է��Ͻʽÿ�.");
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
	<!-- �ΰ�� �޴� -->
	<jsp:include page = "../main/menu.jsp"/>
	<hr>
	<div class = "layout">
		<!-- �α��� �� -->
		<form name="form" method="POST" action="<c:url value='/user/login' />">
			<!-- �α����� ������ ��� exception ��ü�� ����� ���� �޽����� ��� -->
	        <c:if test="${loginFailed}">
		  	  <br><font color="red"><c:out value="${exception.getMessage()}" /></font><br>
		    </c:if>
			<table>
				<tr>
					<td width="100" align="center">���̵�</td>
					<td width="250" style="padding-left:10px">
						<input type="text" style="width:230px" name="userId">
					</td>
				</tr>
				<tr>
					<td width="100" align="center">��й�ȣ</td>
					<td width="250" style="padding-left:10px">
						<input type="password" style="width:230px" name="userPw">
					</td>
				</tr>
			</table><br>
			<div class = "btnBox">
				<input type="submit" value="�α���" onClick="login()" class = "btn"> &nbsp;
				<input type="button" value="ȸ������" onClick="userCreate('<c:url value='/user/register/form' />')" class = "btn">
			</div>
		</form>
	</div>
</body>
</html>