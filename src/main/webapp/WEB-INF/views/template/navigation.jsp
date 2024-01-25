<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib
prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav class="navbar navbar-expand-lg navbar-light bg-white py-3">
    <div class="container px-5">
        <a class="navbar-brand" href="/"
            ><span class="fw-bolder text-primary">Start Bootstrap</span></a
        >
        <button
            class="navbar-toggler"
            type="button"
            data-bs-toggle="collapse"
            data-bs-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent"
            aria-expanded="false"
            aria-label="Toggle navigation"
        >
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ms-auto mb-2 mb-lg-0 small fw-bolder">
                <li class="nav-item"><a class="nav-link" href="/">Home</a></li>
                <li class="nav-item">
                    <a class="nav-link" href="/product/list">Product</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/notice/list">Notice</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/qna/list">Q&A</a>
                </li>
            </ul>
            <ul class="navbar-nav ms-auto mb-2 mb-lg-0 small fw-bolder">
                <c:if test="${sessionScope.member == null}">
                    <li class="nav-item"><a class="nav-link" href="/member/login">로그인</a></li>
                    <li class="nav-item">
                        <a class="nav-link" href="/member/join">회원가입</a>
                    </li>
                </c:if>
                <c:if test="${sessionScope.member!= null}">
                    <li class="nav-item">
                        <a class="nav-link" id="wishlistBtn" href="/wishlist/list" data-bs-toggle="tooltip" data-bs-placement="bottom" data-bs-title="위시리스트">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-bag-heart" viewBox="0 0 16 16">
                              <path fill-rule="evenodd" d="M10.5 3.5a2.5 2.5 0 0 0-5 0V4h5v-.5Zm1 0V4H15v10a2 2 0 0 1-2 2H3a2 2 0 0 1-2-2V4h3.5v-.5a3.5 3.5 0 1 1 7 0ZM14 14V5H2v9a1 1 0 0 0 1 1h10a1 1 0 0 0 1-1ZM8 7.993c1.664-1.711 5.825 1.283 0 5.132-5.825-3.85-1.664-6.843 0-5.132Z"/>
                            </svg>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/account/list">My자산</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/member/profile">마이페이지</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/member/logout">로그아웃</a>
                    </li>
                </c:if>
            </ul>
        </div>
    </div>
</nav>
