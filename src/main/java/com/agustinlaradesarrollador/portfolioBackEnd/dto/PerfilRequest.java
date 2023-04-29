package com.agustinlaradesarrollador.portfolioBackEnd.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 *
 * @author Agustín
 */

@Data
public class PerfilRequest {
    
    @NotBlank
    @NotNull
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
