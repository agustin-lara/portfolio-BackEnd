package com.agustinlaradesarrollador.portfolioBackEnd.Controller;

import com.agustinlaradesarrollador.portfolioBackEnd.Service.IProyectoService;
import com.agustinlaradesarrollador.portfolioBackEnd.dto.ProyectoRequest;
import com.agustinlaradesarrollador.portfolioBackEnd.dto.ProyectoResponse;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/api/proyectos")
@CrossOrigin(origins = "https://portfolio-frontend-la.web.app")
public class ProyectoController {
    
    @Autowired
    private IProyectoService iProyectoService;
    
    @GetMapping("/{perfilId}")
    public List<ProyectoResponse> getAllProyectosByPerfilId(@PathVariable int perfilId) {
        return iProyectoService.getAllProyectosByPerfilId(perfilId);
    }
    
    @PostMapping
    public ResponseEntity<String> addProyecto(@Valid @RequestBody ProyectoRequest proyectoRequest) {
        return iProyectoService.addProyecto(proyectoRequest);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<String> updateProyecto(@Valid @RequestBody ProyectoRequest proyectoRequest, @PathVariable int id) {
        return iProyectoService.updateProyecto(proyectoRequest, id);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProyecto(@PathVariable int id) {
        return iProyectoService.deleteProyecto(id);
    }
    
}
