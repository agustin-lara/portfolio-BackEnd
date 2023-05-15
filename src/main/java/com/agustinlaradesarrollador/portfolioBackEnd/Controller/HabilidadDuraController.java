package com.agustinlaradesarrollador.portfolioBackEnd.Controller;

import com.agustinlaradesarrollador.portfolioBackEnd.Service.IHabilidadDuraService;
import com.agustinlaradesarrollador.portfolioBackEnd.dto.HabilidadDuraRequest;
import com.agustinlaradesarrollador.portfolioBackEnd.dto.HabilidadDuraResponse;
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
@RequestMapping("/api/habilidades-duras")
@CrossOrigin(origins = "https://portfolio-frontend-la.web.app")
public class HabilidadDuraController {
    
    @Autowired
    private IHabilidadDuraService iHabilidadDuraService;
    
    @GetMapping("/{perfilId}")
    public List<HabilidadDuraResponse> getAllHabilidadesDurasByPerfilId(@PathVariable int perfilId) {
        return iHabilidadDuraService.getAllHabilidadesDurasByPerfilId(perfilId);
    }
    
    @PostMapping
    public ResponseEntity<String> addHabilidadDura(@Valid @RequestBody HabilidadDuraRequest habilidadDuraRequest) {
        return iHabilidadDuraService.addHabilidadDura(habilidadDuraRequest);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<String> updateHabilidadDura(@Valid @RequestBody HabilidadDuraRequest habilidadDuraRequest, @PathVariable int id) {
        return iHabilidadDuraService.updateHabilidadDura(habilidadDuraRequest, id);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteHabilidadDura(@PathVariable int id) {
        return iHabilidadDuraService.deleteHabilidadDura(id);
    }
    
}
