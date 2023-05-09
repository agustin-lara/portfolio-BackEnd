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
    private String institucion;
    private String fecha;
    private String imagen;
    
    public EmpleoResponse(int id, String nombre, String institucion, String fecha, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.institucion = institucion;
        this.fecha = fecha;
        this.imagen = imagen;
    }
    
}
