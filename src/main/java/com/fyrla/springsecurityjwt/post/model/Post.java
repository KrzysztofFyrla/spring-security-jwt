package com.fyrla.springsecurityjwt.post.model;

import com.fyrla.springsecurityjwt.comment.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * @author Krzysztof
 * @project spring-security-jwt
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private Long userId;
    private String title;
    private String content;

    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "postId", updatable =  false, insertable = false)
    private List<Comment> comments;
}
