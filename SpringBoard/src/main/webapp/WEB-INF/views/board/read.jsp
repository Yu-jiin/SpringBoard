<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ include file="../include/header.jsp" %>


<div class="content">
<br>
	<h1>read.jsp</h1>
	<form role="form" action="" method="get">
		<input type="hidden" name="bno" value="${vo.bno }">
	</form>

<div class="box box-primary">
	<div class="box-header with-border">
		<h3 class="box-title">게시판 본문 조회</h3>
	</div>

	
		<div class="box-body">
			<div class="form-group">
				<label for="exampleInputEmail1">제  목</label>
				<input type="text" class="form-control" id="title" name="title" value = ${vo.title } readonly>
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">이  름</label> 
				<input type="text" class="form-control" id="writer"name="writer" value = ${vo.writer } readonly>
			</div>
			<div class="form-group">
				<label>내  용</label>
				<textarea class="form-control" rows="3" id="content" name="content" readonly >${vo.content }</textarea>
			</div>
		</div>

		<div class="box-footer">
			<button type="submit" class="btn btn-danger">글 수정</button>
			<button type="submit" class="btn btn-warning">글 삭제</button>
			<button type="submit" class="btn btn-success">목록으로</button>
		</div>
	
</div>
</div>

<!-- JQuery-->
<!-- JQuery 라이브러리 추가 (include/header.jsp) -->
<script>
	$(document).ready(function(){
		
		// bno를 저장하는 폼테그 정보 
		var formObj = $("form[role='form']");
		
		
		//alert("Test"); TEST라는 알림창을 띄움 
		// 목록으로 버튼 클릭시
		$(".btn-success").click(function(){
			alert("목록으로");
			// 목록으로 이동하기
			location.href="/board/list";
		});
		
		// 수정하기 버튼 클릭시
		$(".btn-danger").click(function(){
			alert("글 수정하기");
			formObj.attr("action", "/board/modify");
			formObj.submit();
		});
		
		// 삭제하기 버튼 클릭시
		$(".btn-warning").click(function(){
			alert("글 삭제 !");
			formObj.attr("action", "/board/remove");
			formObj.attr("method","post");
			formObj.submit();
		});
		
	});
</script>












<%@ include file="../include/footer.jsp" %>