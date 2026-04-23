<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.ssafy.ws.step3.dto.Book" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 목록</title>
<style>
body {
    font-family: Arial, sans-serif;
}

table {
    border-collapse: collapse;
    width: 900px;
}

th, td {
    border: 1px solid #333;
    padding: 8px;
    text-align: center;
}

th {
    background-color: #f0f0f0;
}
</style>
</head>
<body>
    <h1>도서 목록</h1>
    <%
        List<Book> bookList = (List<Book>) request.getAttribute("bookList");
    %>
    <table>
        <tr>
            <th>도서번호</th>
            <th>도서명</th>
            <th>저자</th>
            <th>가격</th>
            <th>설명</th>
        </tr>
        <%
            if (bookList == null || bookList.isEmpty()) {
        %>
        <tr>
            <td colspan="5">등록된 도서가 없습니다.</td>
        </tr>
        <%
            } else {
                for (Book book : bookList) {
        %>
        <tr>
            <td><%= book.getIsbn() %></td>
            <td><%= book.getTitle() %></td>
            <td><%= book.getAuthor() %></td>
            <td><%= book.getPrice() %></td>
            <td><%= book.getDesc() %></td>
        </tr>
        <%
                }
            }
        %>
    </table>

    <p>
        <a href="${pageContext.request.contextPath}/book?action=regist-form">도서 등록</a>
        <a href="${pageContext.request.contextPath}/">메인으로</a>
    </p>
</body>
</html>
