package com.fyrla.springsecurityjwt.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Krzysztof
 * @project spring-security-jwt
 */
@Service
@RequiredArgsConstructor
public class CommentService {

    public final CommentRepository commentRepository;

    public List<Comment> getAll(int pageNo, int pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<Comment> commentPage = commentRepository.findAll(paging);
        return commentPage.toList();
    }
}
