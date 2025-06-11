package com.example.springboot.modelo.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "departamento", schema = "proyecto_orm")
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_depto", nullable = false)
    private Integer id;

    @Column(name = "nom_depto", nullable = false, length = 32)
    private String nomDepto;

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