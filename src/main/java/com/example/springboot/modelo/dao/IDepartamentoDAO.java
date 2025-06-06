package com.example.springboot.modelo.dao;

import com.example.springboot.modelo.entidades.Departamento;
import com.example.springboot.modelo.entidades.Sede;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDepartamentoDAO extends CrudRepository<Departamento, Integer> {
    List<Departamento> findDepartamentoByNomDepto(String nomDepto);
    List<Departamento> findDepartamentosByIdSede(Sede idSede);
}
