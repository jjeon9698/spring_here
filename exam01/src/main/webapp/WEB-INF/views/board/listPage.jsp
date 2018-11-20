<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../include/header.jsp" %>

<script>
	var result = "${result}";
	
	if (result == "success") {
		alert("처리가 완료 되었습니다.");
	}
</script>
<script>
$(document).ready(function() {
	$("#btnSearch").click(function() {
		var keyword = $("input[name=keyword]").val();
		if (keyword == "") {
			alert("검색어를 입력해 주세요");
			$("input[name=keyword]").focus();
		}
		$("#searchForm").submit();
	});
});
</script>



<div class="container-fluid">
	<div class="row">
		<div class="col-md-12 text-center">
			<form class="form-inline" id="searchForm" action="/board/listPage" method="get">
				<input type="hidden" name="page" value="${pagingDto.page}"/>
				<input type="hidden" name="perPage" value="${pagingDto.perPage}"/>
				<select class="form-control" name="searchType">
					<option value="t"
					<c:if test="${pageMaker.pagingDto.searchType == 't'}">
					selected
					</c:if>
					>글제목</option>
					<option value="c"
					<c:if test="${pageMaker.pagingDto.searchType == 'c'}">
					selected
					</c:if>
					>글내용</option>
					<option value="w"
					<c:if test="${pageMaker.pagingDto.searchType == 'w'}">
					selected
					</c:if>
					>작성자</option>
					<option value="tc"
					<c:if test="${pageMaker.pagingDto.searchType == 'tc'}">
					selected
					</c:if>
					>제목 + 내용</option>
					<option value="tw"
					<c:if test="${pageMaker.pagingDto.searchType == 'tw'}">
					selected
					</c:if>
					>제목 + 작성자</option>
					<option value="cw"
					<c:if test="${pageMaker.pagingDto.searchType == 'cw'}">
					selected
					</c:if>
					>내용 + 작성자</option>
					<option value="tcw"
					<c:if test="${pageMaker.pagingDto.searchType == 'tcw'}">
					selected
					</c:if>
					>제목 + 내용 + 작성자</option>
				</select>
				<input class="form-control mr-sm-2" type="text" name="keyword" value="${pageMaker.pagingDto.keyword}"/> 
				<button id="btnSearch" class="btn btn-primary my-2 my-sm-0" type="button">검색</button>
			</form>
		</div>
	</div>
	
	
	<div class="row">
		<div class="col-md-12">
			<table class="table">
				<thead>
					<tr>
						<th>
							글번호
						</th>
						<th>
							제목
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
							<a href="/board/read?bno=${boardVo.bno}&page=${pageMaker.pagingDto.page}&perPage=${pageMaker.pagingDto.perPage}&searchType=${pageMaker.pagingDto.searchType}&keyword=${pageMaker.pagingDto.keyword}">${boardVo.title}</a>
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
	
	<div class="row text-center">
		<div class="col-md-12">
			<nav>
				<ul class="pagination">
					<c:if test="${pageMaker.prev == true}">
					<li class="page-item">
						<a class="page-link" 
			href="/board/listPage?page=${pageMaker.startPage - 1}&perPage=${pageMaker.pagingDto.perPage}&searchType=${pageMaker.pagingDto.searchType}&keyword=${pageMaker.pagingDto.keyword}">이전</a>
					</li>
					</c:if>
					
					<c:forEach var="i" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
					<li 
					<c:choose>
						<c:when test="${pageMaker.pagingDto.page == i}">
							class="page-item active"
						</c:when>
						<c:otherwise>
							class="page-item"
						</c:otherwise>
					</c:choose>
					>
						<a class="page-link" 
					href="/board/listPage?page=${i}&perPage=${pageMaker.pagingDto.perPage}&searchType=${pageMaker.pagingDto.searchType}&keyword=${pageMaker.pagingDto.keyword}">${i}</a>
					</li>
					</c:forEach>
					
					<c:if test="${pageMaker.next == true}">
					<li class="page-item">
						<a class="page-link" 
			href="/board/listPage?page=${pageMaker.endPage + 1}&perPage=${pageMaker.pagingDto.perPage}&searchType=${pageMaker.pagingDto.searchType}&keyword=${pageMaker.pagingDto.keyword}">다음</a>
					</li>
					</c:if>
				</ul>
			</nav>
			
		</div>
		<form id="perPageForm" method="get">
			<input type="hidden" name="page" value="${pageMaker.pagingDto.page}"/>
		<div class="col-md-12">
			<select name="perPage">
			<c:forEach var="i" begin="10" end="50" step="10">
				<option value="${i}"
				<c:if test="${pageMaker.pagingDto.perPage == i}"> selected </c:if>
				>${i}줄씩 보기</option>
			</c:forEach>
			</select>
		</div>
		</form>
	</div>
</div>

<script>
$(document).ready(function() {
	$("select[name=perPage]").change(function() {
		$("#perPageForm").attr("action", "/board/listPage");
		$("#perPageForm").submit();
	});
});
</script>

<%@ include file="../include/footer.jsp" %>