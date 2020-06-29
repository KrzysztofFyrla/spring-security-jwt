package com.fyrla.springsecurityjwt.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Krzysztof
 * @project spring-security-jwt
 */
@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/api/comment/{pageNo}/{pageSize}")
    //@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<Comment> getAll(@PathVariable int pageNo,
                                @PathVariable int pageSize) {
        return commentService.getAll(pageNo, pageSize);
    }
}
