<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@taglib
prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Personal - Start Bootstrap Theme</title>
        <c:import url="../template/templateHeader.jsp"></c:import>
    </head>
    <body>
        <main class="flex-shrink-0">
            <div class="container">
                <c:import url="../template/navigation.jsp"></c:import>
            </div>
            <div class="container px-5 mb-5">
                <div class="text-center mb-5">
                    <h1 class="display-5 fw-bolder mb-0">
                        <span class="text-gradient d-inline">상품</span>
                    </h1>
                </div>
            </div>
            <section class="py-5">
                <div class="container px-4 px-lg-5 mt-5">
                    <div
                        class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-start"
                    >
                        <c:forEach items="${list }" var="item">
                            <%@ include file="../template/contentCard.jsp" %>
                        </c:forEach>
                    </div>
                </div>
                <div class="container">
                    <div class="row">
                        <div class="col-md-8 offset-md-2">
                            <c:import url="../template/searchBar.jsp"></c:import>
                        </div>
                        <div class="col-md-2 text-end">
                            <a type="button" class="btn btn-success" href="./add">글쓰기</a>
                        </div>
                    </div>
                </div>
                <div class="container">
                    <div class="row justify-content-center">
                        <div class="d-flex justify-content-center">
                            <jsp:include page="../template/pagination.jsp"></jsp:include>
                        </div>
                    </div>
                </div>
            </section>
        </main>
        <!-- Footer-->
        <c:import url="../template/footer.jsp"></c:import>
        <!-- Bootstrap core JS-->
        <c:import url="../commons/bootstrap_js.jsp"></c:import>
        <!-- Core theme JS-->
        <script src="/resources/js/scripts.js"></script>
        <script src="/resources/js/tooltip.js"></script>
        <script src="/resources/js/wishlist.js"></script>
    </body>
</html>
