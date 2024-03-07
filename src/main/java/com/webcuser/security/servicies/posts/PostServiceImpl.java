package com.webcuser.security.servicies.posts;

import com.webcuser.security.models.Category;
import com.webcuser.security.models.Post;
import com.webcuser.security.models.User;
import com.webcuser.security.models.dto.PostDto;
import com.webcuser.security.repositories.CategoryRepository;
import com.webcuser.security.repositories.PostRepository;
import com.webcuser.security.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }
    @Override
    public List<Post> getPostById(Long id) {
        return postRepository.findAllById(Collections.singleton(id));
    }


    @Override
    public Post storePost(PostDto request) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        Optional<User> currentUserOptional = userRepository.findByEmail(currentPrincipalName);
        if (currentUserOptional.isPresent()) {
            User currentUser = currentUserOptional.get();
            List<Long> categoryIds = request.getCategoryIds();
            List<Category> categories = new ArrayList<>();
            for (Long categoryId : categoryIds) {
                Optional<Category> category = categoryRepository.findById(categoryId);
                category.ifPresent(categories::add);
            }
            //genero un novo post
            Post post = new Post();
            post.setTitle(request.title);
            post.setDescription(request.description);
            post.setCategories(categories);
            post.setUser(currentUser);
            return postRepository.save(post);
        } else {
            throw new IllegalStateException("Utente non trovato");
        }
    }


    @Override
    public Post updatePost(Long postId, PostDto request) {
        Optional<Post> currentPost = postRepository.findById(postId);
        Post post = currentPost.get();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        User currentUser = post.getUser();
        if (!currentUser.getEmail().equals(currentPrincipalName)) {
            throw new IllegalStateException("Non sei autorizzato.");
        }
        post.setTitle(request.getTitle());
        post.setDescription(request.getDescription());
        List<Category> categories = new ArrayList<>();
        List<Long> categoryIds = request.getCategoryIds();
        for (Long categoryId : categoryIds) {
            Optional<Category> categoryOptional = categoryRepository.findById(categoryId);
            categoryOptional.ifPresent(categories::add);
        }
        post.setCategories(categories);
        return postRepository.save(post);
    }

    @Override
    public Post deletePost(Long id) {
        Post post = postRepository.findById(id).orElse(null);
        if (post != null){ postRepository.deleteById(id);}
        return post;
    }


}
