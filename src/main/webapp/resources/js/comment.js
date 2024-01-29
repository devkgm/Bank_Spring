const commentSubmitButton = document.getElementById('commentSubmitButton');
const commentForm = document.getElementById('commentForm');
const commentTable = document.getElementsByTagName('tbody')[0];
const product_id = document.getElementById('product_id').value;
const replyContents = document.getElementById('replyContents');

$(document).on('click', '#more', async function () {
    let page = $('#more').attr('data-bs-commentPage') * 1 + 1;
    const lastBlock = $('#more').attr('data-bs-lastBlock');
    if (page > lastBlock) {
        alert('마지막 댓글입니다.');
        return;
    }
    const data = await getComment(page);
    commentTable.innerHTML += createTable(data.list);
    $('#more').attr('data-bs-commentPage', page);
    more.innerHTML = `더보기(${page}/${data.pager.lastBlock})`;
});

async function getComment(page) {
    const response = await fetch(`/comment/getList?product_id=${product_id}&page=${page}`);
    const data = await response.json();

    return data;
}

commentSubmitButton.addEventListener('click', (e) => {
    fetch('/comment/doAdd', {
        method: 'POST',
        body: new FormData(commentForm),
    })
        .then((response) => response.text())
        .then(async (data) => {
            if (data.trim() == 'login') {
                alert('로그인이 필요합니다.');
            } else {
                const data = await getComment(1);
                commentTable.innerHTML = createTable(data.list);
                alert('리뷰가 등록 됐습니다.');
                const more = document.getElementById('more');
                more.setAttribute('data-bs-commentPage', 1);
                more.setAttribute('data-bs-lastBlock', data.pager.lastBlock);
                more.innerHTML = `더보기(1/${data.pager.lastBlock})`;
                replyContents.value = '';
            }
        });
});

document.addEventListener('DOMContentLoaded', async function () {
    const data = await getComment(1);
    console.log(data);
    commentTable.innerHTML += createTable(data.list);
    const more = document.getElementById('more');
    const page = more.getAttribute('data-bs-commentPage');
    more.setAttribute('data-bs-lastBlock', data.pager.lastBlock);
    more.innerHTML = `더보기(${page}/${data.pager.lastBlock})`;
});

function createTable(data) {
    return data
        .map((item) => {
            const date = new Date(item.create_dt).toLocaleString('ko-KR');
            return `
                        <tr>
                            <td>${item.content}</td>
                            <td>${item.rate}</td>
                            <td>${item.name}</td>
                            <td>${date}</td>
                        </tr>
                        `;
        })
        .join('');
}
