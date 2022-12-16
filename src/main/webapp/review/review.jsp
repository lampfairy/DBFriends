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
		<!-- 리뷰 작성 폼 -->
		<form>
			<table>
				<caption
					style="text-align: center; font-size: 24px; margin: 0 0 50px 0">리뷰 작성 폼 </caption>
				<tr>
					<td width="100" align="center">제목</td>
					<td width="250" style="padding-left:10px">
						<input type="text" style="width:230px" name="title" placeholder="제목 입력창">
					</td>
				</tr>
				<tr>
					<td width="100" align="center">별점</td>
					<td width="100" style="padding-left:10px">
						<input type="text" style="width:230px" name="title" placeholder="0-5">
					</td>
				</tr>
				<tr>
					<td><input type="text" style="width:360px" name="content" placeholder="내용 입력창"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>