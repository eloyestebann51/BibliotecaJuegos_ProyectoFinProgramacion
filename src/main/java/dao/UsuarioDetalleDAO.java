
package dao;

import javax.persistence.EntityManager;
import modelos.UsuarioDetalle;

/**
 *
 * @author Eloym
 */
public class UsuarioDetalleDAO extends GenericDAO<UsuarioDetalle>{
    
    public UsuarioDetalleDAO(EntityManager em) {
        super(em, UsuarioDetalle.class);
    }
    
    
    
}
