package com.agustinlaradesarrollador.portfolioBackEnd.Service;

import com.agustinlaradesarrollador.portfolioBackEnd.dto.HabilidadBlandaRequest;
import com.agustinlaradesarrollador.portfolioBackEnd.dto.HabilidadBlandaResponse;
import java.util.List;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Agustín
 */

public interface IHabilidadBlandaService {
    
    public List<HabilidadBlandaResponse> getAllHabilidadesBlandasByPerfilId(int perfilId);
    
    public ResponseEntity<String> addHabilidadBlanda(HabilidadBlandaRequest habilidadBlandaRequest);
    
    public ResponseEntity<String> updateHabilidadBlanda(HabilidadBlandaRequest habilidadBlandaRequest, int id);
    
    public ResponseEntity<String> deleteHabilidadBlanda(int id);
    
}
