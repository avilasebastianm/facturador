package com.facturador.backend.controller;

import com.facturador.backend.model.Usuario;
import com.facturador.backend.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/username/{username}")
    public Usuario findByUsername(@PathVariable String username) {
        return usuarioService.findByUsername(username);
    }

    // ... otros endpoints para la gestión de usuarios
}
