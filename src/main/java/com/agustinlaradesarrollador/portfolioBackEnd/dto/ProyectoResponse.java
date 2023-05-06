package com.agustinlaradesarrollador.portfolioBackEnd.dto;

import lombok.Data;

/**
 *
 * @author Agustín
 */

@Data
public class ProyectoResponse {
    
    private int id;
    private String nombre;
    private String descripcion;
    private String tecnologias;
    private String imagen;
    
    public ProyectoResponse(int id, String nombre, String descripcion, String tecnologias, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tecnologias = tecnologias;
        this.imagen = imagen;
    }
    
}
