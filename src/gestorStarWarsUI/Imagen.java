package gestorStarWarsUI;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 * Clase para insertar una imagen dentro de un JPanel. 
 * @author   Carlos Villatoro
 * 
 */
public class Imagen extends javax.swing.JPanel {
    
    private static String nombreImagen ;
    
    /**
     * Construcotor al que se pasa la ruta de la imagen.
     * @param absolutePath Ruta de la imagen.
     */
    public Imagen(String absolutePath) {
        this.setSize(300, 400);
        Imagen.nombreImagen = absolutePath ;
    }
 
    /**
     * Se crea un método cuyo parámetro debe ser un objeto Graphics
     * @param grafico objeto Graphics
     */
    @Override
    public void paint(Graphics grafico) {
        Dimension height = getSize();
 
        //Se selecciona la imagen que tenemos en el paquete de la //ruta del programa
        ImageIcon Img = new ImageIcon(getClass().getResource(Imagen.nombreImagen)); 
 
        //se dibuja la imagen que tenemos en el paquete Images //dentro de un panel
 
        grafico.drawImage(Img.getImage(), 0, 0, height.width, height.height, null);
 
        setOpaque(false);
        super.paintComponent(grafico);
    }
}