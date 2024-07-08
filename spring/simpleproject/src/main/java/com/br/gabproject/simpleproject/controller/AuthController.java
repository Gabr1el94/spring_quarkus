package com.br.gabproject.simpleproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.gabproject.simpleproject.model.Client;
import com.br.gabproject.simpleproject.respository.AuthRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Tag(name = "Authenticator", description = "Tutorial management APIs")
@RestController
@RequestMapping("auth")
public class AuthController {

        @Autowired
        private AuthRepository authRepository;

        @Autowired
        private PasswordEncoder passwordEncoder;

        @Operation(summary = "Authenticator Login", description = "Get check authenticator username and password")
        @ApiResponses({
                        @ApiResponse(responseCode = "200", content = {
                                        @Content(schema = @Schema(example = "Access is Permited!"), mediaType = "application/json")
                        }),
                        @ApiResponse(responseCode = "401", content = {
                                        @Content(schema = @Schema(example = "Access is Denied!"), mediaType = "application/json")
                        })
        })
        @GetMapping("/login")
        public ResponseEntity<?> loginAuth(
                        @Parameter(description = "Input username form") @RequestParam("username") String username,
                        @RequestParam("Input password form") String password) {

                Client cliFind = authRepository.findClientUsernameAndPass(username);

                if (cliFind == null) {
                        return new ResponseEntity<>("Access is Denied!", HttpStatus.UNAUTHORIZED);
                }

                boolean valid = false;

                valid = passwordEncoder.matches(password, cliFind.getPassword());

                return valid ? new ResponseEntity<>("Access is Permited!", HttpStatus.ACCEPTED)
                                : new ResponseEntity<>("Access is Denied!", HttpStatus.UNAUTHORIZED);
        }

}
