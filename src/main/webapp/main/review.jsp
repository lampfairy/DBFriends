<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>���� ������</title>
	<style type="text/css">
		body{margin:0}
		.layout{margin:0px auto;width:1180px;padding:10px;text-align:center}
		.new{width:1180px;margin: 0px auto}
		.new div{text-align:center;font-size:18px;width:300px;height:300px;
		background-color:powderBlue;float:left;margin:0px 40px 30px 40px;line-height:300px;border-radius:50%;}
		.key{width:860px;height:40px;background-color:powderBlue;
		border-radius: 10px;font-size:18px;text-align:center;}
		.sub{width:240px;height:40px;background-color:powderBlue;
		border-radius: 10px;font-size:18px;text-align:center;}
	</style>
</head>
<body>
	<!-- �ΰ�� �޴� -->
	<jsp:include page = "menu.jsp"/>
	<hr>
	<div class="layout">
		<br><br>
		<form class = "sForm" method="POST" action="<c:url value='/review/list' />">
			<input type = "text" placeholder="Ű���� �˻�" name = "key" class = "key"/>
			<input type = "submit" value = "�˻�" class = "sub"/>
		</form>
		<!-- ���� ��� -->
		<jsp:include page = "../review/list.jsp"/>
	</div>
</body>
</html>