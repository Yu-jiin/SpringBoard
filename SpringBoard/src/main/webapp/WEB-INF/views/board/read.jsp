<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ include file="../include/header.jsp" %>
<br>

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


<!-- JQuery-->
<!-- JQuery 라이브러리 추가 (include/header.jsp) -->
<script>
	$(document).ready(function(){
		//alert("Test"); TEST라는 알림창을 띄움 
		// 목록으로 버튼 클릭시
		$(".btn-success").click(function(){
			alert("목록으로");
			// 목록으로 이동하기
			location.href="/board/list";
		});
		
		/* ${".btn-danger"}.click(function(){
			alert("글 수정하기");
			location.href="/board/rewrite"
		}) */
		
	});
</script>












<%@ include file="../include/footer.jsp" %>