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
        <c:import url="../commons/summernote.jsp"></c:import>
    </head>
    <body class="d-flex flex-column h-100">
        <main class="flex-shrink-0">
            <!-- Navigation-->
            <c:import url="../template/navigation.jsp"></c:import>
            <!-- Page content-->
            <section class="py-5">
                <div class="container px-5">
                    <!-- Contact form-->
                    <div class="bg-light rounded-4 py-5 px-4 px-md-5">
                        <div class="text-center mb-5">
                            <div
                                class="feature bg-primary bg-gradient-primary-to-secondary text-white rounded-3 mb-3"
                            >
                                <i class="bi bi-envelope"></i>
                            </div>
                            <h1 class="fw-bolder">상품 가입</h1>
                        </div>
                        <div class="row gx-5 justify-content-center">
                            <div class="col-lg-8 col-xl-6">
                                <form id="accountForm" action="./add" method="POST">
                                    <!-- Name input-->
                                    <div class="form-floating mb-3">
                                        <input type="hidden" name="product_id" value="${dto.id }" />
                                        <input
                                            class="form-control"
                                            id="name"
                                            type="text"
                                            value="${dto.name }"
                                            name="name"
                                            data-sb-validations="required"
                                            readonly
                                        />
                                        <label for="name">상품명</label>
                                    </div>
                                    <!-- 컨텐츠 -->
                                    <div class="form-floating mb-3">
                                        <input
                                            type="hidden"
                                            class="form-control"
                                            id="content"
                                            name="content"
                                        />
                                        <div id="summernote"></div>
                                    </div>

                                    <!-- Rate input-->
                                    <div class="form-floating mb-3">
                                        <input
                                            class="form-control"
                                            id="rate"
                                            type="text"
                                            name="rate"
                                            value="${dto.rate }"
                                            data-sb-validations="required"
                                            readonly
                                        />
                                        <label for="rate">이율</label>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <input
                                            class="form-control"
                                            id="password"
                                            type="password"
                                            name="password"
                                            data-sb-validations="required"
                                        />
                                        <label for="rate">비밀번호</label>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <input
                                            class="form-control"
                                            id="passwordCheck"
                                            type="password"
                                            name="passwordCheck"
                                            data-sb-validations="required"
                                        />
                                        <label for="rate">비밀번호 확인</label>
                                    </div>
                                    <!-- 제출 -->
                                    <div class="d-grid">
                                        <button
                                            class="btn btn-primary btn-lg"
                                            id="submitButton"
                                            type="submit"
                                        >
                                            상품 가입
                                        </button>
                                    </div>
                                </form>
                            </div>
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
        <script src="/resources/js/summernote.js"></script>
    </body>
</html>
