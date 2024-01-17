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
            <c:import url="../template/navigation.jsp"></c:import>
            <div class="container px-5 mb-5">
                <div class="text-center mb-5">
                    <h1 class="display-5 fw-bolder mb-0">
                        <span class="text-gradient d-inline">상세 페이지</span>
                    </h1>
                </div>
            </div>
         <!-- Product section-->
        <section class="py-5">
            <div class="container px-4 px-lg-5 my-5">
                <div class="row gx-4 gx-lg-5 align-items-center">
                   
                    <div class="col-md-6">
                        <div class="small mb-1">SKU: BST-498</div>
                        <h1 class="display-5 fw-bolder">${dto.title }</h1>
                        <div class="fs-5 mb-5">
    						<span>작성자</span>
                            <span>${dto.writer }</span>
                        </div>
                        
                        <div class="d-flex">
                            <input class="form-control text-center me-3" id="inputQuantity" type="num" value="${dto.views }" style="max-width: 3rem" />
                           	<c:if test="${board eq 'QnA' }" >
	                           	<a type="button" class="btn btn-primary mr-3" href="../reply?id=${dto.id }">답글</a>
                           	
                           	</c:if>
                           	
                           	
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
        
        <section class="py-5">
        	<div class="container px-4 px-lg-5 my-5">
        		<div class="row">
                	<c:forEach items="${dto.fileDTOs }" var="f" varStatus="status" >
			          	<div class="card" style="width: 10rem; height:20rem;">
						  <img src="/resources/upload/${board }/${f.name}"  class="card-img-top" alt="...">
						  <div class="card-body">
						    <h5 class="card-title" style="white-space:nowrap; overflow:hidden;">${f.origin_nm}</h5>
						    <a href="/resources/upload/${board }/${f.name}" class="btn btn-primary" download>다운로드</a>
						  </div>
						</div>
			  		</c:forEach>
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
    </body>
</html>
