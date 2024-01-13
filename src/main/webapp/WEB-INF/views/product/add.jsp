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
        <!-- Favicon-->
        <link
            rel="icon"
            type="image/x-icon"
            href="/resources/assets/favicon.ico"
        />
        <!-- Custom Google font-->
        <link rel="preconnect" href="https://fonts.googleapis.com" />
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
        <link
            href="https://fonts.googleapis.com/css2?family=Plus+Jakarta+Sans:wght@100;200;300;400;500;600;700;800;900&amp;display=swap"
            rel="stylesheet"
        />
        <!-- Bootstrap icons-->
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css"
            rel="stylesheet"
        />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="/resources/css/styles.css" rel="stylesheet" />
    </head>
    <body class="d-flex flex-column h-100">
        <main class="flex-shrink-0">
            <!-- Navigation-->
            <c:import url="../templete/navigation.jsp"></c:import>
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
                            <h1 class="fw-bolder">상품 추가</h1>
                            
                        </div>
                        <div class="row gx-5 justify-content-center">
                            <div class="col-lg-8 col-xl-6">
                                
                                <form
                                    id="contactForm"
                                    data-sb-form-api-token="API_TOKEN"
                                >
                                    <!-- Name input-->
                                    <div class="form-floating mb-3">
                                        <input
                                            class="form-control"
                                            id="name"
                                            type="text"
                                            placeholder="Enter your name..."
                                            data-sb-validations="required"
                                        />
                                        <label for="name">상품명 입력</label>
                                        <div
                                            class="invalid-feedback"
                                            data-sb-feedback="name:required"
                                        >
                                            상품명을 입력해주세요.
                                        </div>
                                    </div>
                                    <!-- Email address input-->
                                    <div class="form-floating mb-3">
                                        <input
                                            class="form-control"
                                            id="email"
                                            type="email"
                                            placeholder="상품 상세 설명"
                                            data-sb-validations="required,email"
                                        />
                                        <label for="description">상품 상세 설명</label>
                                        <div
                                            class="invalid-feedback"
                                            data-sb-feedback="email:required"
                                        >
                                            An email is required.
                                        </div>
                                        <div
                                            class="invalid-feedback"
                                            data-sb-feedback="email:email"
                                        >
                                            Email is not valid.
                                        </div>
                                    </div>
                                    
                                    <!-- Message input-->
                                    <div class="form-floating mb-3">
                                        <textarea
                                            class="form-control"
                                            id="message"
                                            type="text"
                                            placeholder="Enter your message here..."
                                            style="height: 10rem"
                                            data-sb-validations="required"
                                        ></textarea>
                                        <label for="message">Message</label>
                                        <div
                                            class="invalid-feedback"
                                            data-sb-feedback="message:required"
                                        >
                                            A message is required.
                                        </div>
                                    </div>
                                    <!-- Submit success message-->
                                    <!---->
                                    <!-- This is what your users will see when the form-->
                                    <!-- has successfully submitted-->
                                    <div
                                        class="d-none"
                                        id="submitSuccessMessage"
                                    >
                                        <div class="text-center mb-3">
                                            <div class="fw-bolder">
                                                Form submission successful!
                                            </div>
                                            To activate this form, sign up at
                                            <br />
                                            <a
                                                href="https://startbootstrap.com/solution/contact-forms"
                                                >https://startbootstrap.com/solution/contact-forms</a
                                            >
                                        </div>
                                    </div>
                                    <!-- Submit error message-->
                                    <!---->
                                    <!-- This is what your users will see when there is-->
                                    <!-- an error submitting the form-->
                                    <div class="d-none" id="submitErrorMessage">
                                        <div
                                            class="text-center text-danger mb-3"
                                        >
                                            Error sending message!
                                        </div>
                                    </div>
                                    <!-- Submit Button-->
                                    <div class="d-grid">
                                        <button
                                            class="btn btn-primary btn-lg disabled"
                                            id="submitButton"
                                            type="submit"
                                        >
                                            Submit
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
        <c:import url="../templete/footer.jsp"></c:import>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="/resources/js/scripts.js"></script>
    </body>
</html>
