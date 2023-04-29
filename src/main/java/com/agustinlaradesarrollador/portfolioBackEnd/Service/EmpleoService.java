package com.agustinlaradesarrollador.portfolioBackEnd.Service;

import com.agustinlaradesarrollador.portfolioBackEnd.Model.Empleo;
import com.agustinlaradesarrollador.portfolioBackEnd.Model.Perfil;
import com.agustinlaradesarrollador.portfolioBackEnd.Repository.EmpleoRepository;
import com.agustinlaradesarrollador.portfolioBackEnd.Repository.PerfilRepository;
import com.agustinlaradesarrollador.portfolioBackEnd.dto.EmpleoRequest;
import com.agustinlaradesarrollador.portfolioBackEnd.dto.EmpleoResponse;
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
public class EmpleoService implements IEmpleoService {

    @Autowired
    private EmpleoRepository empleoRepository;
    
    @Autowired
    private PerfilRepository perfilRepository;

    @Override
    public List<EmpleoResponse> getAllEmpleosByPerfilId(int perfilId) {
        List<Empleo> empleos = empleoRepository.findByPerfilId(perfilId);
        List<EmpleoResponse> empleoResponses = new ArrayList<>();
        for(Empleo empleo : empleos) {
            empleoResponses.add(new EmpleoResponse(
                    empleo.getId(),
                    empleo.getNombre(),
                    empleo.getFecha_inicio(),
                    empleo.getFecha_fin()
            ));
        }
        return empleoResponses;
    }
    
    @Override
    public ResponseEntity<String> addEmpleo(EmpleoRequest empleoRequest) {
        Perfil perfil = perfilRepository.findById(empleoRequest.getPerfilId()).orElse(null);
        if (perfil != null) {
            Empleo empleo = new Empleo(
                    empleoRequest.getNombre(),
                    empleoRequest.getFecha_inicio(),
                    empleoRequest.getFecha_fin(),
                    perfil
            );
            empleoRepository.save(empleo);
            return new ResponseEntity("Empleo creado.",HttpStatus.OK);
        }
        return new ResponseEntity("El ID del Perfil no existe.",HttpStatus.NOT_FOUND);
    }
    
    @Override
    public ResponseEntity<String> updateEmpleo(EmpleoRequest empleoRequest, int id) {
        Perfil perfil = perfilRepository.findById(empleoRequest.getPerfilId()).orElse(null);
        Empleo empleo = empleoRepository.findById(id).orElse(null);
        if (perfil == null && empleo == null) {
            return new ResponseEntity("El ID del Perfil y del Empleo no existen.",HttpStatus.NOT_FOUND);
        }
        if (perfil == null) {
            return new ResponseEntity("El ID del Perfil no existe.",HttpStatus.NOT_FOUND);
        }
        if (empleo == null) {
             return new ResponseEntity("El ID del Empleo no existe.",HttpStatus.NOT_FOUND);
        }
        // Aplicar modificaciones
        empleo.setNombre(empleoRequest.getNombre());
        empleo.setFecha_inicio(empleoRequest.getFecha_inicio());
        empleo.setFecha_fin(empleoRequest.getFecha_fin());
        empleo.setPerfil(perfil);
        empleoRepository.save(empleo);
        return new ResponseEntity("Empleo modificado.",HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteEmpleo(int id) {
        Empleo empleo = empleoRepository.findById(id).orElse(null);
        if (empleo != null) {
            empleoRepository.deleteById(id);
            return new ResponseEntity("Empleo eliminado.",HttpStatus.OK);
        }
        return new ResponseEntity("El ID del Empleo no existe.",HttpStatus.NOT_FOUND);
    }
    
}
