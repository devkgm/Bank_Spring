package com.devkgm.app.account;

import com.devkgm.app.board.BoardPager;
import com.devkgm.app.board.product.ProductDAO;
import com.devkgm.app.board.product.ProductDTO;
import com.devkgm.app.member.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/account/*")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private ProductDAO productDAO;

    @GetMapping("add")
    public void add(ProductDTO productDTO, Model model) throws Exception {
        productDTO = productDAO.getDetail(productDTO);
        model.addAttribute("dto", productDTO);
    }

    @PostMapping("add")
    public String add(AccountDTO accountDTO, Model model, HttpSession session) throws Exception {
        MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
        accountDTO.setMember_id(memberDTO.getId());
        accountService.doAdd(accountDTO);
        return "redirect:/account/list";
    }

    @GetMapping("list")
    public void getList(AccountDTO accountDTO, Model model, HttpSession session, BoardPager pager) throws Exception {
        MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
        List<AccountDTO> accountDTOs = accountService.getList(memberDTO, pager);
        model.addAttribute("list", accountDTOs);
    }
}
