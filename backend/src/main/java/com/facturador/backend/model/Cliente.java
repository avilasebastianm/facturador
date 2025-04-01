package com.facturador.backend.model;


import jakarta.persistence.*;

@Entity
public class Cliente {



         @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
    @Column(name = "cuit_cuil")
        private String cuitCuil;
        private String nombre;
        private String direccion;
        private String situacion_fiscal;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getCuitCuil() {
            return cuitCuil;
        }

        public void setCuitCuil(String cuit_cuil) {
            this.cuitCuil = cuit_cuil;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getDireccion() {
            return direccion;
        }

        public void setDireccion(String direccion) {
            this.direccion = direccion;
        }

        public String getSituacion_fiscal() {
            return situacion_fiscal;
        }

        public void setSituacion_fiscal(String situacion_fiscal) {
            this.situacion_fiscal = situacion_fiscal;
        }
    }


