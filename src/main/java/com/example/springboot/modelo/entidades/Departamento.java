package com.example.springboot.modelo.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "departamento", schema = "proyecto_orm")
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_depto", nullable = false)
    private Integer id;

    @NotBlank(message = "El nombre del departamento no puede estar vacío")
    @Column(name = "nom_depto", nullable = false, length = 32)
    private String nomDepto;

    @NotNull(message = "La sede del departamento no puede ser NULL")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_sede", nullable = false)
    private Sede idSede;

    public Sede getIdSede() {
        return idSede;
    }

    public void setIdSede(Sede idSede) {
        this.idSede = idSede;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomDepto() {
        return nomDepto;
    }

    public void setNomDepto(String nomDepto) {
        this.nomDepto = nomDepto;
    }

}