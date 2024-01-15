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
        <style>
        	.carousel-img {
			    width: 100%; 
			    height: 500px; 
			    object-fit: cover; 
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
                        <span class="text-gradient d-inline">상세 페이지</span>
                    </h1>
                </div>
            </div>
         <!-- Product section-->
        <section class="py-5 mb-3">
            <div class="container px-4 px-lg-5 my-5">
                <div class="row gx-4 gx-lg-5 align-items-center">
                <%-- <img class="card-img-top mb-5 mb-md-0" src="/resources/upload/products/${dto.thumbnails[0] }" alt="..." /> --%>
                    <div class="col-md-6">
	                    <div id="carouselExample" class="carousel slide" data-bs-ride="carousel">
						  <div class="carousel-inner">
						  	<%-- <c:forEach items="${dto.thumbnails }" var="thumbnail" varStatus="status" >
						  		<div class="carousel-item ${status.index == 0 ? 'active' : '' }">
							      <img class="card-img-top mb-5 mb-md-0 carousel-img" src="/resources/upload/products/${thumbnail}" class="d-block w-100" alt="...">
							    </div>
						  	</c:forEach> --%>
						  </div>
						  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExample" data-bs-slide="prev">
						    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
						    <span class="visually-hidden">Previous</span>
						  </button>
						  <button class="carousel-control-next" type="button" data-bs-target="#carouselExample" data-bs-slide="next">
						    <span class="carousel-control-next-icon" aria-hidden="true"></span>
						    <span class="visually-hidden">Next</span>
						  </button>
						</div>
                    </div>
                    <div class="col-md-6">
                        <div class="small mb-1">SKU: BST-498</div>
                        <h1 class="display-5 fw-bolder">${dto.title }</h1>
                        <div class="fs-5 mb-5">
    						<span>작성자</span>
                            <span>${dto.writer }</span>
                        </div>
                        
                        <div class="d-flex">
                            <input class="form-control text-center me-3" id="inputQuantity" type="num" value="${dto.views }" style="max-width: 3rem" />
                           
                            <a type="button" class="btn btn-primary mr-3" href="../update?id=${dto.id }">수정하기</a>
        					<a type="button" class="btn btn-danger" href="../delete?id=${dto.id }">삭제하기</a>
                        </div>
                    </div>
                </div>
                
            </div>
        </section>
        
        <!-- 컨텐 -->
        <section class="py-5">
            <div class="container px-4 px-lg-5 my-5">
        	${dto.content }
        	</div>
        </section>
        </main>
        <!-- Footer-->
        <c:import url="../templete/footer.jsp"></c:import>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="/resources/js/scripts.js"></script>
    </body>
</html>
