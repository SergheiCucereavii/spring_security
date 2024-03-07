package com.webcuser.security.controllers;
import com.webcuser.security.models.Post;
import com.webcuser.security.models.dto.PostDto;
import com.webcuser.security.servicies.posts.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RestController
@RequestMapping(path = "/api/v1/protected/posts")
public class PostController {
    @Autowired
    public PostService postService;
    @GetMapping("/")
    public List<Post> getAllPosts(){
        return postService.getAllPosts();
    }
    @GetMapping("/{id}")
    public List<Post> getPostById(@PathVariable("id") Long id){
        return postService.getPostById(id);
    }
    @PostMapping("/")
    public ResponseEntity<Post> createHost(@RequestBody PostDto request) {
        Post host = postService.storePost(request);
        return new ResponseEntity<>(host, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public Post updatePost(@PathVariable Long id, @RequestBody PostDto request) {
        return this.postService.updatePost(id, request);
    }
    @DeleteMapping("/{id}")
    public Post deletePost(@PathVariable("id") Long id) {return postService.deletePost(id);}
}
