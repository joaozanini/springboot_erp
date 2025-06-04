package com.sistemaerp.spring_erp.controller;

import com.sistemaerp.spring_erp.dto.UserLoginDTO;
import com.sistemaerp.spring_erp.dto.UserTokenDTO;
import com.sistemaerp.spring_erp.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public UserTokenDTO login(@RequestBody UserLoginDTO loginDTO) {
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getSenha());
        authManager.authenticate(token);
        String jwt = jwtUtil.generateToken(loginDTO.getEmail());
        return new UserTokenDTO(jwt);
    }
}
