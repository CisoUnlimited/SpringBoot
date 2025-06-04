package com.example.springboot.modelo.dao;

import com.example.springboot.modelo.entidades.Sede;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISedeDAO extends CrudRepository<Sede, Integer> {

}
