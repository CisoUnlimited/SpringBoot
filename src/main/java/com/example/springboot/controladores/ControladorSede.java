package com.example.springboot.controladores;

import com.example.springboot.modelo.dao.ISedeDAO;
import com.example.springboot.modelo.entidades.Empleado;
import com.example.springboot.modelo.entidades.Sede;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLIntegrityConstraintViolationException;
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
    public ResponseEntity<Sede> buscarSedePorId(@PathVariable(value = "id") Integer id) {
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

    @DeleteMapping("/baja/{id}")
    public ResponseEntity<?> borrarSede (@PathVariable(value = "id") Integer id) {

        Optional<Sede> sede = sedesDAO.findById(id);
        if(sede.isPresent()) {
            try {
                sedesDAO.deleteById(id);
                return ResponseEntity.ok().body("Borrada");
            } catch (DataIntegrityViolationException e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizarSede(@RequestBody Sede nuevaSede,
                                                @PathVariable(value = "id") Integer id) {
        Optional<Sede> sede = sedesDAO.findById(id);
        if (sede.isPresent()) {
            sede.get().setNomSede(nuevaSede.getNomSede());
            sedesDAO.save(sede.get());
            return ResponseEntity.ok().body("Actualizado");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
