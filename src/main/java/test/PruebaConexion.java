
package test;

/**
 *
 * @author eloy
 */
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PruebaConexion {

    public static void main(String[] args) {
        try {
            // Intenta crear el EntityManagerFactory con el nombre del persistence-unit
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("bibliotecaJuegosPU");
            System.out.println("Conexión a la base de datos exitosa!");

            emf.close();
        } catch (Exception e) {
            System.out.println("Error al conectar con la base de datos:");
            e.printStackTrace();
        }
    }
}
