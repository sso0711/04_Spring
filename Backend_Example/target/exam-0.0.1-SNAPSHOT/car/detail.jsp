<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>차량 상세 정보</title>
<style>
table {
    border-collapse: collapse;
    border: 2px solid black;
    width: 400px;
}
th, td {
    border: 1px solid black;
    padding: 8px;
}
th {
    background-color: #f2f2f2;
    width: 120px;
}
</style>
</head>
<body>
	<%@ include file="/header.jsp"%>
	<h1>차량 상세 정보</h1>
	
	<table>
	    <tr><th>코드</th><td>${car.code}</td></tr>
	    <tr><th>모델</th><td>${car.model}</td></tr>
	    <tr><th>가격</th><td>${car.price}</td></tr>
	    <tr><th>회사</th><td>${car.vendor}</td></tr>
	    <tr><th>사이즈</th><td>${car.size}</td></tr>
	</table>
	
	<br>
	
	<a href="${root}/main?action=modify-form&code=${car.code}">
	    수정하기
	</a>
	
	<a href="${root}/main?action=delete&code=${car.code}">
	    삭제하기
	</a>
	
	<br>
	
	<a href="${root}/main?action=list">
	    목록으로
	</a>

</body>
</html>