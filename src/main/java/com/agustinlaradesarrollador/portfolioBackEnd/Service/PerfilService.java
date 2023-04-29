package com.agustinlaradesarrollador.portfolioBackEnd.Service;

import com.agustinlaradesarrollador.portfolioBackEnd.Model.Perfil;
import com.agustinlaradesarrollador.portfolioBackEnd.Repository.PerfilRepository;
import com.agustinlaradesarrollador.portfolioBackEnd.dto.PerfilRequest;
import com.agustinlaradesarrollador.portfolioBackEnd.dto.PerfilResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author Agustín
 */

@Service
public class PerfilService implements IPerfilService {
    
    @Autowired
    private PerfilRepository perfilRepository;
    
    @Override
    public PerfilResponse getPerfil() {
        Perfil perfil = perfilRepository.findById(1).orElse(null);
        if (perfil != null) {
            PerfilResponse perfilResponse = new PerfilResponse(
                    perfil.getNombre(),
                    perfil.getTitulo(),
                    perfil.getDescripcion(),
                    perfil.getImagen_perfil(),
                    perfil.getImagen_portada()
            );
            return perfilResponse;
        }
        return null;
    }
    
    @Override
    public ResponseEntity<String> addPerfil(PerfilRequest perfilRequest) {
        Perfil perfil = perfilRepository.findById(1).orElse(null);
        if (perfil == null) {
            Perfil nuevaPerfil = new Perfil(
                    1,
                    perfilRequest.getNombre(),
                    perfilRequest.getTitulo(),
                    perfilRequest.getDescripcion(),
                    perfilRequest.getImagen_perfil(),
                    perfilRequest.getImagen_portada()
            );
            perfilRepository.save(nuevaPerfil);
            return new ResponseEntity("Perfil creado.", HttpStatus.OK);
        }
        return new ResponseEntity("El Sistema admite como máximo un Perfil.",HttpStatus.FORBIDDEN);
    }
    
    @Override
    public ResponseEntity<String> updatePerfil(PerfilRequest perfilRequest) {
        Perfil perfil = perfilRepository.findById(1).orElse(null);
        if (perfil != null) {
            perfil.setNombre(perfilRequest.getNombre());
            perfil.setTitulo(perfilRequest.getTitulo());
            perfil.setDescripcion(perfilRequest.getDescripcion());
            perfil.setImagen_perfil(perfilRequest.getImagen_perfil());
            perfil.setImagen_portada(perfilRequest.getImagen_portada());
            perfilRepository.save(perfil);
            return new ResponseEntity("Perfil modificado.",HttpStatus.OK);
        }
        return new ResponseEntity("El Sistema aún no tiene un Perfil registrado.",HttpStatus.NOT_FOUND);
    }
    
    @Override
    public ResponseEntity<String> deletePerfil() {
        Perfil perfil = perfilRepository.findById(1).orElse(null);
        if (perfil != null) {
            perfilRepository.deleteById(1);
            return new ResponseEntity("Perfil eliminado.",HttpStatus.OK);
        }
        return new ResponseEntity("El Sistema aún no tiene un Perfil registrado.", HttpStatus.NOT_FOUND);
    }
    
}
