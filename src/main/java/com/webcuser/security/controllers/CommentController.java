package com.webcuser.security.controllers;

import com.webcuser.security.models.Comment;
import com.webcuser.security.models.dto.CommentDto;
import com.webcuser.security.servicies.comment.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping(path = "/api/v1/protected/comments")
public class CommentController {
    @Autowired
    CommentService commentService;

    /*@PostMapping("/{id}")
    public Comment storeComment(Long id, @RequestBody CommentDto request) {
        return commentService.storeComment(id, request);
    }*/
    @PutMapping("/{id}")
    public Comment updateComment(Long id, @RequestBody CommentDto request){
        return this.commentService.updateComment(id, request);
    }

    @PatchMapping("/{id}")
    public Comment setApproved(Long id){
        return this.commentService.approveComment(id);
    }

    @DeleteMapping("/{id}")
    public Comment deleteComment(Long id){
        return this.commentService.deleteComment(id);
    }

}
