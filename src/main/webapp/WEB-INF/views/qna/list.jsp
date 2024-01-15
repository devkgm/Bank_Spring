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
        <c:import url="../templete/templeteHeader.jsp"></c:import>
    </head>
    <body class="d-flex flex-column h-100">
        <main class="flex-shrink-0">
            <!-- Navigation-->
            <c:import url="../templete/navigation.jsp"></c:import>
            <div class="container px-5 mb-5">
                <div class="text-center mb-5">
                    <h1 class="display-5 fw-bolder mb-0">
                        <span class="text-gradient d-inline">Q&A</span>
                    </h1>
                </div>
            </div>
            <section class="py-5">
                <div class="container px-4 px-lg-5 mt-5">
                    <div
                        class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center"
                    >
                        <c:forEach items="${list }" var="item">
                            <div
                                onclick="location.href = './detail/${item.id }'"
                            >
                                <%@ include file="../templete/contentCard.jsp"
                                %>
                            </div>
                        </c:forEach>
                    </div>
                    <div
                        class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center"
                    >
                        <jsp:include
                            page="../templete/pagination.jsp"
                        ></jsp:include>
                    </div>

                    <a type="button" class="btn btn-success" href="./add"
                        >글쓰기</a
                    >
                </div>
            </section>
        </main>
        <!-- Footer-->
        <c:import url="../templete/footer.jsp"></c:import>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="/resources/js/scripts.js"></script>
    </body>
</html>
