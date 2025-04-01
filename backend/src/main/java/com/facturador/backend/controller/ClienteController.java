package com.facturador.backend.controller;

import com.facturador.backend.model.Cliente;
import com.facturador.backend.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/cuit_cuil/{cuit_cuil}")
    public Cliente findBycuitCuil(@PathVariable String cuit_cuil) {
        return clienteService.findBycuitCuil(cuit_cuil);
    }
    // ... otros endpoints para la gestión de clientes
}
