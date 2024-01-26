package com.devkgm.app.comment;

import com.devkgm.app.board.BoardPager;
import com.devkgm.app.member.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/comment/*")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("doAdd")
    public String doAdd(CommentDTO commentDTO, Model model, HttpSession session, BoardPager pager) throws Exception {
        pager.setPerPage(5l);
        MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
        if (memberDTO == null) {
            model.addAttribute("result", "login");
            return "commons/ajaxResult";
        }
        commentDTO.setMember_id(memberDTO.getId());
        System.out.println(commentDTO.getContent());
        int result = commentService.doAdd(commentDTO);
        List<CommentDTO> list = commentService.getList(commentDTO, pager);
        model.addAttribute("list", list);
        return "commons/commentResult";
    }

    @GetMapping("getList")
    public String getList(CommentDTO commentDTO, Model model, BoardPager pager) throws Exception {
        pager.setPerPage(5l);

        List<CommentDTO> list = commentService.getList(commentDTO, pager);
        
        model.addAttribute("pager", pager);
        model.addAttribute("list", list);
        return "commons/commentResult";
    }
}
