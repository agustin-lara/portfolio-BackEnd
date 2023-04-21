package com.agustinlaradesarrollador.portfolioBackEnd.Controller;

import com.agustinlaradesarrollador.portfolioBackEnd.Model.Persona;
import com.agustinlaradesarrollador.portfolioBackEnd.Service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@RequestMapping("/api/personas")
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {
    
    @Autowired
    private IPersonaService iPersonaService;
    
    @GetMapping
    public ResponseEntity<List<Persona>> getPersonas() {
        List<Persona> personas = iPersonaService.getPersonas();
        return new ResponseEntity(personas, HttpStatus.OK);
    }
    
    @GetMapping ("/{id}")
    public ResponseEntity<Persona> findPersona(@PathVariable int id) {
        Persona persona = iPersonaService.getPersona(id);
        if (persona == null) {
            return new ResponseEntity("El ID no existe.",HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity(persona,HttpStatus.OK);
        }
    }
    
    @PostMapping ("/crear")
    public ResponseEntity<?> createPersona(@RequestBody Persona persona) {
        iPersonaService.savePersona(persona);
        return new ResponseEntity("Persona creada.", HttpStatus.OK);
    }
    
    @PutMapping ("/editar/{id}")
    public ResponseEntity<Persona> updatePersona(@PathVariable int id, @RequestBody Persona nuevaPersona) {
        Persona persona = iPersonaService.getPersona(id);
        if(persona == null) {
            return new ResponseEntity("El ID no existe.",HttpStatus.NOT_FOUND);
        } else {
            persona.setNombre(nuevaPersona.getNombre());
            persona.setTitulo(nuevaPersona.getTitulo());
            persona.setDescripcion(nuevaPersona.getDescripcion());
            persona.setImagen_perfil(nuevaPersona.getImagen_perfil());
            persona.setImagen_portada(nuevaPersona.getImagen_portada());
            iPersonaService.savePersona(persona);
            return new ResponseEntity(persona,HttpStatus.OK);
        }
    }
    
    @DeleteMapping ("/borrar/{id}")
    public ResponseEntity<?> deletePersona(@PathVariable int id) {
        if(iPersonaService.getPersona(id) == null) {
            return new ResponseEntity("El ID no existe.", HttpStatus.NOT_FOUND);
        } else {
            iPersonaService.deletePersona(id);
            return new ResponseEntity("Persona eliminada.", HttpStatus.OK);
        }
    }
    
}
