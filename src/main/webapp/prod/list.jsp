<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.Product" %>
<%@page import="java.util.*" %>
<%
	@SuppressWarnings("unchecked") 
	List<Product> prodList = (List<Product>)request.getAttribute("prodList");
    //User user = (User)request.getAttribute("user"); 
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>��� ����Ʈ</title>
	<style type="text/css">
		table, td{border:2px solid skyBlue;border-collapse:collapse;}
		table{margin:100px auto 0px auto;text-align:center}
		td{height:40px}
		</style>
</head>


<body>
<br>
<table style="width:100%">
  <tr><td>&nbsp;</td><td>&nbsp;</td></tr>
  <tr>
	<td width="20"></td>
	<td>
	  <br>		  
	  <table style="background-color: YellowGreen">
		<tr>
		  		<td width=200>����</td>
				<td width=600>�̸� �� ��ġ</td>
		</tr>
<%
// ����: �Ʒ��� ���� scriptlet�� �����ϰ� <c:for-each>�� EL�� �����ϴ� ���� �ٶ����� (list2.jsp ����)
	if (prodList != null) {	
	  Iterator<Product> prodIter = prodList.iterator();
	  
	  //����� ����Ʈ�� Ŭ���̾�Ʈ���� �����ֱ� ���Ͽ� ���.
	  while ( prodIter.hasNext() ) {
		  Product prod = (Product)prodIter.next();
%>		  	
		<tr>
		  <td width="190" align="center" bgcolor="ffffff" height="20">
			sdfsdf
		  </td>
		  
		  <td width="200" align="center" bgcolor="ffffff" height="20">
			  <%=prod.getLocation()%>
		  </td>
		</tr>
<%
	  }
	}
%>	  	
	  </table>	  	 
	  <br> 
	</td>
  </tr>
</table>  
</body>
</html>