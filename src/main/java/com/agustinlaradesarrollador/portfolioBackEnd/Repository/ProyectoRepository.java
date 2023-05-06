package com.agustinlaradesarrollador.portfolioBackEnd.Repository;

import com.agustinlaradesarrollador.portfolioBackEnd.Model.Proyecto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Agustín
 */

@Repository
public interface ProyectoRepository extends JpaRepository <Proyecto, Integer> {
    List<Proyecto> findByPerfilId(int perfilId);
}
