package com.fyrla.springsecurityjwt.post.dto;

import com.fyrla.springsecurityjwt.post.model.Post;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Krzysztof
 * @project spring-security-jwt
 */
public class PostDtoMapper {

    public PostDtoMapper() {
    }

    public static List<PostDto> mapToPostDtos(List<Post> posts) {
        return posts.stream()
                .map(post -> mapToPostDto(post))
                .collect(Collectors.toList());
    }

    private static PostDto mapToPostDto(Post post) {
        return PostDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .build();
    }
}
