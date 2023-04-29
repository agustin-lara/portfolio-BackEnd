package com.agustinlaradesarrollador.portfolioBackEnd.Service;

import com.agustinlaradesarrollador.portfolioBackEnd.dto.PerfilRequest;
import com.agustinlaradesarrollador.portfolioBackEnd.dto.PerfilResponse;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Agustín
 */

public interface IPerfilService {
    
    public PerfilResponse getPerfil();
    
    public ResponseEntity<String> addPerfil(PerfilRequest perfilRequest);
    
    public ResponseEntity<String> updatePerfil(PerfilRequest perfilRequest);
    
    public ResponseEntity<String> deletePerfil();
    
}
