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
	<title>장소 리스트</title>
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
		등록된 리뷰가 존재하지 않아 TOP10 여행지를 불러올 수 없습니다.
		</c:when>
		<c:otherwise>
			<form>
				<table>
					<tr>
						<td width=50>순위</td>
						<td width=250>사진</td>
						<td width=500>이름 및 위치</td>
						<td width=150>바로가기</td>
					</tr>
					<c:forEach var="prod" items="${prodTOP10List}">
						<tr>
							<td> 1</td>
							<td class = "image"><img src="<c:url value='/upload/${prod.image}'/>" width="250px" height="250px"/></td>
							<td style="text-align:left;">
								이름 : ${prod.name}<br><br>
								가격 : ${prod.price}<br><br>
								위치 : ${prod.location}<br><br>
								아이디 : ${prod.productId}<br><br>
							</td>
							<td>
								<a href = "<c:url value='/prod/detail'>
									<c:param name = 'productId' value='${prod.productId}' />
									</c:url>">
								바로가기</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</form>
		</c:otherwise>
	</c:choose>
	
</body>
</html>