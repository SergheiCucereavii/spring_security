package com.webcuser.security.servicies.posts;

import com.webcuser.security.models.Post;
import com.webcuser.security.models.dto.PostDto;

import java.util.List;

public interface PostService {
    List<Post> getAllPosts();
    List<Post> getPostById(Long id);

    Post storePost(PostDto request);

    Post updatePost(Long postId, PostDto request);

    Post deletePost(Long id);
}
