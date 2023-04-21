package com.agustinlaradesarrollador.portfolioBackEnd.Service;

import com.agustinlaradesarrollador.portfolioBackEnd.Model.Empleo;
import com.agustinlaradesarrollador.portfolioBackEnd.Repository.EmpleoRepository;
import com.agustinlaradesarrollador.portfolioBackEnd.Repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Agustín
 */

@Service
public class EmpleoService implements IEmpleoService {

    @Autowired
    private EmpleoRepository empleoRepository;
    
    @Override
    public List<Empleo> getAllEmpleos() {
        List<Empleo> listaEmpleos = empleoRepository.findAll();
        return listaEmpleos;
    }

    @Override
    public Empleo getEmpleo(int id) {
        Empleo empleo = empleoRepository.findById(id).orElse(null);
        return empleo;
    }

    @Override
    public void addEmpleo(Empleo empleo) {
        
        empleoRepository.save(empleo);
    }

    @Override
    public void deleteEmpleo(int id) {
        empleoRepository.deleteById(id);
    }
    
    @Override
    public List<Empleo> getAllEmpleosByPersona(int personaId) {
        return empleoRepository.findByPersonaId(personaId);
    }
    
}
