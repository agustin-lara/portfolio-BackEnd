package com.agustinlaradesarrollador.portfolioBackEnd.Repository;

import com.agustinlaradesarrollador.portfolioBackEnd.Model.Formacion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Agustín
 */

@Repository
public interface FormacionRepository extends JpaRepository <Formacion, Integer> {
    List<Formacion> findByPerfilId(int perfilId);
}
