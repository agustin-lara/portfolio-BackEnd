package com.agustinlaradesarrollador.portfolioBackEnd.Controller;

import com.agustinlaradesarrollador.portfolioBackEnd.Service.IHabilidadBlandaService;
import com.agustinlaradesarrollador.portfolioBackEnd.dto.HabilidadBlandaRequest;
import com.agustinlaradesarrollador.portfolioBackEnd.dto.HabilidadBlandaResponse;
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
@RequestMapping("/api/habilidades-blandas")
@CrossOrigin(origins = "https://portfolio-frontend-la.web.app")
public class HabilidadBlandaController {
    
    @Autowired
    private IHabilidadBlandaService iHabilidadBlandaService;
    
    @GetMapping("/{perfilId}")
    public List<HabilidadBlandaResponse> getAllHabilidadesBlandasByPerfilId(@PathVariable int perfilId) {
        return iHabilidadBlandaService.getAllHabilidadesBlandasByPerfilId(perfilId);
    }
    
    @PostMapping
    public ResponseEntity<String> addHabilidadBlanda(@Valid @RequestBody HabilidadBlandaRequest habilidadBlandaRequest) {
        return iHabilidadBlandaService.addHabilidadBlanda(habilidadBlandaRequest);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<String> updateHabilidadBlanda(@Valid @RequestBody HabilidadBlandaRequest habilidadBlandaRequest, @PathVariable int id) {
        return iHabilidadBlandaService.updateHabilidadBlanda(habilidadBlandaRequest, id);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteHabilidadBlanda(@PathVariable int id) {
        return iHabilidadBlandaService.deleteHabilidadBlanda(id);
    }
    
}
