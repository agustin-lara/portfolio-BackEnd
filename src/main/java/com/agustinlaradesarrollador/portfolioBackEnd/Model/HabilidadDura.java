package com.agustinlaradesarrollador.portfolioBackEnd.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Agustín
 */

@Getter @Setter
@Entity
public class HabilidadDura {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "dominio")
    private int dominio;
    
    @Column(name = "imagen")
    private String imagen;
    
    @Column (name = "imagen_alt")
    private String imagen_alt;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "perfil_id", nullable = false)
    private Perfil perfil;
    
    public HabilidadDura(String nombre, int dominio, String imagen, String imagen_alt, Perfil perfil) {
        this.nombre = nombre;
        this.dominio = dominio;
        this.imagen = imagen;
        this.imagen_alt = imagen_alt;
        this.perfil = perfil;
    }
    
    public HabilidadDura() {
    }
    
}
