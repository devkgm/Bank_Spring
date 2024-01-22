package com.devkgm.app.interceptors;

import com.devkgm.app.board.BoardDTO;
import com.devkgm.app.member.MemberDTO;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class WriterCheckInterceptor extends HandlerInterceptorAdapter {

    
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        BoardDTO boardDTO = (BoardDTO) modelAndView.getModel().get("dto");
        HttpSession session = request.getSession(false);
        MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
        System.out.println(boardDTO.getWriter());
        if (session != null && boardDTO != null) {
            if (!boardDTO.getWriter().equals(memberDTO.getName())) {
                modelAndView.addObject("message", "로그인이 필요합니다.");
                modelAndView.addObject("path", "member/login");
                modelAndView.setViewName("commons/result");

            }
        }
    }
}



