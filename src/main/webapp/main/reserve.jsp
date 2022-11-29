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
   <title>예약/예매 페이지</title>
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
	<!-- 로고와 메뉴 -->
	<jsp:include page = "menu.jsp"/>
	<!-- 이벤트 배너 -->
	<div class="event">
	</div>
	<div class="layout">
		<!-- 검색창 -->
		<div class="search">
			<form class = "sForm" method="POST" action="<c:url value='/prod/list' />">
				<select name="place" class = "splace">
					<option value = "0" selected>지역</option>
					<option value = "0">전체</option>
					<option value = "1">서울</option>
					<option value = "2">경기</option>
					<option value = "3">강원</option>
					<option value = "4">충청</option>
					<option value = "5">전라</option>
					<option value = "6">경상</option>
					<option value = "7">제주</option>
				</select>
				<select name="type" id="type" onchange="changeDetail(this)">
					<option value = "0" selected>맛집/숙소/액티비티</option>
					<option value = "0">전체</option>
					<option value = "1">맛집</option>
					<option value = "2">숙소</option>
					<option value = "3">액티비티</option>
				</select>
				<select id="detail" class = "sdetail" name = "detail">
               		<option value = "0" selected>세부사항</option>
               		<option value = "0" >전체</option>
               	</select>
	           <script>
                  function changeDetail(e){
                	 var all = ["전체"];
                     var food = ["전체", "한식", "중식", "일식", "양식"];
                     var accom = ["전체", "게스트하우스", "글램핑", "펜션", "호텔"];
                     var activity = ["전체", "전시회", "놀이공원", "워터파크", "아쿠아리움"];
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
            <input type = "text" placeholder="키워드 검색" name = "keySearch" class = "key"/>
            <input type = "submit" value = "검색" class = "sub"/>
         </form><br><br>
      </div>
      <!-- 상품 목록 -->
      <jsp:include page = "../prod/list.jsp"/>
   </div>
</body>
</html>