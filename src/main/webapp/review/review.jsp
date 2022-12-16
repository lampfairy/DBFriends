<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>리뷰 작성 페이지</title>
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
		<!-- 리뷰 작성 폼 -->
		<form name="form" method="POST" action="<c:url value='/review/insert' />">
			<table>
				<caption
					style="text-align: center; font-size: 24px; margin: 0 0 50px 0">리뷰 작성 폼 </caption>
				<tr>
					<td>예약번호</td>
					<td><input type="text" style="width: 230px" name="reservationId"
						value="${reserve.reservationId}"></td>
				</tr>
				<tr>
					<td width="100px" align="center">제목</td>
					<td style="padding-left:10px">
						<input type="text" style="width:600px" name="title" placeholder="제목 입력창">
					</td>
				</tr>
				<tr>
					<td width="100" align="center">별점</td>
					<td style="padding-left:50px;text-align:left">
						<input type="text" style="width:100px" name="rating" placeholder="0.0-5.0">
					</td>
				</tr>
				<tr>
					<td>리뷰작성자</td>
					<td style="padding-left:50px;text-align:left">${user.name}</td>
				</tr>
				<tr>
					<td>장소ID</td>
					<td><input type="text" style="width: 230px" name="productId"
						value="${product.productId}"></td>
				</tr>
				<tr>
					<td>장소명</td>
					<td><input type="text" style="width: 230px" name="productName"
						value="${product.name}"></td>
				</tr>
				<tr>
					<td>방문일자</td>
					<td style="padding-left:50px;text-align:left">${reserve.startDate} ~ ${reserve.endDate}</td>
				</tr>
				<tr>
					<td colspan = "2">
						<textarea name="content" style="width:740px;height:400px" placeholder="내용 입력창" cols="50" rows="10">
						</textarea>
					</td>
				</tr>
			</table><br>
			<div class = "btnBox">
				<input type="submit" value="등록" class = "btn"> &nbsp;
			</div>
		</form>
	</div>
</body>
</html>