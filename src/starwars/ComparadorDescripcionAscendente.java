package starwars;

import java.util.Comparator;

/**
 * Establece un orden ascendente, en funci�n del Nombre del art�culo. Devuelve:
 * Un valor negativo si el nombre del art�culo1 va lexicogr�ficamente delante del
 * nombre del art�culo2. 
 * 0 si el nombre de ambas personas es el mismo.
 * Un valor positivo si el nombre del art�culo1 va lexicogr�ficamente detr�s del
 * nombre de art�culo2. 
 * 
 * 
 */
public class ComparadorDescripcionAscendente implements Comparator<Articulo>{

    @Override
    public int compare(Articulo articulo1, Articulo articulo2) {
        return articulo1.getDescripcion().compareToIgnoreCase(articulo2.getDescripcion());
    } 
}
