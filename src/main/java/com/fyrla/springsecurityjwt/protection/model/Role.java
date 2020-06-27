package com.fyrla.springsecurityjwt.protection.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author Krzysztof
 * @project spring-security-jwt
 */
@Entity
@Getter
@Setter
@Table(name = "roles")
public class Role {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole name;

    public Role() {

    }

    public Role(ERole name) {
        this.name = name;
    }
}
