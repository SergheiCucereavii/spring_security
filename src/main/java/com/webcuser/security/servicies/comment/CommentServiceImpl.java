package com.webcuser.security.servicies.comment;

import com.webcuser.security.models.Comment;
import com.webcuser.security.models.Post;
import com.webcuser.security.models.dto.CommentDto;
import com.webcuser.security.repositories.CommentRepository;
import com.webcuser.security.repositories.PostRepository;
import com.webcuser.security.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    UserRepository userRepository;

    @Autowired
    PostRepository postRepository;

    @Override
    public List<Comment> getCategoryById(Long id) {
        return commentRepository.findAll();
    }

    @Override
    public Comment storeComment(Long postId, Comment comment) {
        return null;
    }

    /*@Override
    public Comment storeComment(@PathVariable Long postId, @RequestBody CommentDto comment) {
        Optional<Post> postOptional = postRepository.findById(postId);
        Post post = postOptional.get();
        comment.setPost(post);
        return commentRepository.save(comment);
    }*/

    @Override
    public Comment updateComment(Long id, CommentDto request) {
        Optional<Comment> currentComment = commentRepository.findById(id);
        Comment comment = currentComment.get();
        comment.setDesctiption(request.description);
        return commentRepository.save(comment);
    }

    @Override
    public Comment approveComment(Long id) {
        Optional<Comment> currentComment = commentRepository.findById(id);
        Comment comment = currentComment.get();
        comment.setApproved(true);
        return null;
    }


    @Override
    public Comment deleteComment(Long id) {
        Comment comment = commentRepository.findById(id).orElse(null);
        if (comment != null) { postRepository.deleteById(id);}
        return comment;
    }
}
