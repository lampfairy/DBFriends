<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="model.User" %>
<%@page import="model.Product" %>
<%@page import="java.util.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
   <meta charset="EUC-KR">
   <title>����/���� ������</title>
   <style type="text/css">
      body{margin:0}
      .layout{margin:0px auto;width:1180px;padding:10px}
      .search{background-image:ivory;text-align:center}
      select{width:240px;height:40px;background-color:powderBlue;
      border-radius: 10px;font-size:18px;text-align:center;}
      .splace{margin-right:150px}
      .sdetail{margin-left:150px}
      .key{width:600px;height:40px;background-color:powderBlue;
      border-radius: 10px;font-size:18px;text-align:center;}
      .sub{width:240px;height:40px;background-color:powderBlue;
      border-radius: 10px;font-size:18px;text-align:center;}
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
					<option value = "0" selected>����</option>
					<option value = "0">��ü</option>
					<option value = "1">����</option>
					<option value = "2">���</option>
					<option value = "3">����</option>
					<option value = "4">��û</option>
					<option value = "5">����</option>
					<option value = "6">���</option>
					<option value = "7">����</option>
				</select>
				<select name="type" id="type" onchange="changeDetail(this)">
					<option value = "0" selected>����/����/��Ƽ��Ƽ</option>
					<option value = "0">��ü</option>
					<option value = "1">����</option>
					<option value = "2">����</option>
					<option value = "3">��Ƽ��Ƽ</option>
				</select>
				<select id="detail" class = "sdetail" name = "detail">
               		<option value = "0" selected>���λ���</option>
               		<option value = "0" >��ü</option>
               	</select>
	           <script>
                  function changeDetail(e){
                	 var all = ["��ü"];
                     var food = ["��ü", "�ѽ�", "�߽�", "�Ͻ�", "���"];
                     var accom = ["��ü", "�Խ�Ʈ�Ͽ콺", "�۷���", "���", "ȣ��"];
                     var activity = ["��ü", "����ȸ", "���̰���", "������ũ", "����Ƹ���"];
                     var target = document.getElementById("detail");
                     
                     if(e.value == "0") var d = all;
                     else if(e.value == "1") var d = food;
                     else if(e.value == "2") var d = accom;
                     else if(e.value == "3") var d = activity;
                     
                     target.options.length = 0;
                     
                     for(x in d){
                        var opt = document.createElement("option");
                        opt.value = x;
                        opt.innerHTML = d[x];
                        target.appendChild(opt);
                     }
                  }
               </script><br><br><br><br><br><br><br><br>
            <input type = "text" placeholder="Ű���� �˻�" name = "keySearch" class = "key"/>
            <input type = "submit" value = "�˻�" class = "sub"/>
         </form><br><br>
      </div>
      <!-- ��ǰ ��� -->
      <jsp:include page = "../prod/list.jsp"/>
   </div>
</body>
</html>