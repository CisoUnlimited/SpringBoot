package com.example.springboot.modelo.dao;

import com.example.springboot.modelo.entidades.Sede;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ISedeDAO extends CrudRepository<Sede, Integer> {
    @Query("select s from Sede s where s.nomSede like %:name%")
    Sede findSedeByNomSede(@Param("name") String name);
}
