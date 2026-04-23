<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 등록 결과</title>
<style>
body {
    font-family: Arial, sans-serif;
}

table {
    border-collapse: collapse;
    width: 600px;
}

th, td {
    border: 1px solid #333;
    padding: 8px;
}

th {
    background-color: #f0f0f0;
    width: 120px;
}
</style>
</head>
<body>
    <h1>도서 등록 결과</h1>
    <table>
        <tr>
            <th>도서번호</th>
            <td>${book.isbn}</td>
        </tr>
        <tr>
            <th>도서명</th>
            <td>${book.title}</td>
        </tr>
        <tr>
            <th>저자</th>
            <td>${book.author}</td>
        </tr>
        <tr>
            <th>가격</th>
            <td>${book.price}</td>
        </tr>
        <tr>
            <th>설명</th>
            <td>${book.desc}</td>
        </tr>
    </table>

    <p>
        <a href="${pageContext.request.contextPath}/book?action=regist-form">추가 등록</a>
        <a href="${pageContext.request.contextPath}/book?action=list">목록 보기</a>
    </p>
</body>
</html>
