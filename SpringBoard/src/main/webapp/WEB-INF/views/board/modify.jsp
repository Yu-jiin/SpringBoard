<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ include file="../include/header.jsp" %>
${boardVO }

<h1>/board/modify.jsp</h1>

<h2>글 수정하기</h2>

<div class="box box-primary">
	<div class="box-header with-border">
		<h3 class="box-title">본문 수정 갈겨</h3>
	</div>


	<form role="form" method="post">
	<input type="hidden" name="bno" value="${boardVO.bno }">
		<div class="box-body">
			<div class="form-group">
				<label for="exampleInputEmail1">제  목</label>
				<input type="text" class="form-control" id="title"  value="${boardVO.title }" name="title">
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">이  름</label> 
				<input type="text" class="form-control" id="writer" value="${boardVO.writer }" name="writer">
			</div>
			<div class="form-group">
				<label>내  용</label>
				<textarea class="form-control" rows="3" id="content" placeholder="내용 입력해보자 ..." name="content">${boardVO.content }</textarea>
			</div>
		</div>

		<div class="box-footer">
			<button type="submit" class="btn btn-danger">수정하기</button>
		</div>
	</form>
</div>















<%@ include file="../include/footer.jsp" %>