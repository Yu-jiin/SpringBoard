<%@page pageEncoding="UTF-8" %>

<!-- 지시어 include : 컴파일 전에 소스코드 포함 -->
<%@ include file="include/header.jsp" %>

<!-- 액션태그 include : 컴파일 후에 소스코드 포함 -->

<!-- home.jsp -->
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<hr>
<button type="button" class="btn btn-block btn-default btn-flat">Success</button>


<%@ include file="include/footer.jsp" %>
