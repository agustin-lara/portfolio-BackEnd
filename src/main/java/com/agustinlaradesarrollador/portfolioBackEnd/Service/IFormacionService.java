package com.agustinlaradesarrollador.portfolioBackEnd.Service;

import com.agustinlaradesarrollador.portfolioBackEnd.dto.FormacionRequest;
import com.agustinlaradesarrollador.portfolioBackEnd.dto.FormacionResponse;
import java.util.List;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Agustín
 */

public interface IFormacionService {
    
    public List<FormacionResponse> getAllFormacionesByPerfilId(int perfilId);
    
    public ResponseEntity<String> addFormacion(FormacionRequest formacionRequest);
    
    public ResponseEntity<String> updateFormacion(FormacionRequest formacionRequest, int id);
    
    public ResponseEntity<String> deleteFormacion(int id);
    
}
