package starwars;

import java.util.Comparator;

/**
 * Establece un orden decendente, en función de la descripción del artículo.
 * Devuelve: un valor positivo si la descripción de artículo1 va 
 * lexicográficamente delante del nombre de artículo2, 0 si la descripción de 
 * ambos artículos es la misma, y un valor negativo si si la descripción de 
 * artículo1 va lexicográficamente detrás del nombre de artículo2.
 * 
 * 
 */
public class ComparadorDescripcionDescendente implements Comparator<Articulo> {

    @Override
    public int compare(Articulo artículo1, Articulo artículo2) {
        int resultado = artículo1.getDescripcion().compareToIgnoreCase(artículo2.getDescripcion());
        resultado*=(-1); 
        // queremos el orden inverso al lexicográfico que
        // establece compareToIgnoreCase(), así que cambiamos el signo del 
        // resultado multiplicando por menos uno. 
        return resultado;
    } 
    
}