package com.agustinlaradesarrollador.portfolioBackEnd.dto;

import lombok.Data;

/**
 *
 * @author Agustín
 */

@Data
public class FormacionResponse {
    
    private int id;
    private String nombre;
    private String fecha;
    private String imagen;
    
    public FormacionResponse(int id, String nombre, String fecha, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.imagen = imagen;
    }
    
}
