<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>���� ������</title>
	<style type="text/css">
		body{margin:0}
		.event{margin:10px 0px 0px 0px;background:url('./images/event.jpg');
		width:100%;height:300px}
		.layout{margin:0px auto;width:1180px;padding:10px}
		.search{background-image:ivory;text-align:center}
		select,input{width:240px;height:40px;background-color:powderBlue;
		border-radius: 10px;font-size:18px;text-align:center;}
		.splace{margin-right:150px}
		.sdetail{margin-left:150px}
		.count{width:1180px;margin: 0px auto}
		.count div{text-align:center;font-size:18px;width:150px;height:150px;
		border-radius:50%;background-color:powderBlue;float:left;margin:0px 121px;
		line-height:150px;color:white;font-weight:bolder}
		.count1{background:url('./images/count1.jpg');}
		.count2{background:url('./images/count2.jpg');}
		.count3{background:url('./images/count3.jpg');}
		.new{width:1180px;margin: 0px auto}
		.new div{text-align:center;font-size:18px;width:330px;height:330px;
		background-color:powderBlue;float:left;margin:0px 30px;line-height:330px;}
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
			<form class = "sForm" method="POST" action="<c:url value='/prod/list' />">
				<select name="place" class = "splace">
					<option disabled selected>���</option>
					<option value = "1">����</option>
					<option value = "2">���</option>
					<option value = "3">����</option>
					<option value = "4">��û</option>
					<option value = "5">����</option>
					<option value = "6">���</option>
					<option value = "7">����</option>
				</select>
				<select name="type" id="type" onchange="changeDetail(this)">
					<option disabled selected>����/����/��Ƽ��Ƽ</option>
					<option value = "1">����</option>
					<option value = "2">����</option>
					<option value = "3">��Ƽ��Ƽ</option>
				</select>
				<select id="detail" class = "sdetail" name = "detail">
               		<option disabled selected>���λ���</option>
            	</select>
	            <script>
	               function changeDetail(e){
	                  var food = ["�ѽ�", "�߽�", "�Ͻ�", "���"];
	                  var accom = ["�Խ�Ʈ�Ͽ콺", "�۷���", "���", "ȣ��"];
	                  var activity = ["����ȸ", "���̰���", "������ũ", "����Ƹ���"];
	                  var target = document.getElementById("detail");
	                  
	                  if(e.value == "1") var d = food;
	                  else if(e.value == "2") var d = accom;
	                  else if(e.value == "3") var d = activity;
	                  
	                  target.options.length = 0;
	                  
	                  for(x in d){
	                     var opt = document.createElement("option");
	                     opt.value = d[x];
	                     opt.innerHTML = d[x];
	                     target.appendChild(opt);
	                  }
	               }
	            </script><br><br><br><br><br><br><br><br>
				<input type = "submit" value = "�˻�"/>
			</form>
		</div>
		<!-- �˻� ��� -->
		<jsp:include page = "../prod/list.jsp"/>
		<!-- �����ڶ� --><br><br><br><br>
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