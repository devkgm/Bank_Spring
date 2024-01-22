// const checkBoxs = document.getElementsByClassName('checks');
// const checkAll = document.getElementById('checkAll');

// //다른 체크박스 체크 해제 시 모두 동의 체크박스 해제
// for (let i = 0; i < checkBoxs.length; i++) {
//     checkBoxs[i].addEventListener('change', function (e) {
//         if (e.target.checked == false) {
//             checkAll.checked = false;
//         }
//     });
// }

// // 모두 동의 클릭 시 모두클릭 버튼 체크 상태 확인후 다른 체크박스 상태 모두 동일하게
// checkAll.addEventListener('change', function (event) {
//     const state = event.target.checked;
//     for (let i = 0; i < checkBoxs.length; i++) {
//         checkBoxs[i].checked = state;
//     }
// });

$('#checkAll').click(() => {
    $('.checks').prop('checked', $('#checkAll').prop('checked'));
});

$('.checks').click(function () {
    if ($(this).prop('checked') == false) {
        $('#checkAll').prop('checked', false);
    }
    let temp = true;
    $('.checks').each(function (index, e) {
        if ($(e).prop('checked') == false) temp = false;
    });
    if (temp == true) {
        $('#checkAll').prop('checked', true);
    }
});
