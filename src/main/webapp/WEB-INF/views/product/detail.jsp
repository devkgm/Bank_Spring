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
        <section class="py-5 mb-3">
            <div class="container px-4 px-lg-5 my-5">
                <div class="row gx-4 gx-lg-5 align-items-center">
                <%-- <img class="card-img-top mb-5 mb-md-0" src="/resources/upload/products/${dto.thumbnails[0] }" alt="..." /> --%>
                    <div class="col-md-6">
	                    <div id="carouselExample" class="carousel slide" data-bs-ride="carousel">
						  <div class="carousel-inner">
						  	<c:forEach items="${dto.thumbnails }" var="thumbnail" varStatus="status" >
						  		<div class="carousel-item ${status.index == 0 ? 'active' : '' }">
							      <img class="card-img-top mb-5 mb-md-0 carousel-img" src="/resources/upload/products/${thumbnail}" class="d-block w-100" alt="...">
							    </div>
						  	</c:forEach>
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
                        <h1 class="display-5 fw-bolder">${dto.name }</h1>
                        <div class="fs-5 mb-5">
                        	<span>이율</span>
                            <span>${dto.rate }</span>
                        </div>
                        
                        <div class="d-flex mb-3">
                            <button class="btn btn-outline-dark flex-shrink-0" type="button" onclick="location.href='/wishlist/doAdd?product_id=${dto.id}'">
                                <i class="bi-cart-fill me-1"></i>
                                Add to cart
                            </button>
                            <button class="btn btn-outline-dark flex-shrink-0" type="button" onclick="location.href='/account/add?id=${dto.id}'">
                                <i class="bi-cart-fill me-1"></i>
                                상품 가입
                            </button>
                        </div>
                        <div class="d-flex">
                            <c:catch>
                                <c:if test="${member != null}">
                                    <a type="button" class="btn btn-primary mr-3" href="../update?id=${dto.id }">수정하기</a>
                                    <a type="button" class="btn btn-danger" href="../delete?id=${dto.id }">삭제하기</a>
                                </c:if>
                            </c:catch>
                        </div>
                    </div>
                </div>
                
            </div>
        </section>
        
        <!-- 컨텐 -->
        <section class="py-5">
            <div class="d-flex container px-4 px-lg-5 my-5 justify-content-center">
        	${dto.content }
        	</div>
        </section>
        <!-- 댓글 -->
        <section class="py-5">
            <div class="container px-4 px-lg-5 my-5">
                <h1>리뷰 작성</h1>
                <form id="commentForm">
                    <input type="hidden" class="form-control" value="${dto.id}" name="product_id" id="product_id">
                      <div class="mb-3">
                        <textarea class="form-control" name="content" id="replyContents" rows="3" ></textarea>
                      </div>
                      <div class="mb-3">
                      <select class="form-select" name="rate" aria-label="Default select example">
                        <option value="5">5</option>
                        <option value="4">4</option>
                        <option value="3">3</option>
                        <option value="2">2</option>
                        <option value="1">1</option>
                      </select>
                      </div>

                      <div class="d-flex text-end justify-content-end">
                        <button id="commentSubmitButton" type="button" class="btn btn-primary">리뷰달기</button>
                      </div>
                </form>
            </div>
        </section>
        <!-- 댓글 리스트 -->
        <section class="py-5">
            <div class="container px-4 px-lg-5 my-5">
            <h1>댓글</h1>
                <table class="table table-hover text-center" >
                    <thead>
                        <tr>
                            <th>내용</th>
                            <th>점수</th>
                            <th>작성자</th>
                            <th>작성일</th>
                        </tr>
                    </thead>
                    <tbody id="commentBody">
                    </tbody>
                </table>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-12 d-flex text-end justify-content-center" id="buttonContainer">
                        <button id="more" data-bs-commentPage="1" class="btn btn-primary"></button>
                    </div>
                </div>
            </div>
        </section>

        </main>
        <!-- Footer-->
        <c:import url="../template/footer.jsp"></c:import>
        <!-- Bootstrap core JS-->
        <c:import url="../commons/jquery.jsp"></c:import>
        <!-- Core theme JS-->
        <script src="/resources/js/scripts.js"></script>
        <script src="/resources/js/comment.js"></script>
    </body>
</html>
