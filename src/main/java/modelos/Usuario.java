package modelos;

import javax.persistence.*;
import java.util.List;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String email;
    private String imagenPerfil;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private UsuarioDetalle usuarioDetalle;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Biblioteca> biblioteca;

    // Constructores
    
    public Usuario(Long id, String nombre, String email, String imagenPerfil, UsuarioDetalle usuarioDetalle, List<Biblioteca> biblioteca) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.imagenPerfil = imagenPerfil;
        this.usuarioDetalle = usuarioDetalle;
        this.biblioteca = biblioteca;
    }

    public Usuario() {
    }
    
    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImagenPerfil() {
        return imagenPerfil;
    }

    public void setImagenPerfil(String imagenPerfil) {
        this.imagenPerfil = imagenPerfil;
    }

    public UsuarioDetalle getUsuarioDetalle() {
        return usuarioDetalle;
    }

    public void setUsuarioDetalle(UsuarioDetalle usuarioDetalle) {
        this.usuarioDetalle = usuarioDetalle;
    }

    public List<Biblioteca> getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(List<Biblioteca> biblioteca) {
        this.biblioteca = biblioteca;
    }
    
    
}
