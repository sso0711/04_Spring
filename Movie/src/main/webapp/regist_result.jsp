<%@ page import="java.util.List"%>
<%@ page import="com.ssafy.ws.step2.dto.Movie" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>regist-reuslt.jsp</title>
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
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" />
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
    <h1>영화 등록 결과</h1>
    <div>
        <%
        String root = request.getContextPath();
        Movie movie = (Movie) request.getAttribute("result");
		%>
		
		<%
		if (movie != null) { 
		%>
	    <table>
	    <tr>
	        <th>항목</th>
	        <th>내용</th>
	    </tr>
	    <tr>
	        <th>제목</th>
	        <td><%=movie.getTitle() %></td>
	    </tr>
	    <tr>
	        <th>감독</th>
	        <td><%=movie.getDirector() %></td>
	    </tr>
	    <tr>
	        <th>장르</th>
	        <td><%=movie.getGenre() %></td>
	    </tr>
	    <tr>
	        <th>상영시간</th>
	        <td><%=movie.getRunningTime() %></td>
	    </tr>
		</table>
		<% } else { %>
		    <p>데이터가 없습니다.</p>
		<% } %>
		
        <a href="<%=root%>/main?action=regist-form">추가등록</a>
    </div>
    
</body>
</html>
