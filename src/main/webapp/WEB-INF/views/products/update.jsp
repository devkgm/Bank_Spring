<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../commons/bootstrap_css.jsp"></c:import>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
</head>
<body>
	<c:import url="../commons/navigation.jsp"></c:import>
	
	<div class="container-sm">
		<h1>상품수정</h1>
		<form action="./update" method="POST">
		<input type="hidden" name="id" value="${dto.id }">
		  <div class="mb-3">
		    <label for="name" class="form-label">상품명</label>
		    <input type="text" class="form-control" id="name" name="name" value="${dto.name }" aria-describedby="nameHelp">
		  </div>
		  <div class="mb-3">
		    <label for="desciprtion" class="form-label">상품설명</label>
		    <textarea name="description" id="summernote"></textarea>
		  </div>
		  <div class="mb-3">
		    <label for="rate" class="form-label">이자율</label>
		    <input type="text" class="form-control" id="rate" name="rate" value="${dto.rate }">
		  </div>
		  <button type="submit" class="btn btn-primary">업로드</button>
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
		 $('#summernote').summernote('code', `${dto.description }`); 
	</script>
</body>
</html>