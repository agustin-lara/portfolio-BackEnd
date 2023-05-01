package com.agustinlaradesarrollador.portfolioBackEnd.Repository;

import com.agustinlaradesarrollador.portfolioBackEnd.Model.HabilidadDura;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Agustín
 */

@Repository
public interface HabilidadDuraRepository extends JpaRepository <HabilidadDura, Integer> {
    List<HabilidadDura> findByPerfilId(int perfilId);
}
