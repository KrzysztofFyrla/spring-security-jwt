package com.fyrla.springsecurityjwt.payload.response;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Krzysztof
 * @project spring-security-jwt
 */
@Getter
@Setter
public class MessageResponse {

    private String message;

    public MessageResponse(String message) {
        this.message = message;
    }
}
