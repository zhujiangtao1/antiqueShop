package com.sailing.web.controller;

import com.sailing.entity.Comment;
import com.sailing.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;
    @RequestMapping("/add")
    @ResponseBody
    public String AddComment( HttpSession session,Comment comment){
        String uid= (String) session.getAttribute("user");
        String username= (String) session.getAttribute("username");
        comment.setUid(uid);
        comment.setUsername(username);
        comment.setCommentTime(new Date());
        commentService.insertComment(comment);
        return "success";
    }
}
