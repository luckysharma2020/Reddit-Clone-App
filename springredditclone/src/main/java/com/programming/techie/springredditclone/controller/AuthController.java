package com.programming.techie.springredditclone.controller;

import com.programming.techie.springredditclone.dto.RegisterRequest;
import com.programming.techie.springredditclone.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor

public class AuthController {

    private final AuthService AuthService;

    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody RegisterRequest registerRequest) {
        AuthService.signup(registerRequest);
        return new ResponseEntity(OK);
    }
    @GetMapping("accountVerification/{token}")
    public ResponseEntity<String> verifyAccount(@PathVariable String token) {
        AuthService.verifyAccount(token);
        return new ResponseEntity<>("Account Activated Successully", OK);
    }
}