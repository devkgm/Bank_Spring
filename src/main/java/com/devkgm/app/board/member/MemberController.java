package com.devkgm.app.board.member;

import oracle.ucp.proxy.annotation.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Member;

@Controller
@RequestMapping("/member/*")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @GetMapping("update")
    public void update(MemberDTO memberDTO, Model model, HttpSession session) throws Exception {
        model.addAttribute("member", (MemberDTO) session.getAttribute("member"));
    }

    @PostMapping("update")
    public String update(MemberDTO memberDTO, Model model, MultipartFile attach) throws Exception {
        int result = memberService.update(memberDTO, attach);
        return "redirect:/member/profile";
    }

    @GetMapping("logout")
    public String logout(HttpSession session) throws Exception {
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("login")
    public String login() throws Exception {
        return "member/login";
    }

    @PostMapping("login")
    public String login(MemberDTO memberDTO, Model model, HttpSession session) throws Exception {
        memberDTO = memberService.getDetail(memberDTO);
        if (memberDTO == null) {
            model.addAttribute("message", "아이디 또는 비밀번호를 확인하세요.");
            return "member/login";
        }
        session.setAttribute("member", memberDTO);
        model.addAttribute("member", memberDTO);
        return "redirect:/";
    }


    @GetMapping("join")
    public void join() throws Exception {
    }

    @PostMapping("join")
    public String join(MemberDTO memberDTO, Model model, MultipartFile attach) throws Exception {
        int result = memberService.join(memberDTO, attach);
        String message = "회원가입에 성공했습니다.";
        if (result == 0) {
            message = "회원가입에 실패했습니다.";
        }
        model.addAttribute("member", memberDTO);
        String path = "member/login";
        model.addAttribute("message", message);
        model.addAttribute("path", path);
        return "commons/result";
    }

    @GetMapping("profile")
    public String profile(MemberDTO memberDTO, Model model, HttpSession session) throws Exception {
        memberDTO = memberService.getDetail((MemberDTO) session.getAttribute("member"));
        if (memberDTO == null) {
            return "redirect:/";
        }
        model.addAttribute("member", memberDTO);
        return "member/profile";
    }


}
