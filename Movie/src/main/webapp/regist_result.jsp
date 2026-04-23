<%@ page import="java.util.List"%>
<%@ page import="com.ssafy.ws.step2.dto.Movie" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>등록 결과</title>

<style>
table {
    border-collapse: collapse;
    border: 2px solid black;
    width: 600px;
}
th, td {
    border: 1px solid black;
    padding: 8px;
    text-align: center;
}
th {
    background-color: #f2f2f2;
}
</style>

</head>
<body>

<h1>영화 등록 결과</h1>

<c:if test="${not empty result}">
    <table>
        <tr><th>항목</th><th>내용</th></tr>
        <tr><th>제목</th><td>${result.title}</td></tr>
        <tr><th>감독</th><td>${result.director}</td></tr>
        <tr><th>장르</th><td>${result.genre}</td></tr>
        <tr><th>상영시간</th><td>${result.runningTime}</td></tr>
    </table>
</c:if>

<c:if test="${empty result}">
    <p>데이터가 없습니다.</p>
</c:if>

<a href="${pageContext.request.contextPath}/movie?action=regist-form">추가등록</a>

</body>
</html>