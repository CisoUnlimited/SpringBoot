package com.example.springboot.modelo.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "sede", schema = "proyecto_orm")
public class Sede {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sede", nullable = false)
    private Integer id;

    @NotBlank(message = "El nombre de la sede no puede estar vacío")
    @Column(name = "nom_sede", nullable = false, length = 20)
    private String nomSede;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomSede() {
        return nomSede;
    }

    public void setNomSede(String nomSede) {
        this.nomSede = nomSede;
    }

}