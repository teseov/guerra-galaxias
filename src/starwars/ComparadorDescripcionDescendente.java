package starwars;

import java.util.Comparator;

/**
 * Establece un orden decendente, en funci�n de la descripci�n del art�culo.
 * Devuelve: un valor positivo si la descripci�n de art�culo1 va 
 * lexicogr�ficamente delante del nombre de art�culo2, 0 si la descripci�n de 
 * ambos art�culos es la misma, y un valor negativo si si la descripci�n de 
 * art�culo1 va lexicogr�ficamente detr�s del nombre de art�culo2.
 * 
 * 
 */
public class ComparadorDescripcionDescendente implements Comparator<Articulo> {

    @Override
    public int compare(Articulo art�culo1, Articulo art�culo2) {
        int resultado = art�culo1.getDescripcion().compareToIgnoreCase(art�culo2.getDescripcion());
        resultado*=(-1); 
        // queremos el orden inverso al lexicogr�fico que
        // establece compareToIgnoreCase(), as� que cambiamos el signo del 
        // resultado multiplicando por menos uno. 
        return resultado;
    } 
    
}