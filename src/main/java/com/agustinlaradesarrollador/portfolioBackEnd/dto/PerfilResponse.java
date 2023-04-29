package com.agustinlaradesarrollador.portfolioBackEnd.dto;

import lombok.Data;

/**
 *
 * @author Agustín
 */

@Data
public class PerfilResponse {
    
//    private int id;
    private String nombre;
    private String titulo;
    private String descripcion;
    private String imagen_perfil;
    private String imagen_portada;
    
//    public PersonaResponse(int id, String nombre, String titulo, String descripcion, String imagen_perfil, String imagen_portada) {
    public PerfilResponse(String nombre, String titulo, String descripcion, String imagen_perfil, String imagen_portada) {
//        this.id = id;
        this.nombre = nombre;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imagen_perfil = imagen_perfil;
        this.imagen_portada = imagen_portada;
    }
    
}
