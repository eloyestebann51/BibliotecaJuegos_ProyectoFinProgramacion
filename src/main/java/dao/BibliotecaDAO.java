package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import modelos.Biblioteca;
import modelos.Juego;
import modelos.Usuario;
import util.JPAUtil;

public class BibliotecaDAO extends GenericDAO<Biblioteca> {

    public BibliotecaDAO(EntityManager em) {
        super(em, Biblioteca.class);
    }

    public Biblioteca buscarPorUsuarioYJuego(Usuario usuario, Juego juego) {
        try {
            TypedQuery<Biblioteca> query = em.createQuery(
                    "SELECT b FROM Biblioteca b WHERE b.usuario = :usuario AND b.juego = :juego",
                    Biblioteca.class
            );
            query.setParameter("usuario", usuario);
            query.setParameter("juego", juego);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<Biblioteca> buscarPorUsuario(Usuario usuario) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("SELECT b FROM Biblioteca b WHERE b.usuario = :usuario", Biblioteca.class)
                    .setParameter("usuario", usuario)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public void guardar(Biblioteca biblioteca) {
        em.getTransaction().begin();
        em.persist(biblioteca);
        em.getTransaction().commit();
    }

    public void eliminarPorTituloYUsuario(String titulo, Usuario usuario) {
        em.getTransaction().begin();
        try {
            TypedQuery<Biblioteca> query = em.createQuery(
                    "SELECT b FROM Biblioteca b WHERE b.usuario = :usuario AND b.juego.titulo = :titulo",
                    Biblioteca.class
            );
            query.setParameter("usuario", usuario);
            query.setParameter("titulo", titulo);

            Biblioteca biblioteca = query.getSingleResult();

            if (biblioteca != null) {
                em.remove(biblioteca);
            }

            em.getTransaction().commit();
        } catch (NoResultException e) {
            em.getTransaction().rollback();
            System.out.println("No se encontró el juego con título: " + titulo + " en la biblioteca del usuario.");
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

}
