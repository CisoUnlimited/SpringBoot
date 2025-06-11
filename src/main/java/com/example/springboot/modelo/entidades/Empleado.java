package com.example.springboot.modelo.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "empleado", schema = "proyecto_orm")
public class Empleado {
    @NotNull(message = "El DNI no puede ser NULL")
    @Id
    @Column(name = "dni", nullable = false, length = 9)
    private String dni;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Column(name = "nom_emp", nullable = false, length = 40)
    private String nomEmp;

    @NotNull(message = "El departamento del empleado no puede ser NULL")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_depto", nullable = false)
    private Departamento idDepto;

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNomEmp() {
        return nomEmp;
    }

    public void setNomEmp(String nomEmp) {
        this.nomEmp = nomEmp;
    }

    public Departamento getIdDepto() {
        return idDepto;
    }

    public void setIdDepto(Departamento idDepto) {
        this.idDepto = idDepto;
    }

}