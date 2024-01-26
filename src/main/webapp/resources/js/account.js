const accountForm = document.getElementById('accountForm');
const password = document.getElementById('password');
const passwordCheck = document.getElementById('passwordCheck');
const submitButton = document.getElementById('submitButton');

const state = {password: false, passwordCheck: false};

submitButton.addEventListener('click', (e)=>{
    if(state.password && state.passwordCheck) {
        accountForm.submit();
    } else {
        alert('비밀번호를 확인해주세요.');

    }
})

password.addEventListener('blur', (e)=>{
   if(e.target.value.length != 4) {
        alert('비밀번호는 4글자 이상이어야 합니다.');
        password.value = '';
        state.password = false;
        password.classList.remove('is-valid');
        password.classList.add('is-invalid');
   } else {
        state.password = true;
        password.classList.add('is-valid');
        password.classList.remove('is-invalid');
    }
})

passwordCheck.addEventListener('blur', (e)=>{
    if(password.value!= passwordCheck.value) {
        alert('비밀번호가 일치하지 않습니다.');
        passwordCheck.value = '';
        state.passwordCheck = false;
        passwordCheck.classList.remove('is-valid');
        passwordCheck.classList.add('is-invalid');
    } else {
        state.passwordCheck = true;
        passwordCheck.classList.add('is-valid');
        passwordCheck.classList.remove('is-invalid');
    }
})