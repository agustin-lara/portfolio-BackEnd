package com.agustinlaradesarrollador.portfolioBackEnd.Repository;

import com.agustinlaradesarrollador.portfolioBackEnd.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Agustín
 */

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByUsername(String username);
}
