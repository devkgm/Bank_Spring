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
        <c:import url="../template/templateHeader.jsp"></c:import>
    </head>
    <body class="d-flex flex-column h-100">
        <c:import url="../template/navigation.jsp"></c:import>
        <main class="flex-shrink-0">
            <section style="background-color: #eee;">
              <div class="container py-5">
                <div class="row">
                  <div class="col-lg-4">
                    <div class="card mb-4">
                      <div class="card-body text-center">
                        <img src="/resources/upload/member/${member.avatarDTO.name}" alt="avatar"
                          class="rounded-circle img-fluid" style="width: 150px;">
                        <h5 class="my-3">${member.name}</h5>
                        <p class="text-muted mb-1">Full Stack Developer</p>
                        <p class="text-muted mb-4">${member.address}</p>
                        <div class="d-flex justify-content-center mb-2">
                          <button type="button" class="btn btn-primary" onclick="handleSubmit()">저장하기</button>
                          <button type="button" class="btn btn-outline-primary ms-1">비밀번호 변경</button>
                        </div>
                      </div>
                    </div>
                   </div>
                  <form class="col-lg-8" action="./update" method="POST" id="frm" enctype="multipart/form-data">
                    <input type="hidden" name="id" value="${member.id}"/>
                    <div class="card mb-4">
                      <div class="card-body">
                        <div class="row">
                          <div class="col-sm-3">
                            <p class="mb-0">이름</p>
                          </div>
                          <div class="col-sm-9">
                            <input class="text-muted mb-0 form-control" name="name" value="${member.name}" readonly>
                          </div>
                        </div>
                        <hr>
                        <div class="row">
                          <div class="col-sm-3">
                            <p class="mb-0">이메일</p>
                          </div>
                          <div class="col-sm-9">
                            <input class="text-muted mb-0 form-control" name="email" value="${member.email}" readonly>
                          </div>
                        </div>
                        <hr>
                        <div class="row">
                          <div class="col-sm-3">
                            <p class="mb-0">전화번호</p>
                          </div>
                          <div class="col-sm-9">
                            <input class="text-muted mb-0 form-control" name="phone" value="${member.phone}">
                          </div>
                        </div>
                        <hr>
                        <div class="row">
                          <div class="col-sm-3">
                            <p class="mb-0">주소</p>
                          </div>
                          <div class="col-sm-9">
                            <input class="text-muted mb-0 form-control" name="address" value="${member.address}">
                          </div>

                        </div>
                        <hr>
                        <div class="row">
                          <div class="col-sm-3">
                            <p class="mb-0">아바타</p>
                          </div>
                          <div class="col-sm-9">
                            <input type="file" class="text-muted mb-0 form-control" name="attach">
                          </div>

                        </div>
                      </div>
                    </div>
                  </form>
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
        <script>
            function handleSubmit() {
                document.getElementById("frm").submit();
            }
        </script>
    </body>
</html>
