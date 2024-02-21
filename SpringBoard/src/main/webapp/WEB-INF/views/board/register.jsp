<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ include file="../include/header.jsp" %>

<h1>/board/register.jsp</h1>

<h2>글쓰기</h2>

<div class="box box-primary">
	<div class="box-header with-border">
		<h3 class="box-title">게시판 글쓰기</h3>
	</div>


	<form role="form" method="post">
		<div class="box-body">
			<div class="form-group">
				<label for="exampleInputEmail1">제  목</label>
				<input type="text" class="form-control" id="title" placeholder="제목 뭐 할래" name="title">
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">이  름</label> 
				<input type="text" class="form-control" id="writer" placeholder="너 누구야" name="writer">
			</div>
			<div class="form-group">
				<label>내  용</label>
				<textarea class="form-control" rows="3" id="content" placeholder="내용 입력해보자 ..." name="content"></textarea>
			</div>
		</div>

		<div class="box-footer">
			<button type="submit" class="btn btn-primary">글 쓰기</button>
		</div>
	</form>
</div>

<%@ include file="../include/footer.jsp" %>