/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

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
