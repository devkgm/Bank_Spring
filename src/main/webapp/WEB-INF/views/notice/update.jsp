<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../commons/bootstrap_css.jsp"></c:import>
<c:import url="../commons/summernote.jsp"></c:import>
</head>
<body>
	<c:import url="../commons/navigation.jsp"></c:import>
	
	<div class="container-sm">
		<h1>상품추가</h1>
		<c:import url="../template/editForm.jsp"></c:import>
		<c:if test="${dto.noticeFileDTOs != null }">
	    	<c:forEach items="${dto.noticeFileDTOs }" var="f">
	    	<div class="card" style="width: 10rem;">
			  <img src="/resources/upload/notices/${f.name}" class="card-img-top" alt="${f.origin_nm}">
			  <div class="card-body">
			    <h5 class="card-title">${f.origin_nm}</h5>
			    <a href="/resources/upload/notices/${f.name}" class="btn btn-danger">삭제하기</a>
			  </div>
			</div>
	    	</c:forEach>
	    </c:if>
	</div>
	
	<c:import url="../commons/bootstrap_js.jsp"></c:import>
	<script type="text/javascript">
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