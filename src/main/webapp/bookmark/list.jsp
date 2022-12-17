<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@page import="model.User"%>
<%@page import="model.Product"%>
<%@page import="model.Bookmark"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>찜 리스트</title>
<style type="text/css">
.list {
	border: 2px solid powderBlue;
	border-collapse: collapse;
}
</style>
</head>
<body>
	<c:choose>
		<c:when test="${bookmarkList == null}">
			현재 찜한 곳이 없습니다.
		</c:when>
		<c:otherwise>
			<h4>찜 리스트</h4>
			<form>
				<table class="list">
					<c:forEach var="bookmark" items="${bookmarkList}">
						<tr>
							<td style="text-align: left; height: 20px; width: 200px"><a
								href="<c:url value='/prod/detail'>
									<c:param name = 'productId' value='${bookmark.productId}' />
									</c:url>">${bookmark.name}</a></td>

							<td style="text-align: left; height: 20px; width: 130px"><a
								onclick="return confirm('삭제하시겠습니까?')" href="<c:url value='/bookmark/delete'>
							<c:param name = 'productId' value='${bookmark.productId}' />
									</c:url>">삭제</a></td>
						</tr>
					</c:forEach>
				</table>
			</form>
		</c:otherwise>
	</c:choose>
</body>
</html>