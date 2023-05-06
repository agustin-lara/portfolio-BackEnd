package com.agustinlaradesarrollador.portfolioBackEnd.Service;

import com.agustinlaradesarrollador.portfolioBackEnd.dto.ProyectoRequest;
import com.agustinlaradesarrollador.portfolioBackEnd.dto.ProyectoResponse;
import java.util.List;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Agustín
 */

public interface IProyectoService {
    
    public List<ProyectoResponse> getAllProyectosByPerfilId(int perfilId);
    
    public ResponseEntity<String> addProyecto(ProyectoRequest proyectoRequest);
    
    public ResponseEntity<String> updateProyecto(ProyectoRequest proyectoRequest, int id);
    
    public ResponseEntity<String> deleteProyecto(int id);
    
}
