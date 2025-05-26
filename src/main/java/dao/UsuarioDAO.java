package dao;

import modelos.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class UsuarioDAO extends GenericDAO<Usuario> {

    public UsuarioDAO(EntityManager em) {
        super(em, Usuario.class);
    }

    public void actualizar(Usuario usuario) {
        EntityTransaction transaction = null;
        try {
            transaction = em.getTransaction();
            transaction.begin();

            em.merge(usuario); // Actualiza usuario y detalles por cascade

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new IllegalArgumentException("Error al actualizar el usuario: " + e.getMessage());
        }
    }

}
