package com.example.projetoapilogin.repository;

import com.example.projetoapilogin.model.UserLogin;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<UserLogin, String> {

    Optional<UserLogin> findByEmail(String email);
}