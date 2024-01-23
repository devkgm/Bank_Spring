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
        <c:import url="../template/navigation.jsp"></c:import>
        <main class="flex-shrink-0">
            <section class="vh-80" style="background-color: #eee">
                <div class="container h-80">
                    <div class="row d-flex justify-content-center align-items-center h-80">
                        <div class="col-lg-12 col-xl-11">
                            <div class="card text-black" style="border-radius: 25px">
                                <div class="card-body p-md-5">
                                    <div class="row justify-content-center">
                                        <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">
                                            <p
                                                class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4"
                                            >
                                                회원가입
                                            </p>

                                            <form
                                                class="mx-1 mx-md-4"
                                                action="./join"
                                                method="POST"
                                                enctype="multipart/form-data"
                                                id="frm"
                                            >
                                                <div
                                                    class="d-flex flex-row align-items-center mb-2"
                                                >
                                                    <div class="form-outline flex-fill mb-0">
                                                        <label class="form-label" for="name"
                                                            >이름</label
                                                        >
                                                        <input
                                                            type="text"
                                                            id="name"
                                                            class="form-control"
                                                            name="name"
                                                        />
                                                    </div>
                                                </div>

                                                <div
                                                    class="d-flex flex-row align-items-center mb-2"
                                                >
                                                    <div class="form-outline flex-fill mb-0">
                                                        <label class="form-label" for="email"
                                                            >이메일</label
                                                        >
                                                        <input
                                                            type="email"
                                                            id="email"
                                                            class="form-control"
                                                            name="email"
                                                        />
                                                    </div>
                                                </div>

                                                <div
                                                    class="d-flex flex-row align-items-center mb-2"
                                                >
                                                    <div class="form-outline flex-fill mb-0">
                                                        <label class="form-label" for="address"
                                                            >주소</label
                                                        >
                                                        <input
                                                            type="text"
                                                            id="address"
                                                            class="form-control"
                                                            name="address"
                                                        />
                                                        <label class="form-label" for="address"
                                                            >상세주소</label
                                                        >
                                                        <input
                                                            type="text"
                                                            id="detailAddress"
                                                            class="form-control mb-1"
                                                            name="detailAddress"
                                                        />
                                                        <button
                                                            type="button"
                                                            class="form-outline btn btn-outline-primary btn-block"
                                                            onclick="handleSearch()"
                                                        >
                                                            주소 찾기
                                                        </button>
                                                    </div>
                                                </div>

                                                <div
                                                    class="d-flex flex-row align-items-center mb-2"
                                                >
                                                    <div class="form-outline flex-fill mb-0">
                                                        <label class="form-label" for="phone"
                                                            >전화번호</label
                                                        >
                                                        <input
                                                            type="text"
                                                            id="phone"
                                                            class="form-control"
                                                            name="phone"
                                                        />
                                                    </div>
                                                </div>

                                                <div
                                                    class="d-flex flex-row align-items-center mb-2"
                                                >
                                                    <div class="form-outline flex-fill mb-0">
                                                        <label class="form-label" for="username"
                                                            >아이디</label
                                                        >
                                                        <input
                                                            type="text"
                                                            id="username"
                                                            class="form-control"
                                                            name="username"
                                                        />
                                                    </div>
                                                </div>

                                                <div
                                                    class="d-flex flex-row align-items-center mb-2"
                                                >
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

                                                <div
                                                    class="d-flex flex-row align-items-center mb-2"
                                                >
                                                    <div class="form-outline flex-fill mb-0">
                                                        <label
                                                            class="form-label"
                                                            for="passwordCheck"
                                                            >비밀번호 확인</label
                                                        >
                                                        <input
                                                            type="password"
                                                            id="passwordCheck"
                                                            class="form-control"
                                                        />
                                                    </div>
                                                </div>
                                                <div
                                                    class="d-flex flex-row align-items-center mb-2"
                                                >
                                                    <div class="form-outline flex-fill mb-0">
                                                        <label class="form-label" for="avatar"
                                                            >아바타</label
                                                        >
                                                        <input
                                                            type="file"
                                                            id="avatar"
                                                            class="form-control"
                                                            name="attach"
                                                        />
                                                    </div>
                                                </div>

                                                <div
                                                    class="form-check d-flex justify-content-center mb-5"
                                                >
                                                    <input
                                                        class="form-check-input me-2"
                                                        type="checkbox"
                                                        value=""
                                                        id="agree"
                                                    />
                                                    <label class="form-check-label" for="agree">
                                                        <a href="#!">서비스 정책</a>에 동의합니다.
                                                    </label>
                                                </div>

                                                <div
                                                    class="d-flex justify-content-center mx-4 mb-3 mb-lg-4"
                                                >
                                                    <button
                                                        id="submitBtn"
                                                        type="button"
                                                        class="btn btn-primary btn-lg"
                                                    >
                                                        회원가입
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
                </div>
            </section>
        </main>
        <!-- Footer-->
        <c:import url="../template/footer.jsp"></c:import>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="/resources/js/scripts.js"></script>
        <script src="/resources/js/joinCheck.js"></script>
        <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
        <script>
            const handleSearch = () => {
                new daum.Postcode({
                    oncomplete: function (data) {
                        const address = document.getElementById('address');
                        const detailAddress = document.getElementById('detailAddress');
                        address.value = data.address;
                    },
                }).open();
            };
        </script>
    </body>
</html>
