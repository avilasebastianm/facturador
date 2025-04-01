package com.facturador.backend.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Presupuesto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numero;
    private Date fecha;
    @ManyToOne
    private Cliente cliente;
    // ... getters y setters
}