package com.sistemaerp.spring_erp.controller;

import com.sistemaerp.spring_erp.model.User;
import com.sistemaerp.spring_erp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity<User> getPerfil(Authentication authentication) {
        String email = authentication.getName();
        Optional<User> optionalUser = userRepository.findByEmail(email);

        if (optionalUser.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(optionalUser.get());
    }

    @PutMapping
    public ResponseEntity<User> atualizarPerfil(@RequestBody User atualizacao, Authentication authentication) {
        String email = authentication.getName();
        Optional<User> optionalUser = userRepository.findByEmail(email);

        if (optionalUser.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        User user = optionalUser.get();
        user.setNome(atualizacao.getNome());
        user.setSenha(atualizacao.getSenha());

        return ResponseEntity.ok(userRepository.save(user));
    }
}
