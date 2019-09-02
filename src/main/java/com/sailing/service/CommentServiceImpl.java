package com.sailing.service;

import com.sailing.dao.CommentMapper;
import com.sailing.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
     private CommentMapper commentMapper;
    @Override
    public List<Comment> selectByAntid(String antid) {
        return commentMapper.selectByAntid(antid);
    }

    @Override
    public int insertComment(Comment comment) {
        return commentMapper.insertComment(comment);
    }

    @Override
    public List<Comment> selectAll( Comment comment) {
        return commentMapper.selectAll(comment);
    }

    @Override
    public List<Comment> selectAllno() {
        return commentMapper.selectAllno();
    }

    @Override
    public int delByCommentId(int commentid) {
        return commentMapper.delByCommentId(commentid);
    }
}
