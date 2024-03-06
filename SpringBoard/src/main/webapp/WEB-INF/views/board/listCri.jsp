<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../include/header.jsp" %>

<h1>/board/listCRI.jsp</h1>

cri : ${cri } <br>
pageVO : ${pageVO } <br>
	<div class="content">
	<div class="box">
		<div class="box-header with-border">
			<h3 class="box-title">게시판 목록</h3>
		</div>

		<div class="box-body">
			<table class="table table-bordered">
				<tbody>
					<tr>
						<th style="width: 10px">bno</th>
						<th>Title</th>
						<th>Writer</th>
						<th>ViewCnt</th>
						<th>Regdate</th>
					</tr>
					<c:forEach var="boardList" items="${boardList }">
					<tr>
						<td>${boardList.bno }</td>
						<td><a href="/board/read?bno=${boardList.bno }&page=${cri.page}&pageSize=${cri.pageSize}">${boardList.title }</a></td>
						<td>${boardList.writer }</td>
						<td>${boardList.viewcnt }</td>
						<td>
							<fmt:formatDate value="${boardList.regdate }"/>
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

		<div class="box-footer clearfix">
			<ul class="pagination pagination-sm no-margin pull-right">
				<c:if test="${pageVO.prev }">
				<li><a href="/board/listCri?page=${pageVO.startPage - 1 }">«</a></li>
				</c:if>
				<c:forEach var="idx" begin="${pageVO.startPage }" end="${pageVO.endPage }" step="1">
				<li ${pageVO.cri.page == idx? "class=active":""}><a href="/board/listCri?page=${idx }">${idx }</a></li>
				</c:forEach>
				<c:if test="${pageVO.next }">
				<li><a href="/board/listCri?page=${pageVO.endPage + 1 }">»</a></li>
				</c:if>
			</ul>
		</div>
	</div>


</div>












<%@ include file="../include/footer.jsp" %>