const commentSubmitButton = document.getElementById('commentSubmitButton');
const commentForm = document.getElementById('commentForm');
const commentTable = document.getElementsByTagName('tbody')[0];
const product_id = document.getElementById('product_id').value;
const replyContents = document.getElementById('replyContents');

$(document).on('click',"#more",function(){
    const page = $("#more").attr("data-bs-commentPage")
    fetch('/comment/getList?product_id='+product_id+"&page="+(page*1+1))
        .then((response)=>response.text())
        .then((data)=>{
            commentTable.innerHTML += data;
        })
})
const btn = `<button id="more" data-bs-commentPage="1" class="btn btn-primary">더보기(${start}/${end})</button>`

commentSubmitButton.addEventListener('click', (e)=>{
    fetch('/comment/doAdd', {
        method: 'POST',
        body: new FormData(commentForm)
    }).then((response)=>response.text())
    .then((data)=>{
        if(data.trim() == 'login'){
            alert("로그인이 필요합니다.")
        } else {
            commentTable.innerHTML = data.trim();
            alert("리뷰가 등록 됐습니다.")
            replyContents.value = '';
        }

    })
})

document.addEventListener("DOMContentLoaded", function(){
    fetch('/comment/getList?product_id='+product_id)
        .then((response)=>response.text())
        .then((data)=>{
            console.log(data);
            commentTable.innerHTML = data;
        })
})