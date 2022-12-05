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
</head>
<body>
	<c:choose>
		<c:when test = "${reserveList == null}">
		</c:when>
		<c:otherwise>
			<form>
				<table>
					<c:forEach var="reserve" items="${reserveList}">
						<tr>
							<td style="text-align:left;">
								${reserve.name}<br><br>
							</td>
							<td>
								<a href = "<c:url value='/reserve/detail'>
									<c:param name = 'productId' value='${reserve.productId}' />
									</c:url>">
								예약보기</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</form>
		</c:otherwise>
	</c:choose>
</body>
</html>