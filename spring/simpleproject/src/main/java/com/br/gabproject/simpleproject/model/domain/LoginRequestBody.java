package com.br.gabproject.simpleproject.model.domain;

import java.io.Serializable;

public class LoginRequestBody implements Serializable {

    private String username;
    private String password;

    // need default constructor for JSON Parsing
    public LoginRequestBody() {

    }

    public LoginRequestBody(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
