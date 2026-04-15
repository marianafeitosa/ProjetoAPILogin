package com.example.projetoapilogin.controller;

import com.example.projetoapilogin.model.UserLogin;
import com.example.projetoapilogin.service.AuthService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService service;

    public AuthController(AuthService service) {
        this.service = service;
    }

    @PostMapping
    public UserLogin criar(@RequestBody UserLogin user) {
        return service.criar(user);
    }

    @GetMapping
    public List<UserLogin> listar() {
        return service.listar();
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String senha) {
        return service.autenticar(email, senha);
    }
}