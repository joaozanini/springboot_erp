package com.sistemaerp.spring_erp.repository;

import com.sistemaerp.spring_erp.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
