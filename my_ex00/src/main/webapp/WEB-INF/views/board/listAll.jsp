<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../include/header.jsp" %>
<script>
	var result = "${result}";
	
	// 리다이렉트 되는 상황에서만 보여지는 메시지!
	if (result == "success") {
		alert("처리가 완료 되었습디다.");
	}

</script>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<table class="table">
				<thead>
					<tr>
						<th>
							글번호
						</th>
						<th>
							글제목
						</th>
						<th>
							작성자
						</th>
						<th>
							작성일
						</th>
						<th>
							조회수
						</th>
					</tr>
				</thead>
				
				<tbody>
				<c:forEach items="${list}" var="boardVo">
					<tr>
						<td>
							${boardVo.bno}
						</td>
						<td>
							<a href="/board/read?bno=${boardVo.bno}">${boardVo.title}</a>
						</td>
						<td>
							${boardVo.writer}
						</td>
						<td>
							<fmt:formatDate value="${boardVo.regdate}" pattern="yyyy-MM-dd HH:mm:ss"/>
						</td> 
						<td>
							<span class="badge badge-red">${boardVo.viewcnt}</span>
						</td>
					</tr>					
				</c:forEach>	
				</tbody>
				
			</table>
		</div>
	</div>
</div>
<%@ include file="../include/footer.jsp" %>