<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>제품</title>
        <c:import url="../commons/bootstrap_css.jsp"></c:import>
    </head>
    <body>
        <c:import url="../commons/navigation.jsp"></c:import>

        <div class="container-sm text-center">
            <div>
                <h1>상품 리스트</h1>
            </div>
            <br />
            <div class="row justify-content-sm-end">
                <div class="col-sm-auto">
                    <select
                        class="form-select"
                        aria-label="Default select example"
                        id="perPageSelect"
                    >
                        <option selected value="10">10</option>
                        <option value="25">25</option>
                        <option value="50">50</option>
                    </select>
                </div>
                <span class="col-sm-auto"> 개씩 보기 </span>
            </div>
            <br />
            <div>
                <table class="table table-striped table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>NAME</th>
                            <th>RATE</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${requestScope.list}" var="item">
                            <tr onclick="handleClick(${item.id })">
                                <td>${item.id }</td>
                                <td>${item.name }</td>
                                <td>${item.rate }%</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <br />
            <div class="row justify-content-sm-end">
                <div class="col-sm-2">
                    <a class="btn btn-primary" href="./add">상품추가</a>
                </div>
            </div>
            <br />
            <div class="row justify-content-lg-center">
                <div class="col-lg-auto">
                    <form action="./list" method="get" id="frm">
                        <div class="input-group mb-3">
                            <select
                                class="form-select"
                                aria-label="Default select example"
                                name="kind"
                                id="select"
                            >
                                <option value="1" selected>상품명</option>
                                <option value="2">상품번호</option>
                                <option value="3">이자율</option>
                            </select>
                            <input
                                type="hidden"
                                name="perPage"
                                value="10"
                                id="perPageInput"
                            />
                            <input type="hidden" name="page" value="1" />
                            <input
                                type="text"
                                id="search"
                                class="form-control"
                                placeholder="검색어를 입력해주세요."
                                aria-label="검색어를 입력해주세요."
                                aria-describedby="button-addon2"
                                name="search"
                            />
                            <button
                                class="btn btn-outline-secondary"
                                type="submit"
                                id="button-addon2"
                            >
                                검색
                            </button>
                        </div>
                    </form>
                </div>
            </div>
            <br />
            <div class="row justify-content-lg-center">
                <div class="col-lg-auto">
                    <nav aria-label="Page navigation example">
                        <ul class="pagination pagination-lg">
                            <c:if test="${ !pager.start }">
                                <li class="page-item">
                                    <a
                                        class="page-link"
                                        href="./list?page=${pager.startPage - 1}&search=${pager.search}&kind=${pager.kind}&perPage=${pager.perPage}"
                                        aria-label="Previous"
                                    >
                                        <span aria-hidden="true">&laquo;</span>
                                    </a>
                                </li>
                            </c:if>
                            <c:forEach
                                begin="${pager.startPage }"
                                end="${ pager.lastPage }"
                                var="i"
                            >
                                <li class="page-item">
                                    <a
                                        class="page-link page-content"
                                        href="./list?page=${i }&search=${pager.search}&kind=${pager.kind}&perPage=${pager.perPage}"
                                        >${i }</a
                                    >
                                </li>
                            </c:forEach>
                            <c:if test="${!pager.last }">
                                <li class="page-item">
                                    <a
                                        class="page-link"
                                        href="./list?page=${ pager.lastPage + 1 }&search=${pager.search}&kind=${pager.kind}&perPage=${pager.perPage}"
                                        aria-label="Next"
                                    >
                                        <span aria-hidden="true">&raquo;</span>
                                    </a>
                                </li>
                            </c:if>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>

        <c:import url="../commons/bootstrap_js.jsp"></c:import>
        <c:import url="/resources/js/index.jsp"></c:import>
        <script
            src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
            integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
            crossorigin="anonymous"
        ></script>
        <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.min.js"
            integrity="sha384-Rx+T1VzGupg4BHQYs2gCW9It+akI2MM/mndMCy36UVfodzcJcF0GGLxZIzObiEfa"
            crossorigin="anonymous"
        ></script>
    </body>
</html>
