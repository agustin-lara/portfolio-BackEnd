package com.agustinlaradesarrollador.portfolioBackEnd.Controller;

import com.agustinlaradesarrollador.portfolioBackEnd.Service.IEmpleoService;
import com.agustinlaradesarrollador.portfolioBackEnd.dto.EmpleoRequest;
import com.agustinlaradesarrollador.portfolioBackEnd.dto.EmpleoResponse;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
    
    @GetMapping("/{perfilId}")
    public List<EmpleoResponse> getAllEmpleosByPerfilId(@PathVariable int perfilId) {
        return iEmpleoService.getAllEmpleosByPerfilId(perfilId);
    }
    
    @PostMapping
    public ResponseEntity<String> addEmpleo(@Valid @RequestBody EmpleoRequest empleoRequest) {
        return iEmpleoService.addEmpleo(empleoRequest);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<String> updateEmpleo(@Valid @RequestBody EmpleoRequest empleoRequest, @PathVariable int id) {
        return iEmpleoService.updateEmpleo(empleoRequest, id);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmpleo(@PathVariable int id) {
        return iEmpleoService.deleteEmpleo(id);
    }
    
}
