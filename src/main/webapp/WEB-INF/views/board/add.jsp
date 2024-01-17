<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta
            name="viewport"
            content="width=device-width, initial-scale=1, shrink-to-fit=no"
        />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Personal - Start Bootstrap Theme</title>
        <c:import url="../template/templateHeader.jsp"></c:import>
        <c:import url="../commons/summernote.jsp"></c:import>
    </head>
    <body class="d-flex flex-column h-100">
        <main class="flex-shrink-0">
            <!-- Navigation-->
            <c:import url="../template/navigation.jsp"></c:import>
            <!-- Page content-->
            <section class="py-5">
                <div class="container px-5">
                    <!-- Contact form-->
                    <div class="bg-light rounded-4 py-5 px-4 px-md-5">
                        <div class="text-center mb-5">
                            <div
                                class="feature bg-primary bg-gradient-primary-to-secondary text-white rounded-3 mb-3"
                            >
                                <i class="bi bi-envelope"></i>
                            </div>
                            <h1 class="fw-bolder">글쓰기</h1>
                            
                        </div>
                        <div class="row gx-5 justify-content-center">
                            <div class="col-lg-8 col-xl-6">
                                <c:import url="../template/editForm.jsp"></c:import>

                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </main>
        <!-- Footer-->
        <c:import url="../template/footer.jsp"></c:import>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="/resources/js/scripts.js"></script>
        <script src="/resources/js/summernote.js"></script>
        <script>
			function updateValue(checkbox) {
			    var hiddenInput = document.getElementById("is_sale");
			    if (checkbox.checked) {
			        hiddenInput.value = 1;
			    } else {
			        hiddenInput.value = 0;
			    }
			}
			document.getElementById('formFileMultiple').addEventListener('change', function(event) {
			    var files = event.target.files;
			    var maxSize = 2 * 1024 * 1024;
			   	if(files.length > 5) alert("최대 5개의 파일만 등록할 수 있습니다.");
			    for(let i = 0; i < files.length; i++ ){
			    	if (files[i].size > maxSize) {
				        alert("파일 크기가 너무 큽니다. 2MB 이하의 파일을 선택해주세요.");
				        this.value = ''; 
				    }
			    }
				
			});

			$('#summernote').summernote({
		        placeholder: '상세페이지를 작성해주세요.',
		        tabsize: 2,
		        height: 500,
		        backgroundColor:'white',
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
				    onChange: function(contents, $editable) {
				      $('#content').val($('#summernote').summernote('code'));
				  
				    },
				    onImageUpload: function(files) {
				        console.log("imageUpload")
				        const formData = new FormData();
				        formData.append("product_id", ${dto.id });
				        formData.append("attach", files[0])
				        console.log(files)
				        fetch("./addFile", {
				        	method:"POST",
				        	"Content-type": "multipart/form-data",
				        	body: formData,
				        }).then(response => response.json())
				        .then(data => {
				        	console.log(data)
				        	//$('#summernote').summernote('insertImage', "/resources/upload/products/"+data.name, data.name);
				        	$img = $('<img>').attr({ src: "/resources/upload/${board}/"+data.name })
				            $('#summernote').summernote('insertNode', $img[0]);
				        })
			      },
			      onMediaDelete: function($target, editor, $editable) {
			            // 이미지 삭제 시 실행할 콜백 함수
		            var deletedImageSrc = $target.attr('src');
		            console.log('이미지 삭제됨:', deletedImageSrc);

		            // 이곳에서 삭제된 이미지에 대한 추가 작업을 수행할 수 있습니다.
		            // 예를 들어, 서버에서 해당 이미지를 삭제하거나 다른 동작을 수행할 수 있습니다.
		          },
		         

			  }
		        
		  });
			
		</script>
    </body>
</html>
