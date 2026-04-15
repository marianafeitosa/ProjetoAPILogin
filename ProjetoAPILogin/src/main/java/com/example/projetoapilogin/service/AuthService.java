package com.example.projetoapilogin.service;

import com.example.projetoapilogin.model.UserLogin;
import com.example.projetoapilogin.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthService {

    private final UserRepository repository;

    public AuthService(UserRepository repository) {
        this.repository = repository;
    }

    public UserLogin criar(UserLogin user) {
        if (user.getEmail() == null || user.getEmail().isBlank()) {
            throw new RuntimeException("Email obrigatório");
        }
        return repository.save(user);
    }

    public List<UserLogin> listar() {
        return repository.findAll();
    }

    public String autenticar(String email, String senha) {
        Optional<UserLogin> user = repository.findByEmail(email);

        if (user.isPresent() && user.get().getSenha().equals(senha)) {
            return "Acesso liberado";
        }

        return "Credenciais inválidas";
    }
}