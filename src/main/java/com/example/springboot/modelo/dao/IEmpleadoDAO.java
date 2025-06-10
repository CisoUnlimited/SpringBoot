package com.example.springboot.modelo.dao;

import com.example.springboot.modelo.entidades.Empleado;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmpleadoDAO extends CrudRepository<Empleado, String> {
    @Query("select e from Empleado e where e.idDepto.nomDepto = ?1")
    List<Empleado> findEmpleadosByNomDepto(String nomDepto);
}
