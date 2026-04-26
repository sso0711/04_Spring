<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <%@ include file="/header.jsp" %>

    <h1>차량 정보 수정</h1>
    <form action="${root}/main" method="post">
        <input type="hidden" name="action" value="modify" />

        <fieldset>
            <label>제품 코드
                <input type="text" name="code" value="${car.code}" readonly>
            </label>
            <br>
            <label>모델
                <input type="text" name="model" value="${car.model}">
            </label>
            <br>
            <label>가격
                <input type="number" name="price" value="${car.price}">만원
            </label>
            <br>
            <label>브랜드
                <input type="text" name="vendor" value="${car.vendor}">
            </label>
            <br>
            <label>차량 크기
                <select name="size">
                    <option value="소형" ${car.size eq '소형' ? 'selected' : ''}>소형</option>
                    <option value="중형" ${car.size eq '중형' ? 'selected' : ''}>중형</option>
                    <option value="대형" ${car.size eq '대형' ? 'selected' : ''}>대형</option>
                </select>
            </label>
            <br>

            <input type="submit" value="수정 완료">
            <a href="${root}/main?action=detail&code=${car.code}">취소</a>
        </fieldset>
    </form>

</body>
</html>
