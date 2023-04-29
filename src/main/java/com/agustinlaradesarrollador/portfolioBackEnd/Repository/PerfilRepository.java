package com.agustinlaradesarrollador.portfolioBackEnd.Repository;

import com.agustinlaradesarrollador.portfolioBackEnd.Model.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Agustín
 */

@Repository
public interface PerfilRepository extends JpaRepository <Perfil, Integer> {
    
}
