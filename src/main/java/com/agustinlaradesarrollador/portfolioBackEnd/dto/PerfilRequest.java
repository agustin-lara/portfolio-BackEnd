package com.agustinlaradesarrollador.portfolioBackEnd.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 *
 * @author Agustín
 */

@Data
public class PerfilRequest {
    
    @NotBlank
    private String nombre;
    
    @NotBlank
    private String titulo;
    
    @NotBlank
    private String descripcion;
    
    @NotBlank
    private String imagen_perfil;
    
    @NotBlank
    private String imagen_portada;
    
}
