package com.agustinlaradesarrollador.portfolioBackEnd.dto;

import lombok.Data;

/**
 *
 * @author Agustín
 */

@Data
public class HabilidadDuraResponse {
    
    private int id;
    private String nombre;
    private int dominio;
    private String color;
    
    public HabilidadDuraResponse(int id, String nombre, int dominio, String color) {
        this.id = id;
        this.nombre = nombre;
        this.dominio = dominio;
        this.color = color;
    }
    
}
