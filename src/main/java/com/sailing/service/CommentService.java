package com.sailing.service;

import com.sailing.entity.Comment;

import java.util.List;

public interface CommentService {
    //查找指定古玩的所以评论
    List<Comment> selectByAntid(String antid);
    //新增评论
    int insertComment(Comment comment);
}
