package com.example.springboot.controladores;

import com.example.springboot.modelo.dao.IEmpleadoDAO;
import com.example.springboot.modelo.entidades.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api-rest/empleados")
public class ControladorEmpleado {
    @Autowired
    IEmpleadoDAO empleadosDAO;

    @GetMapping
    public List<Empleado> listarEmpleados(){
        return (List<Empleado>) empleadosDAO.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empleado> buscarEmpleadoPorId(@PathVariable(value="id") String dni){
        Optional<Empleado> empleado = empleadosDAO.findById(dni);
        if(empleado.isPresent()){
            return ResponseEntity.ok().body(empleado.get()); // HTTP 200 OK
        } else {
            return ResponseEntity.notFound().build(); // HTTP 404
        }
    }

    @Validated
    @PostMapping("/alta")
    public Empleado guardarEmpleado(@Validated @RequestBody Empleado empleado){
        return empleadosDAO.save(empleado);
    }
}
