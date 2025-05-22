package dao;

import modelos.Usuario;

import javax.persistence.EntityManager;

public class UsuarioDAO extends GenericDAO<Usuario> {
    public UsuarioDAO(EntityManager em) {
        super(em, Usuario.class);
    }

    // Aquí puedes añadir métodos personalizados si los necesitas
}
