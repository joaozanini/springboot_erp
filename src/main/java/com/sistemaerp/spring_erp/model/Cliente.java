package com.sistemaerp.spring_erp.model;

import jakarta.persistence.*;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 100)
    private String email;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idUser", referencedColumnName = "id")
    private User user;

    // Constructors

    public Cliente() {
    }

    public Cliente(long id, String nome, String email, User user) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.user = user;
    }

    // Getters e Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User getIdUser() {
        return user;
    }

    public void setIdUser(User user) {
        this.user = user;
    }
}
