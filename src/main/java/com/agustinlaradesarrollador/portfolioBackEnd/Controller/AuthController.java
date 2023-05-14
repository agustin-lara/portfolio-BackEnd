package com.agustinlaradesarrollador.portfolioBackEnd.Controller;

import com.agustinlaradesarrollador.portfolioBackEnd.Model.Usuario;
import com.agustinlaradesarrollador.portfolioBackEnd.Repository.UsuarioRepository;
import com.agustinlaradesarrollador.portfolioBackEnd.dto.LoginRequest;
import com.agustinlaradesarrollador.portfolioBackEnd.dto.TokenRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Agustín
 */

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @PostMapping("/check")
    public ResponseEntity<String> checkToken(@RequestBody TokenRequest tokenRequest) {
        Usuario usuario = usuarioRepository.findByUsername(tokenRequest.getUsername());
        if (usuario != null) {
            if (tokenRequest.getToken().equals(usuario.getToken())) {
                return new ResponseEntity<>("Permiso concedido", HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("Permiso denegado", HttpStatus.UNAUTHORIZED);
    }
    
    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody LoginRequest loginRequest) {
        
        Usuario usuario = usuarioRepository.findByUsername(loginRequest.getUsername());
        
        if (usuario != null) {
            if (loginRequest.getPassword().equals(usuario.getPassword())) {
                return new ResponseEntity(usuario.getToken(), HttpStatus.OK);
            }
        }
        return new ResponseEntity("El nombre de usuario o la contraseña son incorrectos.", HttpStatus.UNAUTHORIZED);
    }
    
    
}
