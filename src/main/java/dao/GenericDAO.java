package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

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

        // Empezamos una transaccion y insertamos una nueva entidad
        try {
            tx.begin();
            em.persist(entidad);
            tx.commit();
        } catch (Exception e) { // Restauramos lo realizado en caso de error
            if(tx.isActive()) {
                tx.rollback();
            }
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
