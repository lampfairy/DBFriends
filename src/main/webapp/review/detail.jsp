<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
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
		.btn{margin:20px}
		btn{float:left;display:inline-block;margin:0 30px 0 0}
		.pImage{height:200px;width:200px}
	</style>
</head>
<body>
	<!-- 로고와 메뉴 -->
	<jsp:include page="../main/menu.jsp" /> 
	<hr>
	<div class="layout">
		<!-- 리뷰 상세 폼 -->
		<form>
			<table>
				<caption
					style="text-align: center; font-size: 24px; margin: 0 0 50px 0">리뷰 상세 정보 </caption>
				<tr>
					<td>
					<a href = "<c:url value='/prod/detail'>
						<c:param name = 'productId' value='${prod.productId}' />
						</c:url>">
					장소이름 : ${review.location}</a>
					</td>
				</tr>
				<tr>
					<td>별점 : <input type = "text"></td>
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
						이미지
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