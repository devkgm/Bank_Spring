const commentSubmitButton = document.getElementById('commentSubmitButton');
const commentForm = document.getElementById('commentForm');
const commentTable = document.getElementById('commentTable');
const product_id = document.getElementById('product_id').value;
const replyContents = document.getElementById('replyContents');
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