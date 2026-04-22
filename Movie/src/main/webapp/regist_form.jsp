<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 등록</title>
<style>
    label {
        display: inline-block;
        width: 100px;
    }
</style>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" />
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>

<body>
	<h1>SSAFY 영화 관리</h1>
	
	<%
    // 페이지의 루트 경로를 구한다.
    String root = request.getContextPath();
    %>
	
	<div>
		<fieldset>
		<legend>영화 정보 입력</legend>
		<form action="<%=root %>/main">
			<input type="hidden" name="action" value="regist">
		
		    <label>제목</label>
		    <input type="text" name="title"><br>
		
		    <label>감독</label>
		    <input type="text" name="director"><br>
		
		    <label>장르</label>
		    <input type="text" name="genre"><br>
		
		    <label>상영시간</label>
		    <input type="number" name="runningTime"><br>
		
		    <input type="submit" value="등록">
		    <input type="reset" value="초기화">
		</form>
	    </fieldset>
	</div>
	
</body>
</html>