<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav aria-label="Page navigation example">
  <ul class="pagination">
  	<c:if test="${!pager.start }">
  		<li class="page-item">
	      <a class="page-link" href="./list?page=${pager.lastBlock-1 }" aria-label="Previous">
	        <span aria-hidden="true">&laquo;</span>
	      </a>
	    </li>
  	</c:if>
    
    <c:forEach begin="${pager.startBlock }" end="${pager.lastBlock }" var="i">
    	<li class="page-item"><a class="page-link" href="./list?page=${i }">${i }</a></li>
    </c:forEach>
    
    <c:if test="${!pager.last }">
    	<li class="page-item">
	      <a class="page-link" href="./list?page=${pager.lastBlock+1 }" aria-label="Next">
	        <span aria-hidden="true">&raquo;</span>
	      </a>
	    </li>
    </c:if>
    
  </ul>
</nav>