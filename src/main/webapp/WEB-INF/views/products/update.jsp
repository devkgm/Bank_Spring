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
	
	<div class="container-sm">
		<h1>상품추가</h1>
		<form action="./update" method="POST">
		<input type="hidden" name="id" value="${dto.id }">
		  <div class="mb-3">
		    <label for="name" class="form-label">상품명</label>
		    <input type="text" class="form-control" id="name" name="name" value="${dto.name }" aria-describedby="nameHelp">
		  </div>
		  <div class="mb-3">
		    <label for="desciprtion" class="form-label">상품설명</label>
		    <input type="text" class="form-control" id="desciprtion" name="description" value="${dto.description }">
		  </div>
		  <div class="mb-3">
		    <label for="rate" class="form-label">이자율</label>
		    <input type="text" class="form-control" id="rate" name="rate" value="${dto.rate }">
		  </div>
		  <button class="btn btn-primary">업로드</button>
		</form>
	</div>
	
	<c:import url="../commons/bootstrap_js.jsp"></c:import>
</body>
</html>