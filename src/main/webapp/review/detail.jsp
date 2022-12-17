<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>리뷰 상세 페이지</title>
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
		<!-- 리뷰 상세 정보 -->
		<form name="form" method="POST" action="<c:url value='/main/myPage' />">
			<table>
				<caption
					style="text-align: center; font-size: 24px; margin: 0 0 50px 0">리뷰 상세 정보</caption>
				<tr>
					<td width="100px" align="center">장소</td>
					<td style="padding-left:10px">
						<a href = "<c:url value='/prod/detail'>
							<c:param name = 'productId' value='${review.productId}' />
							</c:url>">${review.productName}
						</a>
					</td>
				</tr>
				<tr>
					<td width="100px" align="center">제목</td>
					<td>${review.title}</td>
				</tr>
				<tr>
					<td colspan="2">
						별점 : ${review.rating}&nbsp;&nbsp;&nbsp;
						작성자 : ${review.userId}&nbsp;&nbsp;&nbsp;
						작성일 : ${review.writeDate}&nbsp;&nbsp;&nbsp;
						장소 방문일 : ${review.startDate}
					</td>
				</tr>
				<tr height="200px">
					<td colspan = "2">
						${review.content}
					</td>
				</tr>
			</table><br>
			<div class = "btnBox">
				<input type="submit" value="이전" class = "btn"> &nbsp;
			</div>
		</form>
	</div>
</body>
</html>