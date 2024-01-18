package com.devkgm.app.board.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member/*")
public class MemberController {
    @Autowired
    private MemberService memberService;


    @GetMapping("join")
    public void join() throws Exception {
    }

    @PostMapping("join")
    public String join(MemberDTO memberDTO, Model model) throws Exception {
        int result = memberService.join(memberDTO);
        model.addAttribute("member", memberDTO);
        return "member/profile";
    }

    @GetMapping("profile")
    public String profile(MemberDTO memberDTO, Model model) throws Exception {
        memberDTO = memberService.getMemberInfo();
        model.addAttribute("member", memberDTO);
        return "member/profile";
    }


}
