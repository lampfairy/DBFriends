<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="model.User" %>
<%@page import="model.Product" %>
<%@page import="java.util.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	@SuppressWarnings("unchecked") 
	List<Product> prodList = (List<Product>)request.getAttribute("prodList");
	User user = (User)request.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>����/���� ������</title>
	<style type="text/css">
		body{margin:0}
		.layout{margin:0px auto;width:1180px;padding:10px}
		.search{background-image:ivory;text-align:center}
		select,input{width:240px;height:40px;background-color:skyBlue;
		border-radius: 10px;font-size:18px;text-align:center;}
		.splace{margin-right:150px}
		.sdetail{margin-left:150px}
	</style>
</head>
<body>
	<!-- �ΰ�� �޴� -->
	<jsp:include page = "menu.jsp"/>
	<hr>
	<div class="layout">
		<!-- �˻�â -->
		<div class="search">
			<form class = "sForm" method="POST" action="<c:url value='/prod/list' />">
				<select name="place" class = "splace">
					<option disabled selected>���</option>
					<option value = "1">���ϱ�</option>
					<option value = "2">���α�</option>
					<option value = "3">������</option>
				</select>
				<select name="type">
					<option disabled selected>����/����/��Ƽ��Ƽ</option>
					<option value = "1">����</option>
					<option value = "2">����</option>
					<option value = "3">��Ƽ��Ƽ</option>
				</select>
				<select name="detail" class = "sdetail">
					<option disabled selected>���λ���</option>
					<option value = "1">..</option>
					<option value = "2">...</option>
					<option value = "3">....</option>
				</select><br><br><br><br><br><br><br><br>
				<input type = "submit" value = "�˻�"/>
			</form><br><br>
		</div>
		<!-- ��ǰ ��� -->
			<a href = "<c:url value='/prod/list' />">����</a>
		<table>
			<tr>
				<td width=200>����</td>
				<td width=600>�̸� �� ��ġ</td>
				<td width=200>�ٷΰ���</td>
			</tr>
			<c:forEach var="prod" items="${prodList}">
				<tr>
					<td>�̹���</td>
					<td>sdfsdf
						�̸� : ${prod.name}
						��ġ : ${prod.location}
						��ġ : ${prod.location}
					</td>
					<td>
						sdf
					<td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>