package com.malfatti.gestao_estoque.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.malfatti.gestao_estoque.domain.entity.UserEntity;
import com.malfatti.gestao_estoque.domain.repository.UserRepository;
import com.malfatti.gestao_estoque.exceptions.UserFoundExeception;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/")
    public UserEntity create(@Valid @RequestBody UserEntity userEntity) {
        this.userRepository.findByUsernameOrEmail(userEntity.getUsername(), userEntity.getEmail())
                .ifPresent((user) -> {
                    throw new UserFoundExeception();
                });
        return this.userRepository.save(userEntity);
    }
}
