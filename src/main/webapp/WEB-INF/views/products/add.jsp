<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
<c:import url="../commons/bootstrap_css.jsp"></c:import>
<c:import url="../commons/summernote.jsp"></c:import>
</head>
<body>
	<c:import url="../commons/navigation.jsp"></c:import>
	
	<div class="container-sm">
		<h1>상품추가</h1>
		<form action="./add" method="POST" enctype="multipart/form-data">
		  <div class="mb-3">
		    <label for="name" class="form-label">상품명</label>
		    <input type="text" class="form-control" id="name" name="name" aria-describedby="nameHelp">
		  </div>
		  <div class="mb-3">
		    <label for="desciprtion" class="form-label">상품설명</label>
		    <textarea style="height: 500px;" class="form-control" id="summernote" name="description"></textarea>
		  </div>
		  <div class="mb-3">
		    <label for="rate" class="form-label">이자율</label>
		    <input type="text" class="form-control" id="rate" name="rate">
		  </div>
		  <div class="mb-3">
		  	<input type="file" name="photo">
		  </div>
		  <button class="btn btn-primary mb-3">업로드</button>
		</form>
	</div>
	
	<c:import url="../commons/bootstrap_js.jsp"></c:import>
	<script>
		$('#summernote').summernote({
	        placeholder: 'Hello stand alone ui',
	        tabsize: 2,
	        height: 500,
	        toolbar: [
	          ['style', ['style']],
	          ['font', ['bold', 'underline', 'clear']],
	          ['color', ['color']],
	          ['para', ['ul', 'ol', 'paragraph']],
	          ['table', ['table']],
	          ['insert', ['link', 'picture', 'video']],
	          ['view', ['fullscreen', 'codeview', 'help']]
	        ]
	      });
		
	</script>
</body>
</html>