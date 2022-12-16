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
	<title>예약 리스트</title>
	<style type="text/css">
		.list{border:2px solid powderBlue;border-collapse:collapse;}
	</style>
</head>
<body>
	<c:choose>
		<c:when test = "${visitedList == null}">
		<h4>다녀온 곳 리스트</h4>
			현재 다녀온 곳이 없습니다.
		</c:when>
		<c:otherwise>
			<h4>다녀온 곳 리스트</h4>
			<form>
				<table class = "list">
					<c:forEach var="reserve" items="${visitedList}">
						<tr>
							<td style="text-align: left; height: 20px; width: 200px"><a
								href="<c:url value='/prod/detail'>
									<c:param name = 'productId' value='${reserve.productId}' />
									</c:url>">${reserve.name}</a></td>
							
							<td style="text-align:left;height:20px;width:130px">
								<a href = "<c:url value='/review/review'>
									<c:param name = 'reservationId' value='${reserve.reservationId}' />
									</c:url>">
								리뷰 작성하기</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</form>
		</c:otherwise>
	</c:choose>
</body>
</html>