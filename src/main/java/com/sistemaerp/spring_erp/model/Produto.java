package com.sistemaerp.spring_erp.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, precision = 11, scale = 2)
    private BigDecimal preco;

    @Column(nullable = false)
    private Long codigo;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idUser", referencedColumnName = "id")
    private User user;

    // Constructors

    public Produto(Long id, String nome, BigDecimal preco, Long codigo, User user) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.codigo = codigo;
        this.user = user;
    }

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
