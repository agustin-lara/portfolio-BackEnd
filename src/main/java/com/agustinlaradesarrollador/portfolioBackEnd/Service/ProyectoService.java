package com.agustinlaradesarrollador.portfolioBackEnd.Service;

import com.agustinlaradesarrollador.portfolioBackEnd.Model.Perfil;
import com.agustinlaradesarrollador.portfolioBackEnd.Model.Proyecto;
import com.agustinlaradesarrollador.portfolioBackEnd.Repository.PerfilRepository;
import com.agustinlaradesarrollador.portfolioBackEnd.Repository.ProyectoRepository;
import com.agustinlaradesarrollador.portfolioBackEnd.dto.ProyectoRequest;
import com.agustinlaradesarrollador.portfolioBackEnd.dto.ProyectoResponse;
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
public class ProyectoService implements IProyectoService {

    @Autowired
    private ProyectoRepository proyectoRepository;
    
    @Autowired
    private PerfilRepository perfilRepository;
    
    @Override
    public List<ProyectoResponse> getAllProyectosByPerfilId(int perfilId) {
        List<Proyecto> proyectos = proyectoRepository.findByPerfilId(perfilId);
        List<ProyectoResponse> proyectoResponses = new ArrayList<>();
        for(Proyecto proyecto : proyectos) {
            proyectoResponses.add(new ProyectoResponse(
                    proyecto.getId(),
                    proyecto.getNombre(),
                    proyecto.getDescripcion(),
                    proyecto.getTecnologias(),
                    proyecto.getImagen()
            ));
        }
        return proyectoResponses;
    }

    @Override
    public ResponseEntity<String> addProyecto(ProyectoRequest proyectoRequest) {
        Perfil perfil = perfilRepository.findById(proyectoRequest.getPerfilId()).orElse(null);
        if (perfil != null) {
            Proyecto proyecto = new Proyecto(
                    proyectoRequest.getNombre(),
                    proyectoRequest.getDescripcion(),
                    proyectoRequest.getTecnologias(),
                    proyectoRequest.getImagen(),
                    perfil
            );
            proyectoRepository.save(proyecto);
            return new ResponseEntity("Proyecto creado.",HttpStatus.OK);
        }
        return new ResponseEntity("El ID del Perfil no existe.",HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<String> updateProyecto(ProyectoRequest proyectoRequest, int id) {
        Perfil perfil = perfilRepository.findById(proyectoRequest.getPerfilId()).orElse(null);
        Proyecto proyecto = proyectoRepository.findById(id).orElse(null);
        if (perfil == null && proyecto == null) {
            return new ResponseEntity("El ID del Perfil y del Proyecto no existen.",HttpStatus.NOT_FOUND);
        }
        if (perfil == null) {
            return new ResponseEntity("El ID del Perfil no existe.",HttpStatus.NOT_FOUND);
        }
        if (proyecto == null) {
             return new ResponseEntity("El ID del Proyecto no existe.",HttpStatus.NOT_FOUND);
        }
        proyecto.setNombre(proyectoRequest.getNombre());
        proyecto.setDescripcion(proyectoRequest.getDescripcion());
        proyecto.setTecnologias(proyectoRequest.getTecnologias());
        proyecto.setImagen(proyectoRequest.getImagen());
        proyecto.setPerfil(perfil);
        proyectoRepository.save(proyecto);
        return new ResponseEntity("Proyecto modificado.",HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteProyecto(int id) {
        Proyecto proyecto = proyectoRepository.findById(id).orElse(null);
        if (proyecto != null) {
            proyectoRepository.deleteById(id);
            return new ResponseEntity("Proyecto eliminado.",HttpStatus.OK);
        }
        return new ResponseEntity("El ID del Proyecto no existe.",HttpStatus.NOT_FOUND);
    }
    
}
