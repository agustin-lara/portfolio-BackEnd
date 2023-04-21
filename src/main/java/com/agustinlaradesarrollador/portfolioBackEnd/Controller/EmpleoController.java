package com.agustinlaradesarrollador.portfolioBackEnd.Controller;

import com.agustinlaradesarrollador.portfolioBackEnd.Model.Empleo;
import com.agustinlaradesarrollador.portfolioBackEnd.Model.Persona;
import com.agustinlaradesarrollador.portfolioBackEnd.Service.IEmpleoService;
import com.agustinlaradesarrollador.portfolioBackEnd.Service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Agustín
 */

@RestController
@RequestMapping("/api/empleos")
public class EmpleoController {
    
    @Autowired
    private IEmpleoService iEmpleoService;
    
    @Autowired
    private IPersonaService iPersonaService;
    
    @GetMapping
    public ResponseEntity<List<Empleo>> getAllEmpleos() {
        List<Empleo> empleos = iEmpleoService.getAllEmpleos();
        return new ResponseEntity(empleos, HttpStatus.OK);
    }
    
    @GetMapping ("/{id}")
    public ResponseEntity<Empleo> getEmpleo(@PathVariable int id) {
        Empleo empleo = iEmpleoService.getEmpleo(id);
        if (empleo == null) {
            return new ResponseEntity("El ID no existe.",HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity(empleo,HttpStatus.OK);
        }
    }
    
    @PostMapping ("/crear")
    public ResponseEntity<?> createEmpleo(@RequestBody Empleo empleo) {
        Persona persona = iPersonaService.getPersona(1);
        empleo.setPersona(persona);
        iEmpleoService.addEmpleo(empleo);
        return new ResponseEntity("Empleo creado.", HttpStatus.OK);
    }
    
    @PutMapping ("/editar/{id}")
    public ResponseEntity<Empleo> updateEmpleo(@PathVariable int id, @RequestBody Empleo nuevoEmpleo) {
        Empleo empleo = iEmpleoService.getEmpleo(id);
        if(empleo == null) {
            return new ResponseEntity("El ID no existe.",HttpStatus.NOT_FOUND);
        } else {
            empleo.setNombre(nuevoEmpleo.getNombre());
//            empleo.setDescripcion(nuevoEmpleo.getDescripcion());
            empleo.setFecha_inicio(nuevoEmpleo.getFecha_inicio());
            empleo.setFecha_fin(nuevoEmpleo.getFecha_fin());
            iEmpleoService.addEmpleo(empleo);
            return new ResponseEntity("Empleo actualizado.",HttpStatus.OK);
        }
    }
    
    @DeleteMapping ("/borrar/{id}")
    public ResponseEntity<?> deleteEmpleo(@PathVariable int id) {
        if(iEmpleoService.getEmpleo(id) == null) {
            return new ResponseEntity("El ID no existe.", HttpStatus.NOT_FOUND);
        } else {
            iEmpleoService.deleteEmpleo(id);
            return new ResponseEntity("Empleo eliminado.", HttpStatus.OK);
        }
    }
    
}
