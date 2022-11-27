<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>���� ������</title>
	<style type="text/css">
		body{margin:0}
		.event{margin:10px 0px 0px 0px;background-color:skyBlue;
		width:100%;height:300px}
		.layout{margin:0px auto;width:1180px;padding:10px}
		.search{background-image:ivory;text-align:center}
		select,input{width:240px;height:40px;background-color:skyBlue;
		border-radius: 10px;font-size:18px;text-align:center;}
		.splace{margin-right:150px}
		.sdetail{margin-left:150px}
		.count{width:1180px;margin: 0px auto}
		.count div{text-align:center;font-size:18px;width:150px;height:150px;
		border-radius:50%;background-color:skyBlue;float:left;margin:0px 121px;
		line-height:150px;color:white;font-weight:bolder}
		.count1{background:url('./images/count1.jpg');}
		.count2{background:url('./images/count2.jpg');}
		.count3{background:url('./images/count3.jpg');}
		.new{width:1180px;margin: 0px auto}
		.new div{text-align:center;font-size:18px;width:330px;height:330px;
		background-color:skyBlue;float:left;margin:0px 30px;line-height:330px;}
	</style>
</head>
<body>
	<!-- �ΰ�� �޴� -->
	<jsp:include page = "menu.jsp"/>
	<!-- �̺�Ʈ ��� -->
	<div class="event">
	</div>
	<div class="layout">
		<!-- �˻�â -->
		<div class="search">
			<form class = "sForm">
				<select name="place" class = "splace">
					<option disabled selected>���</option>
					<option value = "1">���ϱ�</option>
					<option value = "2">���α�</option>
					<option value = "3">������</option>
				</select>
				<select name="type">
					<option disabled selected>����/����/��Ƽ��Ƽ</option>
					<option value = "1">����</option>
					<option value = "2">����</option>
					<option value = "3">��Ƽ��Ƽ</option>
				</select>
				<select name="detail" class = "sdetail">
					<option disabled selected>���λ���</option>
					<option value = "1">..</option>
					<option value = "2">...</option>
					<option value = "3">....</option>
				</select><br><br><br><br><br><br><br><br>
				<input type = "submit" value = "�˻�"/>
					<a href = "<c:url value='/prod/list'>
						<c:param name = 'type' value='${type}' />
							</c:url>">
						�˻�</a>
			</form><br><br><br><br>
		</div>
		<!-- �����ڶ� -->
		<div style="text-align:center;font-size:24px">���� �� �α� ������</div><br><br>
		<div class = "count">
			<div class = "count2">����&nbsp; ${restaurant}��</div>
			<div class = "count1">����&nbsp; ${activity}��</div>
			<div class = "count3">��Ƽ��Ƽ&nbsp; ${accommodation}��</div>
		</div><br><br><br><br><br><br><br><br><br><br><br><br>
		<!-- �űԿ����� 3�� -->
		<div style="text-align:center;font-size:24px">�ű� ������</div><br><br>
		<div class = "new">
			<div>�ű� ������</div>
			<div>�ű� ������</div>
			<div>�ű� ������</div>
		</div>
	</div>
</body>
</html>