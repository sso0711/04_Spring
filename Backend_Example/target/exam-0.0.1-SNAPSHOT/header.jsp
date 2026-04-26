<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	// Keep `${root}` usable in pages that include this header, without JSTL.
	request.setAttribute("root", request.getContextPath());
	Object loginUserObj = session.getAttribute("loginUser");
	boolean loggedIn = loginUserObj != null;
%>
<style>
a {
	text-decoration: none;
}
</style>
<div>
	<span> <a href="${root}/main">홈으로</a></span>
	
	<% if (!loggedIn) { %>
	| <span> <a href="${root}/main?action=login-form">로그인</a></span>
	<% } %>
	<!--11. 기타 처리 : 로그인 안된 경우 차량 정보 관리 관련 (목록, 등록, 수정, 삭제 등) 접근을 막아주세요.-->
	<% if (loggedIn) { %>
		<%
			com.ssafy.exam.model.dto.Member loginUser =
					(com.ssafy.exam.model.dto.Member) loginUserObj;
		%>
        | <span>
            <a href="${root }/main?action=list">목록조회</a>
        </span>
        | <span>
            안녕하세요. <%= loginUser.getName() %>님. 
        </span>
        | <span>
            <a href="${root}/main?action=logout">로그아웃</a>
        </span>
	<% } %>
		
</div>
<hr />
<script type="text/javascript">
	const alertMsg = `${param.alertMsg}` || `${alertMsg}`; // 메시지 자체에 ""가 포함 되기도 함
	if (alertMsg) {
		alert(alertMsg);
	}
	
</script>
