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
    private String imagen;
    private String imagen_alt;
    
    public HabilidadDuraResponse(int id, String nombre, int dominio, String imagen, String imagen_alt) {
        this.id = id;
        this.nombre = nombre;
        this.dominio = dominio;
        this.imagen = imagen;
        this.imagen_alt = imagen_alt;
    }
    
}
