package com.agustinlaradesarrollador.portfolioBackEnd.Service;

import com.agustinlaradesarrollador.portfolioBackEnd.Model.Formacion;
import com.agustinlaradesarrollador.portfolioBackEnd.Model.Perfil;
import com.agustinlaradesarrollador.portfolioBackEnd.Repository.FormacionRepository;
import com.agustinlaradesarrollador.portfolioBackEnd.Repository.PerfilRepository;
import com.agustinlaradesarrollador.portfolioBackEnd.dto.FormacionRequest;
import com.agustinlaradesarrollador.portfolioBackEnd.dto.FormacionResponse;
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
public class FormacionService implements IFormacionService {
    
    @Autowired
    private FormacionRepository formacionRepository;
    
    @Autowired
    private PerfilRepository perfilRepository;

    @Override
    public List<FormacionResponse> getAllFormacionesByPerfilId(int perfilId) {
        List<Formacion> formaciones = formacionRepository.findByPerfilId(perfilId);
        List<FormacionResponse> formacionResponses = new ArrayList<>();
        for(Formacion formacion : formaciones) {
            formacionResponses.add(new FormacionResponse(
                    formacion.getId(),
                    formacion.getNombre(),
                    formacion.getFecha(),
                    formacion.getImagen()
            ));
        }
        return formacionResponses;
    }

    @Override
    public ResponseEntity<String> addFormacion(FormacionRequest formacionRequest) {
        Perfil perfil = perfilRepository.findById(formacionRequest.getPerfilId()).orElse(null);
        if (perfil != null) {
            Formacion formacion = new Formacion(
                    formacionRequest.getNombre(),
                    formacionRequest.getFecha(),
                    formacionRequest.getImagen(),
                    perfil
            );
            formacionRepository.save(formacion);
            return new ResponseEntity("Formación creada.",HttpStatus.OK);
        }
        return new ResponseEntity("El ID del Perfil no existe.",HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<String> updateFormacion(FormacionRequest formacionRequest, int id) {
        Perfil perfil = perfilRepository.findById(formacionRequest.getPerfilId()).orElse(null);
        Formacion formacion = formacionRepository.findById(id).orElse(null);
        if (perfil == null && formacion == null) {
            return new ResponseEntity("El ID del Perfil y de la Formación no existen.",HttpStatus.NOT_FOUND);
        }
        if (perfil == null) {
            return new ResponseEntity("El ID del Perfil no existe.",HttpStatus.NOT_FOUND);
        }
        if (formacion == null) {
             return new ResponseEntity("El ID de la Formación no existe.",HttpStatus.NOT_FOUND);
        }
        formacion.setNombre(formacionRequest.getNombre());
        formacion.setFecha(formacionRequest.getFecha());
        formacion.setImagen(formacionRequest.getImagen());
        formacion.setPerfil(perfil);
        formacionRepository.save(formacion);
        return new ResponseEntity("Formación modificada.",HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteFormacion(int id) {
        Formacion formacion = formacionRepository.findById(id).orElse(null);
        if (formacion != null) {
            formacionRepository.deleteById(id);
            return new ResponseEntity("Formación eliminada.",HttpStatus.OK);
        }
        return new ResponseEntity("El ID de la Formación no existe.",HttpStatus.NOT_FOUND);
    }
    
}
