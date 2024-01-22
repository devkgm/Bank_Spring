<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form action="./list" id="frm" class="w-100">
    <input type="hidden" name="page" value="1" id="page" />
    <div class="input-group mb-3">
        <select class="form-select w-10" name="kind" aria-label="Default select example">
            <option value="title">제목</option>
            <option value="writer">글쓴이</option>
            <option value="content">내용</option>
        </select>
        <input
            type="text"
            name="search"
            value="${pager.search }"
            class="form-control"
            style="width: 60%"
            placeholder="검색어를 입력하세요."
            aria-label="Recipient's username"
            aria-describedby="button-addon2"
        />
        <button class="btn btn-outline-secondary w-10" type="submit" id="button-addon2">
            검색
        </button>
    </div>
</form>
