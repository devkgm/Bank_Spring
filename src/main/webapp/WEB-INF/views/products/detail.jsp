<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품 정보</title>
<c:import url="../commons/bootstrap_css.jsp"></c:import>
</head>
<body>
	<c:import url="../commons/navigation.jsp"></c:import>
	
	<div class="container-sm">
		<h1>상품</h1>
		<form action="./update" method="GET" id="frm">
			<input type="hidden" name="id" value="${dto.id }">
		  <div class="mb-3">
		    <label for="name" class="form-label">상품명</label>
		    <br>
		    ${dto.name }
		  </div>
		  <div class="mb-3">
		    <label for="desciprtion" class="form-label">상품설명</label>
		    <br>
		    ${dto.description }
		  </div>
		  <div class="mb-3">
		    <label for="rate" class="form-label">이자율</label>
		    <br>
		    ${dto.rate }
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