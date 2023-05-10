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
public class Formacion {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "fecha")
    private String fecha;
    
    @Column(name = "imagen")
    private String imagen;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "perfil_id", nullable = false)
    private Perfil perfil;
    
    public Formacion(String nombre, String fecha, String imagen, Perfil perfil) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.imagen = imagen;
        this.perfil = perfil;
    }
    
    public Formacion() {
    }
    
}
