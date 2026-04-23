<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 관리 메인</title>
<style>
body {
    font-family: Arial, sans-serif;
}

.menu {
    margin-top: 20px;
}

.menu a {
    display: inline-block;
    margin-right: 12px;
    padding: 10px 16px;
    border: 1px solid #333;
    text-decoration: none;
    color: #333;
}
</style>
</head>
<body>
    <h1>도서 관리 메인 페이지</h1>
    <div class="menu">
        <a href="${pageContext.request.contextPath}/book?action=regist-form">등록하기</a>
        <a href="${pageContext.request.contextPath}/book?action=list">목록보기</a>
    </div>
</body>
</html>
