<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.Product" %>
<%@page import="model.User" %>
<%@page import="java.util.*" %>
<%
	@SuppressWarnings("unchecked") 
	List<Product> prodList = (List<Product>)request.getAttribute("prodList");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>장소 리스트</title>
	<style type="text/css">
		table, td{border:2px solid skyBlue;border-collapse:collapse;}
		table{margin:100px auto 0px auto;text-align:center}
		td{height:40px}
		</style>
</head>
<body>
	<form>
		<table>
			<tr>
				<td width=200>사진</td>
				<td width=600>이름 및 위치</td>
				<td width=200>바로가기</td>
			</tr>
			<c:forEach var="prod" items="${prodList}">
				<tr>
					<td>이미지</td>
					<td>sdfsdf
						<!--이름 : ${prod.name}
						위치 : ${prod.location}
						위치 : ${prod.location}-->
					</td>
					<td>
						sdf
					<td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>