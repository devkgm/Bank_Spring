package com.devkgm.app.comment;

import com.devkgm.app.board.BoardPager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommentService {
    @Autowired
    private CommentDAO commentDAO;

    public int doAdd(CommentDTO commentDTO) throws Exception {
        return commentDAO.doAdd(commentDTO);
    }

    public List<CommentDTO> getList(CommentDTO commentDTO, BoardPager pager) throws Exception {
        Map<String, Object> map = new HashMap<>();
        pager.setTotalPage(commentDAO.getTotalPage(commentDTO));
        pager.makeRow();
        map.put("pager", pager);
        map.put("commentDTO", commentDTO);
        return commentDAO.getList(map);
    }

}
