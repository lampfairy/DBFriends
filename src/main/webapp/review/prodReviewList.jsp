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
	<title>해당 장소 리뷰 리스트</title>
	<style type="text/css">
		body{margin:0}
		.layout{margin:0px auto;width:1180px;padding:10px}
		table, td{border:2px solid powderBlue;border-collapse:collapse;text-align:center;}
		table{margin:100px auto 0px auto; width:800px}
		td{height:40px}
		.btn{text-align:center;font-size:18px;border-radius:10px;background-color:powderBlue;
		border:1px solid black;width:100px;height:30px}
		.btnBox{width:350px;height:30px;margin:auto;background-color:white;text-align:center}
	
	</style>
</head>
<body>
	<!-- 로고와 메뉴 -->
	<jsp:include page="../main/menu.jsp" /> 
	<hr>
	<div class="layout">
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
								<td style="text-align:left;">${review.productName}</td>
								<td style="text-align:left;">${review.title}</td>
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
	</div>
</body>
</html>