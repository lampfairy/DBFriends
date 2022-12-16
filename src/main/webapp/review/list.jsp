<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="model.User" %>
<%@page import="model.Product" %>
<%@page import="model.Review" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>리뷰 리스트</title>
	<style type="text/css">
		table, td{border:2px solid powderBlue;border-collapse:collapse;}
		table{margin:100px auto 0px auto;text-align:center}
		td{height:40px}
	</style>
</head>
<body>
	<c:choose>
		<c:when test = "${reviewList == null}">
		</c:when>
		<c:otherwise>
			<form>
				<table>
					<tr>
						<td colspan = "3">검색 결과</td>
					</tr>
					<tr>
						<td width=300>장소</td>
						<td width=700>리뷰 제목</td>
						<td width=200>리뷰 보기</td>
					</tr>
					<c:forEach var="review" items="${reviewList}">
						<tr>
							<td style="text-align:left;">장소명</td>
							<td style="text-align:left;">${review.title}<td>
							<td>
								<a href = "<c:url value='/review/detail'>
									<c:param name = 'reservationId' value='${review.reservationId}' />
									</c:url>">
								리뷰 보기</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</form>
	</c:otherwise>
	</c:choose>
</body>
</html>