<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품</title>
<c:import url="../commons/bootstrap_css.jsp"></c:import>

</head>
<body>
	<c:import url="../commons/navigation.jsp"></c:import>
	
	<div class="container-sm">
		<h1>상품 리스트</h1>
		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th>ID</th>
					<th>NAME</th>
					<th>DESCRIPTION</th>
					<th>RATE</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${requestScope.list}" var="item">
					<tr onclick="handleClick(${item.id })">
						<td>${item.id }</td>
						<td>${item.name }</td>
						<td>${item.description }</td>
						<td>${item.rate }%</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a class="btn btn-primary" href="./add">상품추가</a>
		
		<nav aria-label="Page navigation example">
		  <ul class="pagination">
		    <li class="page-item">
		      <a class="page-link" href="#" aria-label="Previous">
		        <span aria-hidden="true">&laquo;</span>
		      </a>
		    </li>
		    <li class="page-item"><a class="page-link" href="?page=1">1</a></li>
		    <li class="page-item"><a class="page-link" href="?page=2">2</a></li>
		    <li class="page-item"><a class="page-link" href="?page=3">3</a></li>
		    <li class="page-item">
		      <a class="page-link" href="#" aria-label="Next">
		        <span aria-hidden="true">&raquo;</span>
		      </a>
		    </li>
		  </ul>
		</nav>
	</div>
	
	
	
	<script>
		function handleClick(id){
			location.href = "./detail?id="+id;
		}
	</script>
	<c:import url="../commons/bootstrap_js.jsp"></c:import>
</body>
</html>