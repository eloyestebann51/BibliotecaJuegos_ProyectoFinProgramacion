package modelos;

import java.time.LocalDate;
import javax.persistence.*;

@Entity
@Table(name = "usuario_detalle")
public class UsuarioDetalle {

    @Id
    @Column(name = "id_usuario")  // Es la PK y FK hacia Usuario
    private Long idUsuario;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Column(name = "pais")
    private String pais;

    @Column(name = "plataforma_favorita")
    private String plataformaFavorita;

    @Column(name = "descripcion")
    private String descripcion;

    @OneToOne
    @MapsId // indica que usa el mismo valor PK que Usuario
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    // Constructores
    public UsuarioDetalle() {}

    public UsuarioDetalle(LocalDate fechaNacimiento, String pais, String plataformaFavorita, String descripcion, Usuario usuario) {
        this.fechaNacimiento = fechaNacimiento;
        this.pais = pais;
        this.plataformaFavorita = plataformaFavorita;
        this.descripcion = descripcion;
        this.usuario = usuario;
    }

    // Getters y Setters
    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getPlataformaFavorita() {
        return plataformaFavorita;
    }

    public void setPlataformaFavorita(String plataformaFavorita) {
        this.plataformaFavorita = plataformaFavorita;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
