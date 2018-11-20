<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<form role="form" id="registForm" method="post">
				<input type="hidden" name="bno" value="${boardVo.bno}"/>
				<input type="hidden" name="page" value="${pagingDto.page}"/>
				<input type="hidden" name="perPage" value="${pagingDto.perPage}"/>
				<input type="hidden" name="searchType" value="${pagingDto.searchType}"/>
				<input type="hidden" name="keyword" value="${pagingDto.keyword}"/>
				<div class="form-group">
					 
					<label for="title">
						글제목
					</label>
					<input type="text" class="form-control" id="title" name="title"
						value="${boardVo.title}" />
				</div>
				
				<div class="form-group">
					 
					<label for="content">
						글내용
					</label>
					<textarea class="form-control" id="content" name="content">${boardVo.content}</textarea>
				</div>
				
				<div class="form-group">
					 
					<label for="writer">
						작성자
					</label>
					<input type="text" class="form-control" id="writer" name="writer"
						value="${boardVo.writer}" />
				</div>
				
				<!-- 수정 -->
				<input type="button" id="btnModify" class="btn btn-warning" value="수정"/>
				<!-- 삭제 -->
				<input type="button" id="btnRemove" class="btn btn-danger" value="삭제" />
				<!-- 목록 -->
				<input type="button" id="btnList" class="btn btn-success" value="목록"/>
			</form>
		</div>
	</div>
</div>
<form id="pagingForm" method="get">
<input type="hidden" name="page"/>
<input type="hidden" name="perPage"/>
<input type="hidden" name="searchType"/>
<input type="hidden" name="keyword"/>
</form>
<script>
$(document).ready(function() {
	$("#btnModify").click(function() {
		$("#registForm").attr("action", "/board/modify");
		$("#registForm").submit();
	});
	$("#btnRemove").click(function() {
		location.href = "/board/remove?bno=${boardVo.bno}&page=${pagingDto.page}&perPage=${pagingDto.perPage}&searchType=${pagingDto.searchType}&keyword=${pagingDto.keyword}";
	});
	$("#btnList").click(function() {
		$("#pagingForm > input[name=page]").val("${pagingDto.page}");
		$("#pagingForm > input[name=perPage]").val("${pagingDto.perPage}");
		$("#pagingForm > input[name=searchType]").val("${pagingDto.searchType}");
		$("#pagingForm > input[name=keyword]").val("${pagingDto.keyword}");
		$("#pagingForm").attr("action", "/board/listPage");
		$("#pagingForm").submit();
	});
});
</script>

<%@ include file="../include/footer.jsp" %>