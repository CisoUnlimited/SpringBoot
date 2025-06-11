package com.example.springboot.modelo.dao;

import com.example.springboot.modelo.entidades.Departamento;
import com.example.springboot.modelo.entidades.Sede;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IDepartamentoDAO extends CrudRepository<Departamento, Integer> {
    List<Departamento> findDepartamentosByNomDepto(String nomDepto);
    List<Departamento> findDepartamentosByIdSede(Optional<Sede> sede);
}
