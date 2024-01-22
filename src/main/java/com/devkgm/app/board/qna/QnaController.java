package com.devkgm.app.board.qna;

import java.util.List;

import com.devkgm.app.member.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.devkgm.app.board.BoardPager;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/qna/*")
public class QnaController {
    @Autowired
    private QnaService qnaService;

    @ModelAttribute("board")
    public String getBoard() {
        return "qna";
    }

    @GetMapping("reply")
    public String reply(QnaDTO qnaDTO, Model model) throws Exception {
        model.addAttribute("dto", qnaDTO);
        return "board/reply";
    }

    @PostMapping("reply")
    public String reply(QnaDTO qnaDTO) throws Exception {
        int result = qnaService.reply(qnaDTO);
        return "redirect:./list";
    }

    @GetMapping("list")
    public String list(BoardPager boardPager, Model model) throws Exception {
        List<QnaDTO> list = qnaService.getList(boardPager);
        System.out.println(boardPager.getSearch() + boardPager.getKind());
        model.addAttribute("pager", boardPager);
        model.addAttribute("list", list);

        return "board/list";
    }

    @GetMapping("detail/{id}")
    public String detail(Model model, @PathVariable Long id, QnaDTO qnaDTO) throws Exception {
        qnaDTO = qnaService.getDetail(qnaDTO);
        model.addAttribute("dto", qnaDTO);

        return "board/detail";
    }

    @GetMapping("add")
    public String add(Model model, QnaDTO qnaDTO) throws Exception {
        qnaService.add(qnaDTO);
        model.addAttribute("dto", qnaDTO);
        return "board/add";
    }

    @PostMapping("add")
    public String add(Model model, QnaDTO qnaDTO, MultipartFile[] attach, HttpSession session) throws Exception {
        MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");

        qnaDTO.setWriter(memberDTO.getName());
        qnaService.update(qnaDTO, attach);

        return "redirect:./list";
    }

    @GetMapping("update")
    public String update(Model model, QnaDTO qnaDTO, HttpSession session) throws Exception {
        qnaDTO = qnaService.getDetail(qnaDTO);
        model.addAttribute("dto", qnaDTO);
        return "board/update";
    }

    @PostMapping("update")
    public String update(Model model, QnaDTO qnaDTO, MultipartFile[] attach, HttpSession session) throws Exception {

        qnaService.update(qnaDTO, attach);

        return "redirect:./list";
    }

    @GetMapping("delete")
    public String delete(Model model, QnaDTO qnaDTO) throws Exception {
        qnaService.delete(qnaDTO);
        return "redirect:./list";
    }

    @RequestMapping(value = "addFile", method = RequestMethod.POST)
    @ResponseBody
    public QnaFileDTO addFile(QnaFileDTO qnaFileDTO, MultipartFile attach) throws Exception {
        int result = qnaService.addFile(qnaFileDTO, attach);
        return qnaFileDTO;
    }


    @RequestMapping(value = "deleteFile", method = RequestMethod.POST)
    @ResponseBody
    public void deleteFile(QnaFileDTO qnaFileDTO) throws Exception {
        boolean result = qnaService.deleteFile(qnaFileDTO);
    }


}
