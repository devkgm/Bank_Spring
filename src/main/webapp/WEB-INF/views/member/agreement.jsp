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
        <div class="container">
            <c:import url="../template/navigation.jsp"></c:import>
        </div>
        <main class="flex-shrink-0">
            <div class="container px-5 mb-5">
                <div class="text-center mb-5">
                    <h1 class="display-5 fw-bolder mb-0">
                        <span class="text-gradient d-inline">약관동의</span>
                    </h1>
                </div>
            </div>
            <section class="py-5">
                <div class="container px-4 px-lg-5 mt-5 mb-5">
                    <div class="col">
                        <div class="form-check">
                            <input
                                class="form-check-input"
                                type="checkbox"
                                value=""
                                id="checkAll"
                            />
                            <label class="form-check-label" for="checkAll"> 모두동의 </label>
                        </div>
                        <div class="form-check">
                            <input
                                class="form-check-input checks"
                                type="checkbox"
                                value=""
                                id="a1"
                            />
                            <label class="form-check-label" for="a1"> 필수동의 1 </label>
                        </div>
                        <div class="form-check">
                            <input
                                class="form-check-input checks"
                                type="checkbox"
                                value=""
                                id="a2"
                            />
                            <label class="form-check-label" for="a2"> 필수동의 2 </label>
                        </div>
                        <div class="form-check">
                            <input
                                class="form-check-input checks opts"
                                type="checkbox"
                                value=""
                                id="a3"
                            />
                            <label class="form-check-label" for="a3"> 선택동의 1 </label>
                        </div>
                        <div class="form-check">
                            <input
                                class="form-check-input checks opts"
                                type="checkbox"
                                value=""
                                id="a4"
                            />
                            <label class="form-check-label" for="a4"> 선택동의 2 </label>
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
        <script
            src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
            integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
            crossorigin="anonymous"
        ></script>
        <script src="/resources/js/agreement.js"></script>
    </body>
</html>
