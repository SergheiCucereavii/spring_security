package com.webcuser.security.servicies.comment;

import com.webcuser.security.models.Comment;
import com.webcuser.security.models.dto.CommentDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CommentService {
    List<Comment> getCategoryById(Long id);


    Comment storeComment(Long postId, Comment comment);

    Comment updateComment(Long id, CommentDto request);
    Comment approveComment(Long id);
    Comment deleteComment(Long id);
}
