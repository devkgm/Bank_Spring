const button = document.getElementsByClassName('wishlist');

for (b of button) {
    b.addEventListener('click', function () {
        const product_id = b.getAttribute('data-product-id');
        fetch(`/wishlist/doAdd?product_id=` + product_id, {
            method: 'GET',
            headers: {
                'Content-Type': 'x-www-form-urlencoded',
            },
        })
            .then((response) => response.text())
            .then((data) => {
                data = Number(data.trim());
                if (data == 0) {
                    alert('로그인이 필요합니다.');
                } else if (data > 0) {
                    if (confirm('위시리스트로 이동하시겠습니까?')) {
                        location.href = '/wishlist/list';
                    }
                }
            });
    });
}
