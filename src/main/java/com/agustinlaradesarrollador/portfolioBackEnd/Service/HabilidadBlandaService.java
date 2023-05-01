package com.agustinlaradesarrollador.portfolioBackEnd.Service;

import com.agustinlaradesarrollador.portfolioBackEnd.Model.HabilidadBlanda;
import com.agustinlaradesarrollador.portfolioBackEnd.Model.Perfil;
import com.agustinlaradesarrollador.portfolioBackEnd.Repository.HabilidadBlandaRepository;
import com.agustinlaradesarrollador.portfolioBackEnd.Repository.PerfilRepository;
import com.agustinlaradesarrollador.portfolioBackEnd.dto.HabilidadBlandaRequest;
import com.agustinlaradesarrollador.portfolioBackEnd.dto.HabilidadBlandaResponse;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author Agustín
 */

@Service
public class HabilidadBlandaService implements IHabilidadBlandaService {
    
    @Autowired
    private HabilidadBlandaRepository habilidadRepository;
    
    @Autowired
    private PerfilRepository perfilRepository;

    @Override
    public List<HabilidadBlandaResponse> getAllHabilidadesBlandasByPerfilId(int perfilId) {
        List<HabilidadBlanda> habilidades = habilidadRepository.findByPerfilId(perfilId);
        List<HabilidadBlandaResponse> habilidadResponses = new ArrayList<>();
        for(HabilidadBlanda habilidad : habilidades) {
            habilidadResponses.add(new HabilidadBlandaResponse(
                    habilidad.getId(),
                    habilidad.getNombre(),
                    habilidad.getDescripcion(),
                    habilidad.getImagen(),
                    habilidad.getImagen_alt()
            ));
        }
        return habilidadResponses;
    }

    @Override
    public ResponseEntity<String> addHabilidadBlanda(HabilidadBlandaRequest habilidadBlandaRequest) {
        Perfil perfil = perfilRepository.findById(habilidadBlandaRequest.getPerfilId()).orElse(null);
        if (perfil != null) {
            HabilidadBlanda habilidad = new HabilidadBlanda(
                    habilidadBlandaRequest.getNombre(),
                    habilidadBlandaRequest.getDescripcion(),
                    habilidadBlandaRequest.getImagen(),
                    habilidadBlandaRequest.getImagen_alt(),
                    perfil
            );
            habilidadRepository.save(habilidad);
            return new ResponseEntity("Habilidad blanda creada.",HttpStatus.OK);
        }
        return new ResponseEntity("El ID del Perfil no existe.",HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<String> updateHabilidadBlanda(HabilidadBlandaRequest habilidadBlandaRequest, int id) {
        Perfil perfil = perfilRepository.findById(habilidadBlandaRequest.getPerfilId()).orElse(null);
        HabilidadBlanda habilidad = habilidadRepository.findById(id).orElse(null);
        if (perfil == null && habilidad == null) {
            return new ResponseEntity("El ID del Perfil y de la Habilidad blanda no existen.",HttpStatus.NOT_FOUND);
        }
        if (perfil == null) {
            return new ResponseEntity("El ID del Perfil no existe.",HttpStatus.NOT_FOUND);
        }
        if (habilidad == null) {
             return new ResponseEntity("El ID de la Habilidad blanda no existe.",HttpStatus.NOT_FOUND);
        }
        habilidad.setNombre(habilidadBlandaRequest.getNombre());
        habilidad.setDescripcion(habilidadBlandaRequest.getDescripcion());
        habilidad.setImagen(habilidadBlandaRequest.getImagen());
        habilidad.setImagen_alt(habilidadBlandaRequest.getImagen_alt());
        habilidad.setPerfil(perfil);
        habilidadRepository.save(habilidad);
        return new ResponseEntity("Habilidad blanda modificada.",HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteHabilidadBlanda(int id) {
        HabilidadBlanda habilidad = habilidadRepository.findById(id).orElse(null);
        if (habilidad != null) {
            habilidadRepository.deleteById(id);
            return new ResponseEntity("Habilidad blanda eliminada.",HttpStatus.OK);
        }
        return new ResponseEntity("El ID de la Habilidad blanda no existe.",HttpStatus.NOT_FOUND);
    }
    
}
