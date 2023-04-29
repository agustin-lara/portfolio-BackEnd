package com.agustinlaradesarrollador.portfolioBackEnd.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    @Size(min = 8, message = "Fecha de inicio debe tener al menos 8 caracteres.")
    private String fecha_inicio;
    
    @NotBlank
    @Size(min = 8, message = "Fecha de fin debe tener al menos 8 caracteres.")
    private String fecha_fin;
    
    @NotNull
    private int perfilId;
    
}
