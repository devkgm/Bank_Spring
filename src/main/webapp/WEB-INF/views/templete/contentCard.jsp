<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="col mb-5">
   <div class="card h-100">
       <!-- Sale badge-->
       <div class="badge bg-dark text-white position-absolute" style="top: 0.5rem; right: 0.5rem">
			<c:choose>
				<c:when test="${param.is_sale eq 0}">
					품절
				</c:when>
				<c:when test="${param.is_sale eq 1}">
					판매중
				</c:when>
			</c:choose>
		</div>
       <!-- Product image-->
       <img class="card-img-top" src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="..." />
       <!-- Product details-->
       <div class="card-body p-4">
           <div class="text-center">
               <!-- Product name-->
               <h5 class="fw-bolder">${param.title }</h5>
               <!-- Product reviews-->
               <div class="d-flex justify-content-center small text-warning mb-2">
               		${param.rate }
              			
             				<!-- <div class="bi-star-fill"></div> -->
               			
               </div>
               <!-- Product price-->
               
               ${param.create_dt }
           </div>
       </div>
       <!-- Product actions-->
        <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
            <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#">Add to cart</a></div>
        </div>
    </div>
</div>