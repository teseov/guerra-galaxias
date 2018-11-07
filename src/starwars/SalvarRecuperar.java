package starwars;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Clase para alojar a los m�todos de grabaci�n de los datos a disco y 
 * recuperaci�n de los datos desde el mimo hacia la aplicaci�n.
 * 
 * 
 */
public class SalvarRecuperar {
    
    private final static String RUTA = "starwars.dat" ;
    
      
    /**
     * Almacena el arraylist de elementos en el disco.
     * @param listaElementos Arraylist de elementos
     * @return true si se guarda el fichero sin error
     */
    public static boolean guardarArrayEnFichero(ArrayList<Articulo> listaElementos) {
        boolean almacenado = false ; // Con esta variable devolver� true si todo
          //ha ido bien, y false en caso contrario.

        try {
            FileOutputStream fichero = new FileOutputStream(new File(SalvarRecuperar.RUTA));
            ObjectOutputStream ficheroSalida;
            ficheroSalida = new ObjectOutputStream(fichero);
            // Guardar la lista de elementos
            ficheroSalida.writeObject(listaElementos) ;
            // Guardar el c�digo del �ltimo elemento
            ficheroSalida.writeInt(Articulo.getCodigoUltimoElemento()) ;
           
            // Cerrar fichero
            ficheroSalida.close();

            // Indicamos que lo que haya cambiado se ha guardado
            almacenado = true;
            
        } catch (FileNotFoundException fnfe) {
            JOptionPane.showMessageDialog(null, "Error: El fichero no existe." +
                    fnfe.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);     
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Fall� la grabaci�n de datos: " 
                    + ioe.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return almacenado ;
    }
    
    /**
     * Lee la informaci�n que contiene el archivo utilizando la clase
     * FileInputStream. Con el m�todo readObject se carga la informaci�n en la
     * lista.
     * 
     * @return  El arraylist relleno con los sellos o vac�o si no hay datos en 
     * el fichero.
     */
    public static ArrayList <Articulo> cargarLista() {

        ArrayList<Articulo> lista = new ArrayList();

        try {
            FileInputStream fichero =
                    new FileInputStream(new File(SalvarRecuperar.RUTA));
            ObjectInputStream ficheroEntrada = new ObjectInputStream(fichero);
            // Leemos los datos en el mismo orden que los escribimos. 
            // Comenzamos por el array de elementos.
            lista = (ArrayList<Articulo>) ficheroEntrada.readObject();
            // Y terminamos leyendo el �ltimo c�digo de elemento, que asignamos.
            Articulo.setCodigoUltimoArticulo(ficheroEntrada.readInt());
            
            // Cerrar fichero                        
            ficheroEntrada.close();
            
        } catch (ClassNotFoundException cnfe) {
            JOptionPane.showMessageDialog(null, "No se pudo acceder a la clase "
                    + "adecuada para revertir la Serializaci�n al leer "
                    + "del fichero."  + cnfe.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            
        } catch (FileNotFoundException fnfe) {
            JOptionPane.showMessageDialog(null, "Error: El fichero no existe." +
                    fnfe.getMessage(), "Error", JOptionPane.ERROR_MESSAGE); 
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Error de Entrada/Salida: "
                    + "fall� la lectura del fichero. La aplicaci�n sigue "
                    + "funcionando sin haber cargado los datos del archivo,"
                    + " para permitir crearlo de nuevo." + ioe.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE); 
        }
        return lista ;
    }
    
    /**
     * M�todo auxiliar que localiza la posici�n en la lista del c�digo
     * indicado.
     *
     * @param lista ArrayList de elementos, es el array de los art�culos
     * que hay.
     * @param codigo El c�digo del elemento a buscar en el array.
     *
     * @return posici�n del Articulo con c�digo indicado en la lista.Si no est�,
 devuelve -1.
     */
    public static int getPosicionEnLista(ArrayList<Articulo> lista, int codigo){ 
        int posicion = -1; //el valor por defecto es el que se devolver� si no 
            // se encuentra el elemento

        if (lista != null) { //si la lista existe y no est� vac�a
            int contador = 0;
            //Si  la posici�n es -1 (que quiere decir que no se ha encontrado)
            // ni se ha llegado al final del array.
            while (contador < lista.size() && posicion == -1) { 
                
                if (codigo == lista.get(contador).getCodigo()) {
                    posicion = contador; //encontrado en la posici�n indicada por contador
                }
                contador++;
            }
        }
        return posicion;
    } 
}