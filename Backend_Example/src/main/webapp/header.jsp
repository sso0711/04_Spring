<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<c:set var="root" value="${pageContext.servletContext.contextPath }" />
<div>
	<span> <a href="${root}/main">홈으로</a></span>
	
	<c:if test="${empty sessionScope.loginUser }">
	| <span> <a href="${root}/main?action=login-form">로그인</a></span>
    </c:if>

	<!--11. 기타 처리 : 로그인 안된 경우 차량 정보 관리 관련 (목록, 등록, 수정, 삭제 등) 접근을 막아주세요.-->
    <c:if test="${not empty sessionScope.loginUser }">
        | <span>
            <a href="${root }/member?action=list">목록조회</a>
        </span>

        | <span>
            안녕하세요. ${loginUser.name}님. 
        </span>
        | <span>
            <a href="${root}/member?action=logout">로그아웃</a>
        </span>
    </c:if>
		
</div>
<hr />
<script type="text/javascript">
	const alertMsg = `${param.alertMsg}` || `${alertMsg}`; // 메시지 자체에 ""가 포함 되기도 함
	if (alertMsg) {
		alert(alertMsg);
	}
	<%
		session.removeAttribute("alertMsg");
	%>
	
</script>

