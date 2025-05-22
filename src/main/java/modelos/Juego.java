package modelos;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "juegos")
public class Juego {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    @Enumerated(EnumType.STRING)
    private Plataforma plataforma; // Enum: PS, XBOX, NINTENDO

    private String imagen;

    @OneToMany(mappedBy = "juego", cascade = CascadeType.ALL)
    private List<Biblioteca> bibliotecas;

    // Constructores 
    public Juego(Long id, String titulo, Plataforma plataforma, String imagen, List<Biblioteca> bibliotecas) {
        this.id = id;
        this.titulo = titulo;
        this.plataforma = plataforma;
        this.imagen = imagen;
        this.bibliotecas = bibliotecas;
    }

    public Juego() {
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Plataforma getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(Plataforma plataforma) {
        this.plataforma = plataforma;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public List<Biblioteca> getBibliotecas() {
        return bibliotecas;
    }

    public void setBibliotecas(List<Biblioteca> bibliotecas) {
        this.bibliotecas = bibliotecas;
    }

}
