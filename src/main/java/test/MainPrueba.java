package test;

import dao.UsuarioDAO;
import modelos.Usuario;
import util.JPAUtil;

import javax.persistence.EntityManager;

public class MainPrueba {
    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManager();
        UsuarioDAO usuarioDAO = new UsuarioDAO(em);

        // Crear un nuevo usuario
        Usuario nuevo = new Usuario();
        nuevo.setNombre("eloy2");
        nuevo.setEmail("eloy@correo.com");
        nuevo.setImagenPerfil("imagenes/usuarios/sofia.jpg");

        // Insertar
        usuarioDAO.insertar(nuevo);

        // Consultar todos
        System.out.println("Usuarios en la base de datos:");
        for (Usuario u : usuarioDAO.listarTodos()) {
            System.out.println(u.getId() + " - " + u.getNombre() + " - " + u.getEmail());
        }

        em.close();
    }
}
