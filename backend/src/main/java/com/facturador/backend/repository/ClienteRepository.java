package com.facturador.backend.repository;

import com.facturador.backend.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente findBycuitCuil(String cuitCuil);
}