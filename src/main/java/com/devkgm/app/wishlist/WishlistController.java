package com.devkgm.app.wishlist;

import com.devkgm.app.account.AccountDTO;
import com.devkgm.app.board.product.ProductDTO;
import com.devkgm.app.member.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/wishlist/*")
public class WishlistController {
    @Autowired
    private WishlistService wishlistService;

    @GetMapping("doAdd")
    public String doAdd(AccountDTO accountDTO, HttpSession session, Model model) throws Exception {
        MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
        int result = 0;
        if (memberDTO != null) {
            System.out.println(memberDTO.getId());
            accountDTO.setMember_id(memberDTO.getId());
            try {
                result = wishlistService.doAdd(accountDTO);
            } catch (DuplicateKeyException e) {
                System.out.println("이미 존재하는 제품");
                result = 2;
            }

        }
        model.addAttribute("result", result);
        return "commons/ajaxResult";
    }

    @PostMapping("doDelete")
    public String doDelete(Long[] product_id, HttpSession session, Model model) throws Exception {
        MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
        HashMap<String, Object> map = new HashMap<>();

        map.put("member", memberDTO);
        map.put("nums", product_id);
        int result = wishlistService.doDelete(map);
        model.addAttribute("result", result);
        return "commons/ajaxResult";
    }

    @GetMapping("list")
    public String list(HttpSession session, Model model) throws Exception {
        MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
        if (memberDTO != null) {
            List<ProductDTO> list = wishlistService.getList(memberDTO);
            model.addAttribute("list", list);
        }
        return "wishlist/list";
    }
}
