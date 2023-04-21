package com.agustinlaradesarrollador.portfolioBackEnd.Service;

import com.agustinlaradesarrollador.portfolioBackEnd.Model.Persona;
import java.util.List;

/**
 *
 * @author Agustín
 */

public interface IPersonaService {
    
    public List<Persona> getPersonas();
    
    public Persona getPersona(int id);
    
    public void savePersona(Persona pers);
    
    public void deletePersona(int id);
    
}
