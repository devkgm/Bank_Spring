<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../commons/bootstrap_css.jsp"></c:import>
</head>
<body>
	<c:import url="../commons/navigation.jsp"></c:import>
	
	<div class="container-sm mb-3">
		<h1>상품</h1>
		<form action="./update" method="GET" id="frm">
			<input type="hidden" name="id" value="${dto.id }">
		  <div class="mb-3">
		    <label for="title" class="form-label">제목</label>
		    <br>
		    ${dto.title }
		  </div>
		  <div class="mb-3">
		    <label for="desciprtion" class="form-label">본문</label>
		    <br>
		    ${dto.description }
		    <c:if test="${dto.noticeFileDTOs != null }">
		    	<c:forEach items="${dto.noticeFileDTOs }" var="f">
		    	<div class="card" style="width: 10rem;">
				  <img src="/resources/upload/notices/${f.name}" class="card-img-top" alt="${f.origin_nm}">
				  <div class="card-body">
				    <h5 class="card-title">${f.origin_nm}</h5>
				    <a href="/resources/upload/notices/${f.name}" class="btn btn-primary" download>다운로드</a>
				  </div>
				</div>
		    	</c:forEach>
		    </c:if>
		  </div>
		  <div class="mb-3">
		    <label for="hit" class="form-label">조회수</label>
		    <br>
		    ${dto.hit }
		  </div>
		</form>
		<button class="btn btn-danger" id="deleteBtn">삭제</button>
		<button class="btn btn-secondary" id="modifyBtn">수정</button>
	</div>
	<script>
		const form = document.getElementById("frm");
		const deleteBtn = document.getElementById("deleteBtn");
		const modifyBtn = document.getElementById("modifyBtn");
		
		deleteBtn.addEventListener("click", function(){
			form.setAttribute("action","./delete");
			form.setAttribute("method","POST");
			form.submit();
		})
		modifyBtn.addEventListener("click", function(){
			form.setAttribute("action","./update");
			form.setAttribute("method","GET");
			form.submit();
		})
	</script>
	<c:import url="../commons/bootstrap_js.jsp"></c:import>
</body>
</html>