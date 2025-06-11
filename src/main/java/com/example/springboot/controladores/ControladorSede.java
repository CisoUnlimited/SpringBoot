package com.example.springboot.controladores;

import com.example.springboot.modelo.dao.ISedeDAO;
import com.example.springboot.modelo.entidades.Sede;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api-rest/sedes")
public class ControladorSede {
    @Autowired
    ISedeDAO sedesDAO;

    @GetMapping
    public List<Sede> listarSedes() {
        return (List<Sede>) sedesDAO.findAll();
    }

    @GetMapping
    @RequestMapping("/{id}")
    public ResponseEntity<Sede> buscarSedePorId(@PathVariable(value = "id") int id) {
        Optional<Sede> sede = sedesDAO.findById(id);
        if (sede.isPresent()) {
            return ResponseEntity.ok().body(sede.get()); // HTTP 200 OK
        } else {
            return ResponseEntity.notFound().build();    // HTTP 404
        }
    }

    @GetMapping
    @RequestMapping("/nombre/{nomSede}")
    public Sede buscarSedePorNombre(@PathVariable(value = "nomSede") String nomSede) {
        return sedesDAO.findSedeByNomSede(nomSede);
    }

    @Validated
    @PostMapping("/alta")
    public Sede guardarSede(@Validated @RequestBody Sede sede) {
        return sedesDAO.save(sede);
    }
}
