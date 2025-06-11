package com.example.springboot.controladores;

import com.example.springboot.modelo.dao.IDepartamentoDAO;
import com.example.springboot.modelo.dao.IEmpleadoDAO;
import com.example.springboot.modelo.dao.ISedeDAO;
import com.example.springboot.modelo.entidades.Departamento;
import com.example.springboot.modelo.entidades.Empleado;
import com.example.springboot.modelo.entidades.Sede;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api-rest/departamentos")
public class ControladorDepartamento {
    @Autowired
    IDepartamentoDAO departamentosDAO;
    @Autowired
    IEmpleadoDAO empleadosDAO;
    @Autowired
    ISedeDAO sedesDAO;

    @GetMapping
    public List<Departamento> listarDepartamentos() {
        return (List<Departamento>) departamentosDAO.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Departamento> buscarDepartamentoPorId(@PathVariable(value = "id") Integer id) {
        Optional<Departamento> departamento = departamentosDAO.findById(id);
        if (departamento.isPresent()) {
            return ResponseEntity.ok().body(departamento.get()); // HTTP 200 OK
        } else {
            return ResponseEntity.notFound().build(); // HTTP 404
        }
    }

    @GetMapping("/nombre/{nombre}")
    public List<Departamento> buscarDepartamentosPorNombre(@PathVariable(value = "nombre") String nombre) {
        return departamentosDAO.findDepartamentosByNomDepto(nombre);
    }

    @GetMapping("/idSede/{idSede}")
    public List<Departamento> buscarDepartamentosPorIdSede(@PathVariable(value = "idSede") Integer idSede) {
        Optional<Sede> sede = sedesDAO.findById(idSede);
        return departamentosDAO.findDepartamentosByIdSede(sede);
    }

    @GetMapping("/nombre/{nombre}/empleados")
    public List<Empleado> buscarEmpleadoPorNombreDepto(@PathVariable(value = "nombre") String nombre) {
        return empleadosDAO.findEmpleadosByNomDepto(nombre);
    }

    @Validated
    @PostMapping("/alta")
    public Departamento guardarDepartamento(@Validated @RequestBody Departamento departamento) {
        return departamentosDAO.save(departamento);
    }

}
