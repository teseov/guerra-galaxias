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
 * Clase para alojar a los métodos de grabación de los datos a disco y 
 * recuperación de los datos desde el mimo hacia la aplicación.
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
        boolean almacenado = false ; // Con esta variable devolverá true si todo
          //ha ido bien, y false en caso contrario.

        try {
            FileOutputStream fichero = new FileOutputStream(new File(SalvarRecuperar.RUTA));
            ObjectOutputStream ficheroSalida;
            ficheroSalida = new ObjectOutputStream(fichero);
            // Guardar la lista de elementos
            ficheroSalida.writeObject(listaElementos) ;
            // Guardar el código del último elemento
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
            JOptionPane.showMessageDialog(null, "Falló la grabación de datos: " 
                    + ioe.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return almacenado ;
    }
    
    /**
     * Lee la información que contiene el archivo utilizando la clase
     * FileInputStream. Con el método readObject se carga la información en la
     * lista.
     * 
     * @return  El arraylist relleno con los sellos o vacío si no hay datos en 
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
            // Y terminamos leyendo el último código de elemento, que asignamos.
            Articulo.setCodigoUltimoArticulo(ficheroEntrada.readInt());
            
            // Cerrar fichero                        
            ficheroEntrada.close();
            
        } catch (ClassNotFoundException cnfe) {
            JOptionPane.showMessageDialog(null, "No se pudo acceder a la clase "
                    + "adecuada para revertir la Serialización al leer "
                    + "del fichero."  + cnfe.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            
        } catch (FileNotFoundException fnfe) {
            JOptionPane.showMessageDialog(null, "Error: El fichero no existe." +
                    fnfe.getMessage(), "Error", JOptionPane.ERROR_MESSAGE); 
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Error de Entrada/Salida: "
                    + "falló la lectura del fichero. La aplicación sigue "
                    + "funcionando sin haber cargado los datos del archivo,"
                    + " para permitir crearlo de nuevo." + ioe.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE); 
        }
        return lista ;
    }
    
    /**
     * Método auxiliar que localiza la posición en la lista del código
     * indicado.
     *
     * @param lista ArrayList de elementos, es el array de los artículos
     * que hay.
     * @param codigo El código del elemento a buscar en el array.
     *
     * @return posición del Articulo con código indicado en la lista.Si no está,
 devuelve -1.
     */
    public static int getPosicionEnLista(ArrayList<Articulo> lista, int codigo){ 
        int posicion = -1; //el valor por defecto es el que se devolverá si no 
            // se encuentra el elemento

        if (lista != null) { //si la lista existe y no está vacía
            int contador = 0;
            //Si  la posición es -1 (que quiere decir que no se ha encontrado)
            // ni se ha llegado al final del array.
            while (contador < lista.size() && posicion == -1) { 
                
                if (codigo == lista.get(contador).getCodigo()) {
                    posicion = contador; //encontrado en la posición indicada por contador
                }
                contador++;
            }
        }
        return posicion;
    } 
}