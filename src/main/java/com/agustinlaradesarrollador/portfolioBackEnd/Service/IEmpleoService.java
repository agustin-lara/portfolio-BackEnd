package com.agustinlaradesarrollador.portfolioBackEnd.Service;

import com.agustinlaradesarrollador.portfolioBackEnd.Model.Empleo;
import java.util.List;

/**
 *
 * @author Agustín
 */

public interface IEmpleoService {
    
    public List<Empleo> getAllEmpleos();
    
    public Empleo getEmpleo(int id);
    
    public void addEmpleo(Empleo empleo);
    
    public void deleteEmpleo(int id);
    
    public List<Empleo> getAllEmpleosByPersona(int personaId);
    
}
