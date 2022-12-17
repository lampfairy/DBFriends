<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@page import="model.User" %>
<%@page import="model.Product" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>장소 상세 페이지</title>
	<style type="text/css">
		body{margin:0}
		.layout{margin:0px auto;width:1180px;padding:10px}
		table, td{font-size:18px;border:2px solid powderBlue;border-collapse:collapse;text-align:center;}
		table{margin:100px auto 0px auto; width:800px}
		td{height:40px}
		.btn{display:inline-block;margin:0 30px 0 10px;float:left;}
		.pImage{height:200px;width:200px}
	</style>
</head>
<body>
	<!-- 로고와 메뉴 -->
	<jsp:include page="../main/menu.jsp" /> 
	<hr>
	<div class="layout">
		<!-- 장소 상세 폼 -->
		<form>
			<table>
				<caption
					style="text-align: center; font-size: 24px; margin: 0 0 50px 0">장소 상세 정보 </caption>
				<tr>
					<td colspan="2">${product.name}</td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: left;">
						<a onclick="return confirm('해당 여행지를 예약하시겠습니까?')" href = "<c:url value='/prod/reserve'>
							<c:param name = 'productId' value='${product.productId}' />
							</c:url>" class = "btn">예약/예매
						</a>
						<a onclick="return confirm('해당 여행지를 찜 등록하시겠습니까?')" href = "<c:url value='/prod/bookmark'>
							<c:param name = 'productId' value='${product.productId}' />
							</c:url>" class = "btn">찜 
						</a>
						<a href = "<c:url value='/prod/review'>
							<c:param name = 'productId' value='${product.productId}' />
							</c:url>" class = "btn">리뷰
						</a>
						별점 ${product.rating}
					</td>
				</tr>
				<tr>
					<td>위치</td>
					<td>${product.location}</td>
				</tr>
				<tr>
					<td>가격</td>
					<td>${product.price}</td>
				</tr>
				<tr>
					<td class="pImage">
						<img src="<c:url value='/upload/${product.image}'/>" width="330px" height="330px"/>
					</td>
					<td>
						장소 설명: ${product.description}
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>