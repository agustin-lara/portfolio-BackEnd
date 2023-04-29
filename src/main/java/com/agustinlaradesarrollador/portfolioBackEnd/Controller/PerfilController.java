package com.agustinlaradesarrollador.portfolioBackEnd.Controller;

import com.agustinlaradesarrollador.portfolioBackEnd.Service.IPerfilService;
import com.agustinlaradesarrollador.portfolioBackEnd.dto.PerfilRequest;
import com.agustinlaradesarrollador.portfolioBackEnd.dto.PerfilResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/api/perfil")
@CrossOrigin(origins = "http://localhost:4200")
public class PerfilController {
    
    @Autowired
    private IPerfilService iPerfilService;
    
    @GetMapping
    public PerfilResponse getPerfil() {
        return iPerfilService.getPerfil();
    }
    
    @PostMapping
    public ResponseEntity<String> addPerfil(@Valid @RequestBody PerfilRequest perfilRequest) {
        return iPerfilService.addPerfil(perfilRequest);
    }
    
    @PutMapping
    public ResponseEntity<String> updatePerfil(@Valid @RequestBody PerfilRequest perfilRequest) {
        return iPerfilService.updatePerfil(perfilRequest);
    }
    
    @DeleteMapping
    public ResponseEntity<String> deletePerfil() {
        return iPerfilService.deletePerfil();
    }
    
}
