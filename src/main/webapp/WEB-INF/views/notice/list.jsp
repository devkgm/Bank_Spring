<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../commons/bootstrap_css.jsp"></c:import>

</head>
<body>
	<c:import url="../commons/navigation.jsp"></c:import>
	
	<div class="container-sm">
		<h1>공지사항</h1>
		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th>ID</th>
					<th>TITLE</th>
					<th>DATE</th>
					<th>HIT</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${requestScope.dtoList}" var="item">
					<tr onclick="handleClick(${item.id })">
						<td>${item.id }</td>
						<td>${item.title }</td>
						<td>${item.create_dt }</td>
						<td>${item.hit }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a class="btn btn-primary" href="./add">글작성</a>
	</div>
	<script>
		function handleClick(id){
			location.href = "./detail?id="+id;
		}
	</script>
	<c:import url="../commons/bootstrap_js.jsp"></c:import>
</body>
</html>