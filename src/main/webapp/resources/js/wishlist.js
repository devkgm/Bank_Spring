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
                    const wishlistBtn = bootstrap.Tooltip.getInstance("#wishlistBtn");
                    wishlistBtn.setContent({ '.tooltip-inner': '상품을 위시리스트에 추가했어요.' });
                    wishlistBtn.show();
                    setTimeout(()=>{
                        wishlistBtn.hide();
                        wishlistBtn.setContent({ '.tooltip-inner': '위시리스트' });
                    },3000)

                }
            });
    });
}
