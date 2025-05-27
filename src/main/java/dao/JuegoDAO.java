package dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import modelos.Juego;

/**
 *
 * @author Eloym
 */
public class JuegoDAO extends GenericDAO<Juego> {

    public JuegoDAO(EntityManager em) {
        super(em, Juego.class);
    }

    public Juego buscarPorTitulo(String titulo) {
        try {
            return em.createQuery("SELECT j FROM Juego j WHERE j.titulo = :titulo", Juego.class)
                    .setParameter("titulo", titulo)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null; 
        }
    }

}
