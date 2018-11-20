<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<form role="form" id="registForm" method="post">
				<input type="hidden" name="bno" value="${boardVo.bno}"/>
				<div class="form-group">
					 
					<label for="title">
						글제목
					</label>
					<input type="text" class="form-control" id="title" 
						name = "title" value="${boardVo.title}" />
				</div>				
				<div class="form-group">
					 
					<label for="content">
						글내용
					</label>
					<textarea class="form-control" id="content" 
						name = "content" >${boardVo.content} </textarea>
				</div>				
				<div class="form-group">
					 
					<label for="writer">
						작성자
					</label>
					<input type="text" class="form-control" id="writer" 
						name = "writer" value="${boardVo.writer}"  />
				</div>
				
<!-- 				삭제할때 비밀번호! -->
				<div id="delClass" style="display:none;">
					 
					<label for="password">
						비밀번호
					</label>
					<input type="password" class="form-control" id="password" 
						name = "password" value=""  />
					<input type = "button" id="btnDel" class = "btn btn-danger" value="확인" />
				</div>
				<br>
				<!-- 수정 -->
				<input type="button" id="btnModify" class="btn btn-warning" value="수정" />
				<!-- 삭제 -->
				<input type="button" id="btnRemove" class="btn btn-danger" value="삭제" />
				<!-- 목록 -->
				<input type="button" id="btnList" class="btn btn-success" value="목록" />
				
			</form>
		</div>
	</div>
</div>
<script>
$(document).ready(function() {
	$("#btnModify").click(function() {
		$("#registForm").attr("action", "/board/modify");
		$("#registForm").submit();
	});
	$("#btnRemove").click(function() {
		$("#delClass").toggle(500);
	});
	$("#btnList").click(function() {
		location.href = "/board/listAll";	// 목록으로 이동
	});
	$("#btnDel").click(function() {
		if ($("#password").val().trim() == "${boardVo.password}") {
			
			location.href = "/board/delete?bno=${boardVo.bno}&password=${boardVo.password}";
		} else {
			alert("비밀번호가 일치하지 않습니다.");
		}
	});
});
</script>
<%@ include file="../include/footer.jsp" %>