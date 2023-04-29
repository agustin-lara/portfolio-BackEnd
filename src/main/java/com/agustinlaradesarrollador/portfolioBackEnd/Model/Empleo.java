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
public class Empleo {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "fecha_inicio")
    private String fecha_inicio;
    
    @Column(name = "fecha_fin")
    private String fecha_fin;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "perfil_id", nullable = false)
    private Perfil perfil;
    
    public Empleo(String nombre, String fecha_inicio, String fecha_fin, Perfil perfil) {
        this.nombre = nombre;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.perfil = perfil;
    }
    
    public Empleo() {
    }
    
}
