package com.agustinlaradesarrollador.portfolioBackEnd.Service;

import com.agustinlaradesarrollador.portfolioBackEnd.Model.HabilidadDura;
import com.agustinlaradesarrollador.portfolioBackEnd.Model.Perfil;
import com.agustinlaradesarrollador.portfolioBackEnd.Repository.HabilidadDuraRepository;
import com.agustinlaradesarrollador.portfolioBackEnd.Repository.PerfilRepository;
import com.agustinlaradesarrollador.portfolioBackEnd.dto.HabilidadDuraRequest;
import com.agustinlaradesarrollador.portfolioBackEnd.dto.HabilidadDuraResponse;
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
public class HabilidadDuraService implements IHabilidadDuraService {
    
    @Autowired
    private HabilidadDuraRepository habilidadRepository;
    
    @Autowired
    private PerfilRepository perfilRepository;

    @Override
    public List<HabilidadDuraResponse> getAllHabilidadesDurasByPerfilId(int perfilId) {
        List<HabilidadDura> habilidades = habilidadRepository.findByPerfilId(perfilId);
        List<HabilidadDuraResponse> habilidadResponses = new ArrayList<>();
        for(HabilidadDura habilidad : habilidades) {
            habilidadResponses.add(new HabilidadDuraResponse(
                    habilidad.getId(),
                    habilidad.getNombre(),
                    habilidad.getDominio(),
                    habilidad.getImagen(),
                    habilidad.getImagen_alt()
            ));
        }
        return habilidadResponses;
    }

    @Override
    public ResponseEntity<String> addHabilidadDura(HabilidadDuraRequest habilidadDuraRequest) {
        Perfil perfil = perfilRepository.findById(habilidadDuraRequest.getPerfilId()).orElse(null);
        if (perfil != null) {
            HabilidadDura habilidad = new HabilidadDura(
                    habilidadDuraRequest.getNombre(),
                    habilidadDuraRequest.getDominio(),
                    habilidadDuraRequest.getImagen(),
                    habilidadDuraRequest.getImagen_alt(),
                    perfil
            );
            habilidadRepository.save(habilidad);
            return new ResponseEntity("Habilidad dura creada.",HttpStatus.OK);
        }
        return new ResponseEntity("El ID del Perfil no existe.",HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<String> updateHabilidadDura(HabilidadDuraRequest habilidadDuraRequest, int id) {
        Perfil perfil = perfilRepository.findById(habilidadDuraRequest.getPerfilId()).orElse(null);
        HabilidadDura habilidad = habilidadRepository.findById(id).orElse(null);
        if (perfil == null && habilidad == null) {
            return new ResponseEntity("El ID del Perfil y de la Habilidad dura no existen.",HttpStatus.NOT_FOUND);
        }
        if (perfil == null) {
            return new ResponseEntity("El ID del Perfil no existe.",HttpStatus.NOT_FOUND);
        }
        if (habilidad == null) {
             return new ResponseEntity("El ID de la Habilidad dura no existe.",HttpStatus.NOT_FOUND);
        }
        habilidad.setNombre(habilidadDuraRequest.getNombre());
        habilidad.setDominio(habilidadDuraRequest.getDominio());
        habilidad.setImagen(habilidadDuraRequest.getImagen());
        habilidad.setImagen_alt(habilidadDuraRequest.getImagen_alt());
        habilidad.setPerfil(perfil);
        habilidadRepository.save(habilidad);
        return new ResponseEntity("Habilidad dura modificada.",HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteHabilidadDura(int id) {
        HabilidadDura habilidad = habilidadRepository.findById(id).orElse(null);
        if (habilidad != null) {
            habilidadRepository.deleteById(id);
            return new ResponseEntity("Habilidad dura eliminada.",HttpStatus.OK);
        }
        return new ResponseEntity("El ID de la Habilidad dura no existe.",HttpStatus.NOT_FOUND);
    }
    
}
