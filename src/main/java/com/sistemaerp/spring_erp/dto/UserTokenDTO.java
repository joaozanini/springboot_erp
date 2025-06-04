package com.sistemaerp.spring_erp.dto;

public class UserTokenDTO {
    private String token;

    public UserTokenDTO(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
