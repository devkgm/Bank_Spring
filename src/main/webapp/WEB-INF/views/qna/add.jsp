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
        <c:import url="../templete/templeteHeader.jsp"></c:import>
        <c:import url="../commons/summernote.jsp"></c:import>
    </head>
    <body class="d-flex flex-column h-100">
        <main class="flex-shrink-0">
            <!-- Navigation-->
            <c:import url="../templete/navigation.jsp"></c:import>
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
                            <h1 class="fw-bolder">질문 추가</h1>
                            
                        </div>
                        <div class="row gx-5 justify-content-center">
                            <div class="col-lg-8 col-xl-6">
                                
                                <form
                                    id="productForm"
                                    action="./add"
                                    method="POST"
									enctype="multipart/form-data"                                 
                                >
                                    <!-- Name input-->
                                    <div class="form-floating mb-3">
                                    	<input type="hidden" name="id" value="${dto.id }">
                                        <input
                                            class="form-control"
                                            id="name"
                                            type="text"
                                            name="name"
                                            data-sb-validations="required"
                                        />
                                        <label for="name">제목 입력</label>
                                        <div
                                            class="invalid-feedback"
                                            data-sb-feedback="name:required"
                                        >
                                            제목을 입력해주세요.
                                        </div>
                                    </div>
                                    <!-- Rate input-->
                                    <div class="form-floating mb-3">
                                        <input
                                            class="form-control"
                                            id="rate"
                                            type="text"
                                            name="rate"
                                            data-sb-validations="required"
                                        ></input>
                                        <label for="rate">작성자</label>
                                        <div
                                            class="invalid-feedback"
                                            data-sb-feedback="message:required"
                                        >
                                            이름을 기입해주세요.
                                        </div>
                                    </div>
                                    <!-- 컨텐츠 -->
                                    <div class="form-floating mb-3">
                                        <input
                                        	type="hidden"
                                            class="form-control"
                                            id="content"
                                            name="content"
                                        />
                                        <div id="summernote"></div>
                                    </div>
                                    
                                    
                                    <div class="mb-3">
									  <label for="formFileMultiple" class="form-label">썸네일</label>
									  <input class="form-control" type="file" id="formFileMultiple" name="attach" accept="image/png, image/jpeg" multiple>
									</div>
                                    <!-- Rate input-->
                                    <div class="form-floating mb-3">
                                        <div class="form-check form-switch">
										  <input class="form-check-input" type="checkbox" role="switch" onchange="updateValue(this)" checked>
										  <input type="hidden" name="is_sale" id="is_sale" value="1">
										  <label class="form-check-label" for="flexSwitchCheckChecked">판매</label>
										</div>
                                    </div>
                                    <!-- 제출 -->
                                    <div class="d-grid">
                                        <button
                                            class="btn btn-primary btn-lg"
                                            id="submitButton"
                                            type="submit"
                                        >
                                            상품 등록
                                        </button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </main>
        <!-- Footer-->
        <c:import url="../templete/footer.jsp"></c:import>
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
				        	$img = $('<img>').attr({ src: "/resources/upload/products/"+data.name })
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
