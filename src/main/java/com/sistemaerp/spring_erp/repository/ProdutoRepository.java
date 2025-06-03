package com.sistemaerp.spring_erp.repository;

import com.sistemaerp.spring_erp.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
