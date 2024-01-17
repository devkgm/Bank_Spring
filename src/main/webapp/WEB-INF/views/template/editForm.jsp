<form
    id="productForm"
    action="./add"
    method="POST"
    enc-type="multipart/form-data"
>
    <!-- Name input-->
    <div class="form-floating mb-3">
        <input type="hidden" name="id" value="${dto.id }">
        <input
            class="form-control"
            id="name"
            type="text"
            name="title"
            data-sb-validations="required"
        />
        <label for="name">제목 입력</label>
        <div
            class="invalid-feedback"
            data-sb-feedback="name:required"
        >
            제목을 입력해주세요.
        </div>
    </div>
    <!-- Rate input-->
    <div class="form-floating mb-3">
        <input
            class="form-control"
            id="rate"
            type="text"
            name="writer"
            data-sb-validations="required"
        ></input>
        <label for="rate">이름</label>
        <div
            class="invalid-feedback"
            data-sb-feedback="message:required"
        >
            이름을 기입해주세요.
        </div>
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


    <div class="mb-3">
      <label for="formFileMultiple" class="form-label">썸네일</label>
      <input class="form-control" type="file" id="formFileMultiple" name="attach" accept="image/png, image/jpeg" multiple>
    </div>

    <!-- 제출 -->
    <div class="d-grid">
        <button
            class="btn btn-primary btn-lg"
            id="submitButton"
            type="submit"
        >
            상품 등록
        </button>
    </div>
</form>