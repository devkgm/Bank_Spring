const password = document.getElementById('password');
const passwordCheck = document.getElementById('passwordCheck');
const submitBtn = document.getElementById('submitBtn');
const phone = document.getElementById('phone');
const username = document.getElementById('username');
const address = document.getElementById('address');
const email = document.getElementById('email');
const name = document.getElementById('name');
const frm = document.getElementById('frm');

function usernameCheck() {
    return username.value != '';
}

function emailCheck() {
    return email.value != '';
}

function nameCheck() {
    return name.value != '';
}

function phoneCheck() {
    return phone.value != '';
}

function addressCheck() {
    return address.value != '';
}
function validCheck() {
    return password.value.length > 8;
}

function equalCheck() {
    return password.value == passwordCheck.value;
}

submitBtn.addEventListener('click', function () {
    if (validCheck() && equalCheck()) {
        frm.submit();
    } else {
        alert('비밀번호를 확인하세요.');
    }
});

password.addEventListener('blur', function () {
    if (!validCheck()) {
        password.classList.add('is-invalid');
        password.classList.remove('is-valid');
    } else {
        password.classList.add('is-valid');
        password.classList.remove('is-invalid');
    }
});

passwordCheck.addEventListener('blur', function () {
    if (!equalCheck()) {
        passwordCheck.classList.add('is-invalid');
        passwordCheck.classList.remove('is-valid');
    } else {
        passwordCheck.classList.add('is-valid');
        passwordCheck.classList.remove('is-invalid');
    }
});
