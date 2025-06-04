package com.example.springboot.modelo.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "empleado", schema = "proyecto_orm")
public class Empleado {
    @Id
    @Column(name = "dni", nullable = false, length = 9)
    private String dni;

    @Column(name = "nom_emp", nullable = false, length = 40)
    private String nomEmp;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
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