package com.agustinlaradesarrollador.portfolioBackEnd.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 *
 * @author Agustín
 */

@Data
public class EmpleoRequest {
    
    @NotBlank
    private String nombre;
    
    @NotBlank
    private String institucion;
    
    @NotBlank
    private String fecha;
    
    @NotBlank
    private String imagen;
    
    @NotNull
    private int perfilId;
    
}
