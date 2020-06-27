package com.fyrla.springsecurityjwt.post.dto;

import lombok.Builder;
import lombok.Getter;

/**
 * @author Krzysztof
 * @project spring-security-jwt
 */
@Getter
@Builder
public class PostDto {

    private Long id;
    private String title;
    private String content;
}
