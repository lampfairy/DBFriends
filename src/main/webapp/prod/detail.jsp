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
		table, td{border:2px solid skyBlue;border-collapse:collapse;text-align:center;}
		table{margin:100px auto 0px auto; width:800px}
		td{height:40px}
		.btn{margin:20px}
		a{float:left}
		.image{height:200px;width:200px}
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
					<td colspan="2">${product.name}${user.name}</td>
				</tr>
				<tr>
					<td colspan="2">
						<a href = "<c:url value='/prod/reserve'>
							<c:param name = 'productId' value='${prod.productId}' />
							</c:url>">예약/예매
						</a>
						<a href = "<c:url value='/prod/review'>
							<c:param name = 'productId' value='${prod.productId}' />
							</c:url>">리뷰
						</a>&nbsp;&nbsp;&nbsp;&nbsp;
						<a href = "<c:url value='/prod/bookmark'>
							<c:param name = 'productId' value='${prod.productId}' />
							</c:url>">찜
						</a>
					</td>
				</tr>
				<tr>
					<td class="image">
						이미지
					</td>
					<td>
						장소 설명: ${prod.description}
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>