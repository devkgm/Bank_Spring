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
    <body class="d-flex flex-column h-100">
        <div class="container mb-3">
            <c:import url="../template/navigation.jsp"></c:import>
        </div>

        <div class="container h-100 align-items-center d-flex">
                <div class="card text-black h-auto" style="border-radius: 25px">
                    <div class="card-body p-md-5">
                        <div class="row justify-content-center">
                            <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">
                                <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">로그인</p>
                                <div>${message}</div>
                                <form class="mx-1 mx-md-4" action="./login" method="POST">
                                    <div class="d-flex flex-row align-items-center mb-2">
                                        <div class="form-outline flex-fill mb-0">
                                            <label class="form-label" for="username">아이디</label>
                                            <input
                                                type="text"
                                                id="username"
                                                class="form-control"
                                                name="username"
                                            />
                                        </div>
                                    </div>

                                    <div class="d-flex flex-row align-items-center mb-5">
                                        <div class="form-outline flex-fill mb-0">
                                            <label class="form-label" for="password"
                                                >비밀번호</label
                                            >
                                            <input
                                                type="password"
                                                id="password"
                                                class="form-control"
                                                name="password"
                                            />
                                        </div>
                                    </div>

                                    <div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
                                        <button type="submit" class="btn btn-primary btn-lg">
                                            로그인
                                        </button>
                                    </div>
                                </form>
                            </div>
                            <div
                                class="col-md-10 col-lg-6 col-xl-7 d-flex align-items-center order-1 order-lg-2"
                            >
                                <img
                                    src="/resources/assets/iu.png"
                                    class="img-fluid"
                                    alt="Sample image"
                                />
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Footer-->
        <c:import url="../template/footer.jsp"></c:import>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="/resources/js/scripts.js"></script>
    </body>
</html>
