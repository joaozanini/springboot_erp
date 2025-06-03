package com.sistemaerp.spring_erp.repository;

import com.sistemaerp.spring_erp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
