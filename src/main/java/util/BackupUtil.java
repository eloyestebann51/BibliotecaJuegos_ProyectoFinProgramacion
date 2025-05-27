package util;

import dao.BibliotecaDAO;
import dao.JuegoDAO;
import dao.UsuarioDAO;
import modelos.Biblioteca;
import modelos.Juego;
import modelos.Usuario;
import java.io.*;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.persistence.EntityManager;


public class BackupUtil {

    private static final String BACKUP_DIR = "backups";

    public static void crearBackup() {
        try {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            Path dir = Paths.get(BACKUP_DIR, timestamp);
            Files.createDirectories(dir);

            EntityManager em = JPAUtil.getEntityManager();
            UsuarioDAO usuarioDAO = new UsuarioDAO(em);
            JuegoDAO juegoDAO = new JuegoDAO(em);
            BibliotecaDAO bibliotecaDAO = new BibliotecaDAO(em);

            escribirUsuariosCSV(dir.resolve("usuarios.csv"), usuarioDAO.listarTodos());
            escribirJuegosCSV(dir.resolve("juegos.csv"), juegoDAO.listarTodos());
            escribirBibliotecaCSV(dir.resolve("biblioteca.csv"), bibliotecaDAO.listarTodos());

            System.out.println("Backup creado en: " + dir.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    

    private static void escribirUsuariosCSV(Path path, List<Usuario> usuarios) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (Usuario u : usuarios) {
                writer.write(u.getId() + "," + u.getNombre() + "," + u.getEmail() + "," + u.getImagenPerfil());
                writer.newLine();
            }
        }
    }

    private static void escribirJuegosCSV(Path path, List<Juego> juegos) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (Juego j : juegos) {
                writer.write(j.getId() + "," + j.getTitulo() + "," + j.getGenero() + "," + j.getPlataforma() + "," + j.getImagen());
                writer.newLine();
            }
        }
    }

    private static void escribirBibliotecaCSV(Path path, List<Biblioteca> biblioteca) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (Biblioteca b : biblioteca) {
                writer.write(b.getId() + "," + b.getUsuario().getId() + "," + b.getJuego().getId() + "," + b.getFechaAdquisicion());
                writer.newLine();
            }
        }
    }
}
