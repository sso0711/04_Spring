<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>목록 조회 페이지</title>
<style type="text/css">
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}
</style>
</head>
<body>
	<%@ include file="/header.jsp"%>
	<h1>목록 조회 페이지</h1>

	<a href="${root}/main">메인 화면으로</a>
	<a href="${root}/main?action=regist-form">등록하기</a>
	<table>
		<thead>
			<tr>
				<th>제품 코드</th>
				<th>모델</th>
				<th>가격</th>
			</tr>
		</thead>
		<tbody>
			<%
				java.util.List<com.ssafy.exam.model.dto.Car> list =
						(java.util.List<com.ssafy.exam.model.dto.Car>) request.getAttribute("list");
				if (list != null) {
					for (com.ssafy.exam.model.dto.Car item : list) {
			%>
						<tr>
							<td><a href="${root}/main?action=detail&code=<%= item.getCode() %>"><%= item.getCode() %></a></td>
							<td><%= item.getModel() %></td>
							<td><%= item.getPrice() %>만원</td>
						</tr>
			<%
					}
				}
			%>
                
		</tbody>
	</table>
</body>
</html>
