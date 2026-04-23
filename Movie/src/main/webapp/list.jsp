<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.ssafy.ws.step2.dto.Movie" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 목록</title>

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

<h1>영화 목록</h1>

<table>
    <tr>
        <th>번호</th>
        <th>제목</th>
        <th>감독</th>
        <th>장르</th>
        <th>상영시간</th>
    </tr>

    <!-- 리스트 존재할 때 -->
    <c:if test="${not empty list}">
        <c:forEach var="m" items="${list}" varStatus="status">
            <tr>
                <td>
                    <a href="${pageContext.request.contextPath}/movie?action=detail&code=${m.id}">
                        ${m.id}
                    </a>
                </td>
                <td>${m.title}</td>
                <td>${m.director}</td>
                <td>${m.genre}</td>
                <td>${m.runningTime}</td>
            </tr>
        </c:forEach>
    </c:if>

    <!-- 리스트 없을 때 -->
    <c:if test="${empty list}">
        <tr>
            <td colspan="5">등록된 영화가 없습니다.</td>
        </tr>
    </c:if>

</table>

</body>
</html>