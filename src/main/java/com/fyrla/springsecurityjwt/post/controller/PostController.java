package com.fyrla.springsecurityjwt.post.controller;

import com.fyrla.springsecurityjwt.post.service.PostService;
import com.fyrla.springsecurityjwt.post.dto.PostDto;
import com.fyrla.springsecurityjwt.post.dto.PostDtoMapper;
import com.fyrla.springsecurityjwt.post.model.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author Krzysztof
 * @project spring-security-jwt
 */
@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/api/posts")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<PostDto> getPost(@RequestParam(required = false) Integer page, Sort.Direction sort) {
        int pageNumber = page != null && page >= 0 ? page :0;
        Sort.Direction sortDirection = sort != null ? sort : Sort.Direction.ASC;
        return PostDtoMapper.mapToPostDtos(postService.getPost(pageNumber, sortDirection));
    }

    @GetMapping("/api/posts/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public Optional<Post> getSinglePost(Long id) {
        return postService.getSinglePost(id);
    }

    @PostMapping("/api/posts")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public Post addPost(Post post) {
        return postService.addPost(post);
    }

    @PutMapping("/api/posts")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public Post editPost(@RequestBody Post post) throws Exception {
        return postService.editPost(post);
    }

    @DeleteMapping("/api/posts/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public void deletePost(Long id) {
        postService.deletePost(id);
    }
}
