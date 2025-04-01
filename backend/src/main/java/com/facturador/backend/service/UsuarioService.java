package com.facturador.backend.service;
import com.facturador.backend.model.Usuario;
import com.facturador.backend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario findByUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }

    // ... otros métodos para la gestión de usuarios
}