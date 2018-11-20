<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<form role="form" id="registForm" method="post" action="/board/regist">
				<div class="form-group">
					 
					<label for="title">
						글제목
					</label>
					<input type="text" class="form-control" id="title" name="title" />
				</div>
				
				<div class="form-group">
					 
					<label for="content">
						글내용
					</label>
					<textarea class="form-control" id="content" name="content"></textarea>
				</div>
				
				<div class="form-group">
					 
					<label for="writer">
						작성자
					</label>
					<input type="text" class="form-control" id="writer" name="writer" />
				</div>
				
				<button type="submit" class="btn btn-primary">
					작성완료
				</button>
			</form>
		</div>
	</div>
</div>

<%@ include file="../include/footer.jsp" %>