package com.agustinlaradesarrollador.portfolioBackEnd.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 *
 * @author Agustín
 */

@Data
public class LoginRequest {
    
    @NotBlank
    @Size(min = 6, max = 22)
    private String username;
    
    @NotBlank
    @Size(min = 8, max = 22)
    private String password;
    
}
