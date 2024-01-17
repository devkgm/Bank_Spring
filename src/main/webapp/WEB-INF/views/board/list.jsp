<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>${board }</title>
<c:import url="../templete/templeteHeader.jsp"></c:import>
<style>
tr:hover {
	cursor: pointer;
}
</style>
</head>
<body class="d-flex flex-column h-100">
	<main class="flex-shrink-0">
		<!-- Navigation-->
		<c:import url="../templete/navigation.jsp"></c:import>
		<div class="container px-5 mb-5">
			<div class="text-center mb-5">
				<h1 class="display-5 fw-bolder mb-0">
					<span class="text-gradient d-inline">${board }</span>
				</h1>
			</div>
		</div>
		<section class="py-5">
			<div class="container px-4 px-lg-5 mt-5">
				<div
					class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
					<table class="table table-hover">
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>글쓴이</th>
							<th>날짜</th>
							<th>조회수</th>
						</tr>
						<c:forEach items="${list }" var="item" varStatus="status">
							<c:set var="f" value="0"></c:set>
							<c:catch>
								<c:set var="f" value="${item.is_deleted }"></c:set>
								<c:if test="${f eq 1 }">
									<tr>
										<td>${status.index+1 }</td>
										<td><c:forEach begin="1" end="${item.depths }">
				                            		--
				                            		</c:forEach> 삭제된 게시물입니다.</td>
										<td></td>
										<td></td>
										<td></td>
									<tr>
								</c:if>
							</c:catch>
							<c:if test="${f eq 0 }">
								<tr onclick="location.href='./detail/${item.id}'">
									<td>${status.index+1 }</td>
									<td><c:forEach begin="1" end="${item.depths }">
		                            		--
		                            		</c:forEach> ${item.title }</td>
									<td>${item.writer }</td>
									<td>${item.create_dt }</td>
									<td>${item.views }</td>
								<tr>
							</c:if>
						</c:forEach>
					</table>


				</div>


				<a type="button" class="btn btn-success" href="./add">글쓰기</a>
			</div>
			<div
				class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
				<jsp:include page="../templete/pagination.jsp"></jsp:include>
			</div>
			<div
				class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
				<form action="./list" id="frm">
					<input type="hidden" name="page" value="1" id="page">
					<div class="input-group mb-3">
						<select class="form-select" name="kind"
							aria-label="Default select example">
							<option value="title">제목</option>
							<option value="writer">글쓴이</option>
							<option value="content">내용</option>
						</select> <input type="text" name="search" value="${pager.search }"
							class="form-control" placeholder="검색어를 입력하세요."
							aria-label="Recipient's username"
							aria-describedby="button-addon2">
						<button class="btn btn-outline-secondary" type="submit"
							id="button-addon2">검색</button>
					</div>
				</form>


			</div>
		</section>
	</main>
	<!-- Footer-->
	<c:import url="../templete/footer.jsp"></c:import>
	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="/resources/js/scripts.js"></script>
	<script src="/resources/js/search.js"></script>

</body>
</html>
