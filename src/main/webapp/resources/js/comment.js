const commentSubmitButton = document.getElementById('commentSubmitButton');
const commentForm = document.getElementById('commentForm');
const commentTable = document.getElementById('commentTable');
const product_id = document.getElementById('product_id').value;
commentSubmitButton.addEventListener('click', (e)=>{
    fetch('/comment/doAdd', {
        method: 'POST',
        body: new FormData(commentForm)
    }).then((response)=>{response.text()})
    .then((data)=>{
        commentTable.innerHTML = data.trim();
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