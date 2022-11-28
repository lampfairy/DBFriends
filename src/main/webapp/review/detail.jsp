<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>���� �� ������</title>
	<style type="text/css">
		body{margin:0}
		.layout{margin:0px auto;width:1180px;padding:10px}
		table, td{border:2px solid skyBlue;border-collapse:collapse;text-align:center;}
		table{margin:100px auto 0px auto; width:800px}
		td{height:40px}
		.btn{margin:20px}
		btn{float:left;display:inline-block;margin:0 30px 0 0}
		.pImage{height:200px;width:200px}
	</style>
</head>
<body>
	<!-- �ΰ�� �޴� -->
	<jsp:include page="../main/menu.jsp" /> 
	<hr>
	<div class="layout">
		<!-- ���� �� �� -->
		<form>
			<table>
				<caption
					style="text-align: center; font-size: 24px; margin: 0 0 50px 0">���� �� ���� </caption>
				<tr>
					<td colspan="2">����̸� : </td>
				</tr>
				<tr>
					<td colspan="2">
						<a href = "<c:url value='/prod/reserve'>
							<c:param name = 'productId' value='${product.productId}' />
							</c:url>" class = "btn">����/����
						</a>
						<a href = "<c:url value='/prod/review'>
							<c:param name = 'productId' value='${product.productId}' />
							</c:url>" class = "btn">����
						</a>
						<a href = "<c:url value='/prod/bookmark'>
							<c:param name = 'productId' value='${product.productId}' />
							</c:url>" class = "btn">��
						</a>
					</td>
				</tr>
				<tr>
					<td>��ġ</td>
					<td>${product.location}</td>
				</tr>
				<tr>
					<td>����</td>
					<td>${product.price}</td>
				</tr>
				<tr>
					<td class="pImage">
						�̹���
					</td>
					<td>
						��� ����: ${product.description}
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>