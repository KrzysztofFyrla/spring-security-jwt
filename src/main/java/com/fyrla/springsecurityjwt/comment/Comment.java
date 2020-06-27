package com.fyrla.springsecurityjwt.comment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Krzysztof
 * @project spring-security-jwt
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String content;
}
