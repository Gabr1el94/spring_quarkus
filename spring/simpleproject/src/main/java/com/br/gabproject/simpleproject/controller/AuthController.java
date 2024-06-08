package com.br.gabproject.simpleproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.gabproject.simpleproject.model.Client;
import com.br.gabproject.simpleproject.respository.AuthRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private AuthRepository authRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public ResponseEntity<?> loginAuth(@RequestParam("username") String username,
            @RequestParam("password") String password) {

        Client cliFind = authRepository.findClientUsernameAndPass(username);

        if (cliFind == null) {
            return new ResponseEntity<>("Access is Denied!", HttpStatus.UNAUTHORIZED);
        }

        boolean valid = false;

        valid = passwordEncoder.matches(password, cliFind.getPassword());

        if (valid) {
            return new ResponseEntity<>("Access Permited!", HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>("Access is Denied!", HttpStatus.UNAUTHORIZED);
        }
    }

}
