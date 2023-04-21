package com.agustinlaradesarrollador.portfolioBackEnd.Service;

import com.agustinlaradesarrollador.portfolioBackEnd.Model.Persona;
import com.agustinlaradesarrollador.portfolioBackEnd.Repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Agustín
 */

@Service
public class PersonaService implements IPersonaService {
    
    @Autowired
    private PersonaRepository persRepository;
    
    @Override
    public List<Persona> getPersonas() {
        List<Persona> listaPersonas = persRepository.findAll();
        return listaPersonas;
    }
    
    @Override
    public Persona getPersona(int id) {
        Persona pers = persRepository.findById(id).orElse(null);
        return pers;
    }

    @Override
    public void savePersona(Persona pers) {
        persRepository.save(pers);
    }
    
    @Override
    public void deletePersona(int id) {
        persRepository.deleteById(id);
    }
    
}
