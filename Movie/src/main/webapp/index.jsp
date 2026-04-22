<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화정보사이트</title>
</head>
<body>
	<!-- 메인화면을 구현하세요 -->
	<h1>영화관리 메인화면 (index.jsp)</h1>
    <div>
        <%
         String root = request.getContextPath();
        %>
		<a href="<%=root%>/main?action=regist-form">영화 등록하기</a>
		<a href="<%=root%>/main?action=list">영화 목록보기</a>
        <!-- END -->
    </div>
</body>
<script>
    const showAlertMessage = (msg) => {
        if (msg && msg != "null") {
            alert(msg);
        }
    }
    showAlertMessage(`<%=request.getAttribute("alertMsg")%>`)
</script>
</html>