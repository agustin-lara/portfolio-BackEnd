package com.agustinlaradesarrollador.portfolioBackEnd.Service;

import com.agustinlaradesarrollador.portfolioBackEnd.dto.EmpleoRequest;
import com.agustinlaradesarrollador.portfolioBackEnd.dto.EmpleoResponse;
import java.util.List;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Agustín
 */

public interface IEmpleoService {
    
    public List<EmpleoResponse> getAllEmpleosByPerfilId(int perfilId);
    
    public ResponseEntity<String> addEmpleo(EmpleoRequest empleoRequest);
    
    public ResponseEntity<String> updateEmpleo(EmpleoRequest empleoRequest, int id);
    
    public ResponseEntity<String> deleteEmpleo(int id);
    
}
