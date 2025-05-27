package modelos;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "juegos") 
public class Juego {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_juego")
    private Long id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "genero")
    private String genero; // Asumimos que es String

    @Enumerated(EnumType.STRING)
    @Column(name = "plataforma")
    private Plataforma plataforma;

    @Column(name = "imagen_juego")
    private String imagen;

    @OneToMany(mappedBy = "juego", cascade = CascadeType.ALL)
    private List<Biblioteca> bibliotecas;

    // Constructores
    public Juego() {
    }

    public Juego(Long id, String titulo, String genero, Plataforma plataforma, String imagen, List<Biblioteca> bibliotecas) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.plataforma = plataforma;
        this.imagen = imagen;
        this.bibliotecas = bibliotecas;
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
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
