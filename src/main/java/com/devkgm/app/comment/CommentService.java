package com.devkgm.app.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentDAO commentDAO;

    public int doAdd(CommentDTO commentDTO) {
        return commentDAO.doAdd(commentDTO);
    }

    public List<CommentDTO> getList(CommentDTO commentDTO) {
        return commentDAO.getList(commentDTO);
    }

}
