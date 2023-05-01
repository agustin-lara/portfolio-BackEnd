package com.agustinlaradesarrollador.portfolioBackEnd.dto;

import lombok.Data;

/**
 *
 * @author Agustín
 */

@Data
public class HabilidadBlandaResponse {
    
    private int id;
    private String nombre;
    private String descripcion;
    private String imagen;
    private String imagen_alt;
    
    public HabilidadBlandaResponse(int id, String nombre, String descripcion, String imagen, String imagen_alt) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.imagen_alt = imagen_alt;
    }
    
}
