package com.sistemaerp.spring_erp.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class ItemVenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "idProduto")
    private Produto produto;

    private int quantidade;

    @ManyToOne
    @JoinColumn(name = "idVenda")
    private Venda venda;

    public BigDecimal getSubtotal() {
        return produto.getPreco().multiply(BigDecimal.valueOf(quantidade));
    }

    // Constructors


    public ItemVenda() {
    }

    public ItemVenda(Long id, Produto produto, int quantidade, Venda venda) {
        this.id = id;
        this.produto = produto;
        this.quantidade = quantidade;
        this.venda = venda;
    }


    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }
}

