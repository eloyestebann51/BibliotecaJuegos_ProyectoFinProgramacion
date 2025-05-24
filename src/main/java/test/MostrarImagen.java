
package test;

import javax.swing.*;
import java.awt.*;

public class MostrarImagen extends JFrame {

    public MostrarImagen() {
        setTitle("Mostrar Imagen");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear un JLabel con la imagen
        ImageIcon imagen = new ImageIcon("imagenes/usuarios/sofia.jpg");
        JLabel etiquetaImagen = new JLabel(imagen);

        // Agregar la etiqueta al JFrame
        add(etiquetaImagen);

        setVisible(true);
    }

    public static void main(String[] args) {
        // Ejecutar en el hilo de eventos de Swing
        SwingUtilities.invokeLater(() -> new MostrarImagen());
    }
}
