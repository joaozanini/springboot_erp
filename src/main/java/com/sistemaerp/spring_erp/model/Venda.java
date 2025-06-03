package com.sistemaerp.spring_erp.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate data;

    @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemVenda> itens = new ArrayList<>();

    public Venda() {
        this.data = LocalDate.now();
    }

    public void adicionarItem(ItemVenda item) {
        item.setVenda(this);
        this.itens.add(item);
    }

    // Constructors

    public Venda(Long id, LocalDate data, List<ItemVenda> itens) {
        this.id = id;
        this.data = data;
        this.itens = itens;
    }


    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public List<ItemVenda> getItens() {
        return itens;
    }

    public void setItens(List<ItemVenda> itens) {
        this.itens = itens;
    }
}
