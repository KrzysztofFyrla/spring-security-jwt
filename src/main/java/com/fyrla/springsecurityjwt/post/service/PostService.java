package com.fyrla.springsecurityjwt.post.service;

import com.fyrla.springsecurityjwt.comment.Comment;
import com.fyrla.springsecurityjwt.comment.CommentRepository;
import com.fyrla.springsecurityjwt.post.repository.PostRepository;
import com.fyrla.springsecurityjwt.post.model.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Krzysztof
 * @project spring-security-jwt
 */
@Service
@RequiredArgsConstructor
public class PostService {

    public static final int PAGE_SIZE = 5;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    public List<Post> getPost(int page, Sort.Direction sort) {
        return postRepository.findAllPosts(
                PageRequest.of(page, PAGE_SIZE,
                        Sort.by(sort, "id")
                )
        );
    }

    public Optional<Post> getSinglePost(Long id) {
        return postRepository.findById(id);
    }

    public List<Post> getPostWitchComment(int page, Sort.Direction sort) {
        List<Post> allPost = postRepository.findAllPosts(PageRequest.of(page, PAGE_SIZE,
                Sort.by(sort, "id")
        ));

        List<Long> ids = allPost.stream()
                .map(Post::getId)
                .collect(Collectors.toList());

        List<Comment> comments = commentRepository.findByPostIdIn(ids);
        allPost.forEach(post -> post.setComments(exctractComment(comments, post.getId())));
        return allPost;
    }

    private List<Comment> exctractComment(List<Comment> comments, Long id) {
        return comments.stream()
                .filter(comment -> comment.getPostId() == id)
                .collect(Collectors.toList());
    }

    public Post addPost(Post post) {
        return postRepository.save(post);
    }

    @Transactional
    public Post editPost(Post post) throws Exception {
        Post postEdit = postRepository.findById(post.getId()).orElseThrow(() -> new Exception("Post not found"));
        postEdit.setTitle(post.getTitle());
        postEdit.setContent(post.getContent());
        return postEdit;
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
