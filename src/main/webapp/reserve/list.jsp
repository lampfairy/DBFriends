<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="model.User" %>
<%@page import="model.Product" %>
<%@page import="model.Reservation" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>���� ����Ʈ</title>
	<style type="text/css">
		.list{border:2px solid powderBlue;border-collapse:collapse;}
	</style>
</head>
<body>
	<c:choose>
		<c:when test = "${reserveList == null}">
		<h4>���� ����Ʈ</h4>
			���� ������ ���� �����ϴ�.
		</c:when>
		<c:otherwise>
			<h4>���� ���</h4>
			<form>
				<table class = "list">
					<c:forEach var="reserve" items="${reserveList}">
						<tr>
							<td style="text-align: left; height: 20px; width: 200px"><a
								href="<c:url value='/prod/detail'>
									<c:param name = 'productId' value='${reserve.productId}' />
									</c:url>">${reserve.name}</a></td>
							
							<td style="text-align:left;height:20px;width:130px">
								<a href = "<c:url value='/reserve/detail'>
									<c:param name = 'reservationId' value='${reserve.reservationId}' />
									</c:url>">
								���� �󼼺���</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</form>
		</c:otherwise>
	</c:choose>
</body>
</html>