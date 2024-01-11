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
		<h1>공지추가</h1>
		<form action="./add" method="POST" enctype="multipart/form-data">
		  <div class="mb-3">
		    <label for="title" class="form-label">제목</label>
		    <input type="text" class="form-control" id="title" name="title" aria-describedby="titleHelp">
		  </div>
		  <div class="mb-3">
		    <label for="desciprtion" class="form-label">본문</label>
		    <textarea class="form-control" id="summernote" name="description"></textarea>
		  </div>
		  <div class="mb-3">
		  	<input class="form-control" type="file" id="formFile" name="photo">
		  </div>
		  <button class="btn btn-primary mb-3">업로드</button>
		</form>
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
	        ],
	        callbacks: {
			    onImageUpload: function(files) {
			      const send_data = new FormData();
			      send_data.append("image", files[0]);
			      fetch('./addImage', {
			    	  method:"POST",
			    	  headers:{
			    		  
			    	  },
			    	  body:send_data,
			      })
			      .then(res => res.json())
			      .then(data => {
			    	  console.log(data.name);
			    	  $('#summernote').summernote('insertImage',"/resources/upload/notices/"+data.name,);
			      })
			      
			    }
			  }
	      });
		
	</script>
</body>
</html>