package starwars;

import java.util.Comparator;


/**
 * Establece un orden descendente, en función del precio del artículo.
 * 
 */
public class ComparadorPrecio implements Comparator<Articulo>{
    
    /**
     *   
     * @param articulo1 Precio1
     * @param articulo2 Precio2
     * @return Un valor negativo si el precio de articulo1 es menor que el precio de 
     * articulo2
     * 0 si el precio es el  mismo.
     * Un valor positivo si el precio de articulo1 es mayor que el de articulo2.
     */
    @Override
    public int compare(Articulo articulo1, Articulo articulo2) {
        
        int resultado;
        if (articulo1.getPrecio() > articulo2.getPrecio()){
            resultado = -1;
        } else {
            if (articulo1.getPrecio() < articulo2.getPrecio()){
                resultado = 1 ;
                
            } else {
                resultado = 0 ; 
            }
        }
        return resultado;
    } 
}