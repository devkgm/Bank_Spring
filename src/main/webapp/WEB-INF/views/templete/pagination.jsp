<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<nav aria-label="Page navigation example">
    <ul class="pagination">
        <c:if test="${!pager.start }">
            <li class="page-item">
                <a
                    class="page-link pager"
                    href="#"
                    aria-label="Previous"
                    data-page="${pager.startBlock-1 }"
                >
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
        </c:if>

        <c:forEach
            begin="${pager.startBlock }"
            end="${pager.lastBlock }"
            var="i"
        >
            <li class="page-item">
                <a class="page-link pager" href="./list?page=${i }" data-page="${i}">${i }</a>
            </li>
        </c:forEach>

        <c:if test="${!pager.last }">
            <li class="page-item">
                <a
                    class="page-link pager"
                    href="#"
                    aria-label="Next"
                    data-page="${pager.lastBlock+1 }"
                >
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </c:if>
    </ul>
</nav>

