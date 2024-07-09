package com.br.gabproject.simpleproject.model.domain;

public class LoginResponseBody {

    private final String jwttoken;
    private final String message;

    public LoginResponseBody(String jwttoken, String message) {
        this.jwttoken = jwttoken;
        this.message = message;
    }

    public String getToken() {
        return this.jwttoken;
    }

    public String getMessage() {
        return message;
    }
}
