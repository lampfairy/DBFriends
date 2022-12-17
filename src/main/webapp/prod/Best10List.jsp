<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="model.User" %>
<%@page import="model.Product" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>��� ����Ʈ</title>
	<style type="text/css">
		table, td{border:2px solid powderBlue;border-collapse:collapse;}
		table{margin:100px auto 0px auto;text-align:center}
		td{height:40px}
		.image{height:150px}
	</style>
</head>
<body>
	<c:choose>
		<c:when test = "${prodTOP10List == null}">
		��ϵ� ���䰡 �������� �ʾ� TOP10 �������� �ҷ��� �� �����ϴ�.
		</c:when>
		<c:otherwise>
			<form>
				<table>
					<tr>
						<td width=50>����</td>
						<td width=250>����</td>
						<td width=500>�̸� �� ��ġ</td>
						<td width=150>�ٷΰ���</td>
					</tr>
					<c:forEach var="prod" items="${prodTOP10List}">
						<tr>
							<td> 1</td>
							<td class = "image"><img src="<c:url value='/upload/${prod.image}'/>" width="250px" height="250px"/></td>
							<td style="text-align:left;">
								�̸� : ${prod.name}<br><br>
								���� : ${prod.price}<br><br>
								��ġ : ${prod.location}<br><br>
								���̵� : ${prod.productId}<br><br>
							</td>
							<td>
								<a href = "<c:url value='/prod/detail'>
									<c:param name = 'productId' value='${prod.productId}' />
									</c:url>">
								�ٷΰ���</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</form>
		</c:otherwise>
	</c:choose>
	
</body>
</html>