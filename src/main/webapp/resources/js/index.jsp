<script>
    const parsingUrl = (parameterName) => {
        const parsing1 = location.href.split(parameterName + "=");
        if (parsing1.length == 2) {
            return parsing1[1].split("&")[0];
        } else {
            return false;
        }
    };
    const pageContents = document.getElementsByClassName("page-content");
    if (parsingUrl("page")) {
        const page = parsingUrl("page");
        for (let i = 0; i < pageContents.length; i++) {
            console.log(pageContents[i].innerHTML);
            if (pageContents[i].innerHTML == page) {
                pageContents[i].parentElement.classList.add("active");
            }
        }
    }
    if (parsingUrl("search")) {
        const search = parsingUrl("search");
        const searchInput = document.getElementById("search");
        searchInput.value = search;
    }
    if (parsingUrl("kind")) {
        const kind = parsingUrl("kind");
        const selectInput = document.getElementById("select");
        selectInput.value = kind;
    }
    const perPageSelect = document.getElementById("perPageSelect");

    if (parsingUrl("perPage")) {
        const perPage = parsingUrl("perPage");
        perPageSelect.value = perPage;
    }
    perPageSelect.addEventListener("change", function () {
        const frm = document.getElementById("frm");
        const perPageInput = document.getElementById("perPageInput");
        console.log(perPageSelect.value);
        perPageInput.value = perPageSelect.value;
        frm.submit();
    });

    function handleClick(id) {
        location.href = "./detail?id=" + id;
    }
</script>
