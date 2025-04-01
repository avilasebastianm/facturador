package com.facturador.backend.service;

import com.facturador.backend.model.Cliente;
import com.facturador.backend.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente findBycuitCuil(String cuitCuil) {
        return clienteRepository.findBycuitCuil(cuitCuil);
    }
    // ... otros métodos para la gestión de clientes
}