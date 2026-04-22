<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.ssafy.ws.step2.dto.Movie" %>

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

<%
    List<Movie> list = (List<Movie>) request.getAttribute("list");

    if (list != null && !list.isEmpty()) {
        for (int i = 0; i < list.size(); i++) {
            Movie m = list.get(i);
%>
    <tr>
        <td><%= i + 1 %></td>
        <td><%= m.getTitle() %></td>
        <td><%= m.getDirector() %></td>
        <td><%= m.getGenre() %></td>
        <td><%= m.getRunningTime() %></td>
    </tr>
<%
        }
    } else {
%>
    <tr>
        <td colspan="5">등록된 영화가 없습니다.</td>
    </tr>
<%
    }
%>

</table>

</body>
</html>