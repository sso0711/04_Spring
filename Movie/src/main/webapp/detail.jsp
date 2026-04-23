<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.ssafy.ws.step2.dto.Movie" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 상세</title>
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

<h1>영화 상세 정보</h1>

<table>
    <tr><th>코드</th><td>${movie.id}</td></tr>
    <tr><th>제목</th><td>${movie.title}</td></tr>
    <tr><th>감독</th><td>${movie.director}</td></tr>
    <tr><th>장르</th><td>${movie.genre}</td></tr>
    <tr><th>상영시간</th><td>${movie.runningTime}</td></tr>
</table>

<br>

<a href="${pageContext.request.contextPath}/movie?action=delete&code=${movie.id}">
    삭제하기
</a>

<br>

<a href="${pageContext.request.contextPath}/movie?action=list">
    목록으로
</a>

</body>
</html>