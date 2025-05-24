package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;
import modelos.Usuario;

public abstract class GenericDAO<T> {

    protected EntityManager em;
    private Class<T> entityClass; // Generico para trabajar con cualquier modelo

    // Constructor
    public GenericDAO(EntityManager em, Class<T> entityClass) {
        this.em = em;
        this.entityClass = entityClass;
    }

    // Inserta una entidad
    public void insertar(T entidad) {
        EntityTransaction tx = em.getTransaction();

        try {
            if (entidad instanceof Usuario) {
                Usuario nuevoUsuario = (Usuario) entidad;

                Long count = em.createQuery(
                        "SELECT COUNT(u) FROM Usuario u WHERE u.email = :email", Long.class)
                        .setParameter("email", nuevoUsuario.getEmail())
                        .getSingleResult();

                if (count > 0) {
                    throw new IllegalArgumentException("El usuario con ese email ya existe.");
                }
            }

            tx.begin();
            em.persist(entidad);
            tx.commit();

        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw e; // vuelve a lanzar para manejar arriba
        }
    }

    // Devuelve una entidad por su id
    public T buscarPorId(Long id) {
        return em.find(entityClass, id);
    }

    // Nos devuelve todas entidades
    public List<T> listarTodos() {
        return em.createQuery("SELECT e FROM " + entityClass.getSimpleName() + " e", entityClass).getResultList();
    }

    // Elimina una entidad
    public void eliminar(Long id) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            T entidad = em.find(entityClass, id);
            if (entidad != null) {
                em.remove(entidad);
            }
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
    }
}
