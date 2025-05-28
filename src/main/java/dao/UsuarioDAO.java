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
            throw new IllegalArgumentException("Error al actualizar el usuario: " + e.getMessage(), e);
        }
    }

    public void eliminarPorNombre(String nombreUsuario) {
        EntityTransaction tx = null;
        try {
            tx = em.getTransaction();
            tx.begin();

            Usuario usuario = em.createQuery(
                    "SELECT u FROM Usuario u WHERE u.nombre = :nombre", Usuario.class)
                    .setParameter("nombre", nombreUsuario)
                    .getSingleResult();

            if (usuario != null) {
                em.remove(usuario);
            }

            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new IllegalArgumentException("Error al eliminar el usuario por nombre: " + e.getMessage(), e);
        }
    }

    @Override
    public void insertar(Usuario usuario) {
        Long count = em.createQuery(
                "SELECT COUNT(u) FROM Usuario u WHERE u.email = :email", Long.class)
                .setParameter("email", usuario.getEmail())
                .getSingleResult();

        if (count > 0) {
            throw new IllegalArgumentException("El usuario con ese email ya existe.");
        }

        super.insertar(usuario); // usa la lógica estándar
    }
}

