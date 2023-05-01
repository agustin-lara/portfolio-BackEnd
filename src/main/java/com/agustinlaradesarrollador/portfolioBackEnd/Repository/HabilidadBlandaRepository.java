package com.agustinlaradesarrollador.portfolioBackEnd.Repository;

import com.agustinlaradesarrollador.portfolioBackEnd.Model.HabilidadBlanda;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Agustín
 */

@Repository
public interface HabilidadBlandaRepository extends JpaRepository <HabilidadBlanda, Integer> {
    List<HabilidadBlanda> findByPerfilId(int perfilId);
}
