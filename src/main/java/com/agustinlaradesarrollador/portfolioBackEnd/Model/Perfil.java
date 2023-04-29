package com.agustinlaradesarrollador.portfolioBackEnd.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Agustín
 */

@Getter @Setter
@Entity
public class Perfil {
    
    @Id
//    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "titulo")
    private String titulo;
    
    @Column(name = "descripcion", length = 512)
    private String descripcion;
    
    @Column(name = "imagen_perfil")
    private String imagen_perfil;
    
    @Column(name = "imagen_portada")
    private String imagen_portada;
    
    @OneToMany(mappedBy = "perfil", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Empleo> empleos;
    
    public Perfil(int id, String nombre, String titulo, String descripcion, String imagen_perfil, String imagen_portada) {
        this.id = id;
        this.nombre = nombre;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imagen_perfil = imagen_perfil;
        this.imagen_portada = imagen_portada;
//        Ver si es necesario inicializar la lista de empleos
    }
    
    public Perfil() {
    }
    
}
