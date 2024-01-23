package com.devkgm.app.account;


import com.devkgm.app.board.product.ProductDTO;

import java.sql.Date;

public class AccountDTO {
    private Long id;
    private Long product_id;
    private Long member_id;
    private Long account_num;
    private Integer password;
    private Date create_dt;
    private Long balance;
    private ProductDTO productDTO;

    public ProductDTO getProductDTO() {
        return productDTO;
    }

    public void setProductDTO(ProductDTO productDTO) {
        this.productDTO = productDTO;
    }

    public Long getAccount_num() {
        return account_num;
    }

    public void setAccount_num(Long account_num) {
        this.account_num = account_num;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public Long getMember_id() {
        return member_id;
    }

    public void setMember_id(Long member_id) {
        this.member_id = member_id;
    }


    public Integer getPassword() {
        return password;
    }

    public void setPassword(Integer password) {
        this.password = password;
    }

    public Date getCreate_dt() {
        return create_dt;
    }

    public void setCreate_dt(Date create_dt) {
        this.create_dt = create_dt;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }
}
