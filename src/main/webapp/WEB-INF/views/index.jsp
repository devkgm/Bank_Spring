<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bank</title>
    <c:import url="./commons/bootstrap_css.jsp"></c:import>
  </head>
  <body>
  	<c:import url="./commons/navigation.jsp"></c:import>
  	<div class="container-sm">
  		<div id="carouselExampleAutoplaying" class="carousel slide" data-bs-ride="carousel">
			  <div class="carousel-inner">
			    <div class="carousel-item active">
			      <img src="./resources/images/t1.jpeg" class="d-block w-100" alt="1">
			    </div>
			    <div class="carousel-item">
			      <img src="./resources/images/t2.jpg" class="d-block w-100" alt="2">
			    </div>
			    <div class="carousel-item">
			      <img src="./resources/images/t3.jpg" class="d-block w-100" alt="3">
			    </div>
			  </div>
			  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleAutoplaying" data-bs-slide="prev">
			    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
			    <span class="visually-hidden">Previous</span>
			  </button>
			  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleAutoplaying" data-bs-slide="next">
			    <span class="carousel-control-next-icon" aria-hidden="true"></span>
			    <span class="visually-hidden">Next</span>
			  </button>
			</div>
		</div>
  	</div>
    
    <c:import url="./commons/bootstrap_js.jsp"></c:import>
  </body>
</html>