package com.agustinlaradesarrollador.portfolioBackEnd.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 *
 * @author Agustín
 */

@Data
public class HabilidadDuraRequest {
    
    @NotBlank
    private String nombre;
    
    @NotNull
    @Min(value = 0)
    @Max(value = 100)
    private int dominio;
    
    @NotBlank
    private String imagen;
    
    @NotBlank
    private String imagen_alt;
    
    @NotNull
    private int perfilId;
    
}
