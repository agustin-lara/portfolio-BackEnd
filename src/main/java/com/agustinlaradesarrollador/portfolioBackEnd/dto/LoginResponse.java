package com.agustinlaradesarrollador.portfolioBackEnd.dto;

import lombok.Data;

/**
 *
 * @author Agustín
 */

@Data
public class LoginResponse {
    
    private String username;
    
    public LoginResponse(String username) {
        this.username = username;
    }
    
}
