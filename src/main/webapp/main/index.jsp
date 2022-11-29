<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>메인 페이지</title>
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
					<option disabled selected>장소</option>
					<option value = "1">서울</option>
					<option value = "2">경기</option>
					<option value = "3">강원</option>
					<option value = "4">충청</option>
					<option value = "5">전라</option>
					<option value = "6">경상</option>
					<option value = "7">제주</option>
				</select>
				<select name="type" id="type" onchange="changeDetail(this)">
					<option disabled selected>맛집/숙소/액티비티</option>
					<option value = "1">맛집</option>
					<option value = "2">숙소</option>
					<option value = "3">액티비티</option>
				</select>
				<select id="detail" class = "sdetail" name = "detail">
               		<option disabled selected>세부사항</option>
            	</select>
	            <script>
	               function changeDetail(e){
	                  var food = ["한식", "중식", "일식", "양식"];
	                  var accom = ["게스트하우스", "글램핑", "펜션", "호텔"];
	                  var activity = ["전시회", "놀이공원", "워터파크", "아쿠아리움"];
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
				<input type = "submit" value = "검색"/>
			</form>
		</div>
		<!-- 검색 결과 -->
		<jsp:include page = "../prod/list.jsp"/>
		<!-- 개수자랑 --><br><br><br><br>
		<div style="text-align:center;font-size:24px">서울 내 인기 여행지</div><br><br>
		<div class = "count">
			<div class = "count2">맛집&nbsp; ${restaurant}개</div>
			<div class = "count1">숙소&nbsp; ${activity}개</div>
			<div class = "count3">액티비티&nbsp; ${accommodation}개</div>
		</div><br><br><br><br><br><br><br><br><br><br><br><br>
		<!-- 신규여행지 3개 -->
		<div style="text-align:center;font-size:24px">신규 여행지</div><br><br>
		<div class = "new">
			<div>신규 여행지</div>
			<div>신규 여행지</div>
			<div>신규 여행지</div>
		</div>
	</div>
</body>
</html>