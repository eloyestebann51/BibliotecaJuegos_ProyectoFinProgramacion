package modelos;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "email")
    private String email;

    @Column(name = "imagen_perfil")
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

    // Constructor para insertar
    public Usuario(String nombre, String email, String imagenPerfil) {
        this.nombre = nombre;
        this.email = email;
        this.imagenPerfil = imagenPerfil;
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
