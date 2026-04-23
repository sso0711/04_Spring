<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 등록</title>
<style>
body {
    font-family: Arial, sans-serif;
}

label {
    display: inline-block;
    width: 90px;
    margin-bottom: 10px;
}

textarea {
    width: 320px;
    height: 120px;
}
</style>
</head>
<body>
    <h1>SSAFY 도서 관리</h1>
    <form method="post" action="${pageContext.request.contextPath}/book">
        <fieldset>
            <legend>도서 정보 입력</legend>
            <input type="hidden" name="action" value="regist">

            <label for="isbn">도서번호</label>
            <input type="text" id="isbn" name="isbn" required><br>

            <label for="title">도서명</label>
            <input type="text" id="title" name="title" required><br>

            <label for="author">저자</label>
            <input type="text" id="author" name="author" required><br>

            <label for="price">가격</label>
            <input type="number" id="price" name="price" required><br>

            <label for="desc">설명</label><br>
            <textarea id="desc" name="desc"></textarea><br>

            <input type="submit" value="등록">
            <input type="reset" value="초기화">
        </fieldset>
    </form>
</body>
</html>
