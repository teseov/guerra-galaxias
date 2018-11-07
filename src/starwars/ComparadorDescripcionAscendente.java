package starwars;

import java.util.Comparator;

/**
 * Establece un orden ascendente, en función del Nombre del artículo. Devuelve:
 * Un valor negativo si el nombre del artículo1 va lexicográficamente delante del
 * nombre del artículo2. 
 * 0 si el nombre de ambas personas es el mismo.
 * Un valor positivo si el nombre del artículo1 va lexicográficamente detrás del
 * nombre de artículo2. 
 * 
 * 
 */
public class ComparadorDescripcionAscendente implements Comparator<Articulo>{

    @Override
    public int compare(Articulo articulo1, Articulo articulo2) {
        return articulo1.getDescripcion().compareToIgnoreCase(articulo2.getDescripcion());
    } 
}
