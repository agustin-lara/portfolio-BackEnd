package com.agustinlaradesarrollador.portfolioBackEnd.dto;

import lombok.Data;

/**
 *
 * @author Agustín
 */

@Data
public class EmpleoResponse {
    
    private int id;
    private String nombre;
    private String fecha_inicio;
    private String fecha_fin;
    
    public EmpleoResponse(int id, String nombre, String fecha_inicio, String fecha_fin) {
        this.id = id;
        this.nombre = nombre;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
    }
    
}
