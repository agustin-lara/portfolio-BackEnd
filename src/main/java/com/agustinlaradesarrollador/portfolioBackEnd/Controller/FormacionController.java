package com.agustinlaradesarrollador.portfolioBackEnd.Controller;

import com.agustinlaradesarrollador.portfolioBackEnd.Service.IFormacionService;
import com.agustinlaradesarrollador.portfolioBackEnd.dto.FormacionRequest;
import com.agustinlaradesarrollador.portfolioBackEnd.dto.FormacionResponse;
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
@RequestMapping("/api/formaciones")
@CrossOrigin(origins = "https://portfolio-frontend-la.web.app")
public class FormacionController {
    
    @Autowired
    private IFormacionService iFormacionService;
    
    @GetMapping("/{perfilId}")
    public List<FormacionResponse> getAllFormacionesByPerfilId(@PathVariable int perfilId) {
        return iFormacionService.getAllFormacionesByPerfilId(perfilId);
    }
    
    @PostMapping
    public ResponseEntity<String> addFormacion(@Valid @RequestBody FormacionRequest formacionRequest) {
        return iFormacionService.addFormacion(formacionRequest);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<String> updateFormacion(@Valid @RequestBody FormacionRequest formacionRequest, @PathVariable int id) {
        return iFormacionService.updateFormacion(formacionRequest, id);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFormacion(@PathVariable int id) {
        return iFormacionService.deleteFormacion(id);
    }
    
}
