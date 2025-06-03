package com.sistemaerp.spring_erp.controller;

import com.sistemaerp.spring_erp.model.User;
import com.sistemaerp.spring_erp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // GET /user → retorna os dados do próprio usuário autenticado
    @GetMapping
    public ResponseEntity<User> getPerfil(Authentication authentication) {
        String email = authentication.getName(); // pega o email do usuário logado

        User user = userRepository.findByEmail(email);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    // PUT /user → atualiza os dados do próprio usuário autenticado
    @PutMapping
    public ResponseEntity<User> atualizarPerfil(@RequestBody User atualizacao, Authentication authentication) {
        String email = authentication.getName();
        User user = userRepository.findByEmail(email);

        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        user.setNome(atualizacao.getNome());
        user.setSenha(atualizacao.getSenha());
        return ResponseEntity.ok(userRepository.save(user));
    }
}
