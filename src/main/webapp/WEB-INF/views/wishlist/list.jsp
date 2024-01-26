<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@taglib
prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en" data-bs-theme="dark">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>${board }</title>
        <c:import url="../template/templateHeader.jsp"></c:import>
        <style>
            tr:hover {
                cursor: pointer;
            }
        </style>
        <c:import url="../commons/jquery.jsp"></c:import>
    </head>
    <body class="d-flex flex-column h-100">
        <main class="flex-shrink-0">
            <!-- Navigation-->
            <div class="container mb-3">
                <div class="row">
                    <c:import url="../template/navigation.jsp"></c:import>
                </div>
            </div>

            <div class="container px-5 mb-5">
                <div class="text-center mb-5">
                    <h1 class="display-5 fw-bolder mb-0">
                        <span class="text-gradient d-inline">위시리스트</span>
                    </h1>
                </div>
            </div>
            <section class="py-5">
                <div class="container px-4 px-lg-5 mt-5 mb-5">
                    <div
                        class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center"
                    >


                        <table class="table table-hover">
                            <tr>
                                <th>
                                    <input type="checkbox" name="check" id="checkAll" /> 전체선택
                                </th>
                                <th>내용</th>
                                <th>이율</th>
                            </tr>
                            <c:forEach items="${list }" var="item" varStatus="status">
                                <tr>
                                    <td>
                                        <input class="checkbox" type="checkbox" name="product_id" value="${item.id}" id="product_id${item.id}"/>
                                    </td>
                                    <td onclick="location.href='/product/detail/${item.id}'">
                                        ${item.name }
                                    </td>
                                    <td>${item.rate }</td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </div>
                <div class="container">
                    <div class="row">
                        <div class="col-md-8 offset-md-2 d-flex justify-content-center">
                            <c:import url="../template/searchBar.jsp"></c:import>
                        </div>
                        <div class="col-md-2 text-end">
                            <c:if test="${member != null}">
                                <button id="deleteBtn" type="button" class="btn btn-success float-right"
                                    >삭제</a
                                >
                            </c:if>
                        </div>
                    </div>
                </div>
                <div class="container">
                    <div class="row">
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
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="/resources/js/scripts.js"></script>
        <script src="/resources/js/search.js"></script>

        <script>
            const deleteBtn = document.getElementById('deleteBtn');
            const checkboxs = document.getElementsByClassName('checkbox');
            const product_id = [];
            for(checkbox of checkboxs) {
                checkbox.addEventListener('change', function() {
                    if(this.checked) {
                        product_id.push(this.value);
                    } else {
                        product_id.splice(product_id.indexOf(this.value), 1);
                    }
                })
            }
            deleteBtn.addEventListener('click', function() {
                $.ajax({
                    url: '/wishlist/doDelete',
                    type: 'POST',
                    traditional: true,
                    data: {
                        product_id: product_id
                    },
                    success: function(data) {
                        for(id of product_id) {
                            $("#product_id" + id).parent().parent().remove();
                        }
                    }
                })
            })
        </script>
    </body>
</html>
