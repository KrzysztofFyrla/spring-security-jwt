package com.fyrla.springsecurityjwt.payload.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author Krzysztof
 * @project spring-security-jwt
 */
@Getter
@Setter
public class JwtResponse {

    private String token;
    private String type = "Bearer";
    private Long id;
    private String username;
    private String email;
    private List<String> roles;
    private String name;

    public JwtResponse(String accessToken, Long id, String username, String email, List<String> roles) {
        this.token = accessToken;
        this.id = id;
        this.username = username;
        this.email = email;
        this.roles = roles;
    }
}
