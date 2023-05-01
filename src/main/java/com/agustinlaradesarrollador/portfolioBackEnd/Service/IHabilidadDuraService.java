package com.agustinlaradesarrollador.portfolioBackEnd.Service;

import com.agustinlaradesarrollador.portfolioBackEnd.dto.HabilidadDuraRequest;
import com.agustinlaradesarrollador.portfolioBackEnd.dto.HabilidadDuraResponse;
import java.util.List;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Agustín
 */

public interface IHabilidadDuraService {
    
    public List<HabilidadDuraResponse> getAllHabilidadesDurasByPerfilId(int perfilId);
    
    public ResponseEntity<String> addHabilidadDura(HabilidadDuraRequest habilidadDuraRequest);
    
    public ResponseEntity<String> updateHabilidadDura(HabilidadDuraRequest habilidadDuraRequest, int id);
    
    public ResponseEntity<String> deleteHabilidadDura(int id);
    
}
