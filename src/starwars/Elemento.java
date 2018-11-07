package starwars;

import java.io.Serializable;

/**
 * Clase Elemento, que implementa Serializable, para representar un objeto con
 * sus atributos más comunes.
 * 
 * 
 */
public class Elemento implements Serializable {
    private int codigo ;
    private String descripcion ;
    private int annio ;
    private String pais ;
    private float precio ;
    private boolean desmontable ;
    private int alto ;
    private int ancho ;
    private String nombreImagen ;

    
            
    private static final long serialVersionUID = 42L ;
    
    /**
     * Atributo estático necesario para saber cuál es el próximo código de artículo
     * a asignar. Mantendrá siempre el valor del número de artículos que se han 
     * dado de alta en la empresa, o lo que es lo mismo, el valor del último 
     * código asignado, de forma que al siguiente artículo que se cree se le 
     * asignará el valor de esta variable, más uno. Así, por ejemplo, si el 
     * valor de este atributo de clase es 5, significa que ya se han dado de
     * alta 5 artículos, y el código que habrá que asignar al próximo artículo 
     * que se dé de alta, deberá ser 6 (5+1). Se inicializa a 0 porque al 
     * comenzar, no hay ningún artículo dado de alta.  */
    private static int codigoUltimoArticulo = 0 ;
    
    /**
     * Método estático que devuelve el código del último artículo dado de alta
     * Público para poderlo consultar desde el formulario de edición
     * @return código del último artículo dado de alta.
     */
    public static int getCodigoUltimoElemento() {
        return Elemento.codigoUltimoArticulo ;
    }
    
    /**
     * Método estático que establece el código de último artículo dado de alta.
     * @param codigoUltimoArticulo Código de último artículo dado de alta.
     * @throws IllegalArgumentException Si el código es menor que cero se lanza una excepción.
     */
    protected static void setCodigoUltimoElemento(int codigoUltimoArticulo) throws IllegalArgumentException {
        if (codigoUltimoArticulo >= 0) {
            Elemento.codigoUltimoArticulo = codigoUltimoArticulo ;
        } else {
            throw new IllegalArgumentException("Error: El código de artículo debe"
                    + " ser un número positivo.");
        }
    }
    
    /**
     * Establece el código de un artículo asignándole un número que se obtiene
     * automáticamente a partir del último código asignado, por lo que no
     * requiere parámetros.
     */
    private void setCodigoArticulo() {
        /*
        Hay que asignar como código del artículo el último código asignado más 1 y
        al mismo tiempo actualizar el valor del último código asignado.
        Por eso usamos el operador de autoincremento en notación prefija:
        primero le sumamos uno a la variable, y luego le asignamos el valor 
        como código del nuevo señño.
        El método lo hacemos private para que no pueda alterarse el código 
        asignado a un artículo en el momento de darlo de alta. Por tanto, sólo
        desde esta clase se puede invocar, y se invoca concretamente desde su
        constructor, de manera que la única manera de asignar un código a un 
        artículo es darle el que le corresponde en el momento del alta.   */
        this.codigo = ++Elemento.codigoUltimoArticulo ;
    }
    
    
    /**
     * Constructor de la clase Articulo.
     * @param descripcion   Observacioens sobre el artículo.
     * @param annio         Año de emisión del artículo.
     * @param pais          País de emisión del artículo
     * @param precio        Precio del artículo.
     * @param desmontable   Si es un artículo desmontable.
     * @param alto          Alto del artículo en milímetros.
     * @param ancho         Ancho del artículo en milímetros.
     * @param nombreImagen  Nombre del fichero que contiene la imagen del mismo.
     */
    public Elemento(String descripcion, int annio, String pais, 
            float precio, boolean desmontable, int alto, 
            int ancho, String nombreImagen) {
        
        // Sin argumentos, ya que asignamos el que toca, y no queremos que se 
        // pueda asignar otro valor diferente.
        this.setCodigoArticulo(); 
        this.descripcion = descripcion ;
        this.annio = annio ;
        this.pais = pais ;
        this.precio = precio ;
        this.desmontable = desmontable ;
        this.alto = alto ;
        this.ancho = ancho ;
        this.nombreImagen = nombreImagen ;
    }

    /**
     * Devuelve el código del artículo
     * @return código del artículo
     */
    public int getCodigo() {
        return codigo ;
    }
    
    /**
     * Establecer el código del artículo 
     * @param codigo Establecer el código del artículo
     */
    protected void setCodigo(int codigo) {
        this.codigo = codigo ;
    }
    
    /**
     * Devuelve la descripción del artículo
     * @return Descripción del artículo
     */
    public String getDescripcion() {
        return descripcion ;
    }
    
    /**
     * Establecer la descripción del artículo 
     * @param descripcion Establecer la descripción del artículo 
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion ;
    }

    /**
     * Devuelve el año del artículo
     * @return Año de emisión del artículo
     */
    public int getAnnio() {
        return annio;
    }

    /**
     * Establecer el año de fabricación del artículo 
     * @param annio Año de fabricación
     */
    public void setAnnio(int annio) {
        this.annio = annio;
    }

    /**
     * Devuelve el país del artículo
     * @return País de origen del artículo
     */
    public String getPais() {
        return pais;
    }

    /**
     * Establecer el país de origen del artículo 
     * @param pais País de origen del artículo
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * Devuelve precio del artículo
     * @return Precio del artículo.
     */
    public float getPrecio() {
        return precio;
    }

    /**
     * Establecer el valor facial del artículo 
     * @param precio valor facial del artículo 
     */
    public void setPrecio(float precio) {
        this.precio = precio;
    }

    /**
     * Devuelve si es desmontable el artículo
     * @return Si es desmontable el artículo
     */
    public boolean isDesmontable() {
        return this.desmontable ;
    }

    /**
     * Establece si es desmontable o no un artículo
     * @param desmontable true si lo es, falso en caso contrario
     */
    public void setDesmontable(boolean desmontable) {
        this.desmontable = desmontable ;
    }

    
    /**
     * Devuelve el alto de un artículo
     * @return Alto del artículo
     */
    public float getAlto() {
        return alto;
    }

    /**
     * Establece el alto de un artículo
     * @param alto Alto del artículo
     */
    public void setAlto(int alto) {
        this.alto = alto;
    }

    /**
     * Devuelve el ancho de un artículo
     * @return Ancho del artículo
     */
    public float getAncho() {
        return ancho;
    }

    /**
     * Establece el ancho de un artículo
     * @param ancho Ancho del artículo
     */
    public void setAncho(int ancho) {
        this.ancho = ancho ;
    }

    /**
     * Devuelve el nombre de la imagen del artículo
     * @return El nombre de la imagen del artículo
     */
    public String getNombreImagen() {
        return nombreImagen;
    }

    /**
     * Establecer el nombre de la imagen del artículo
     * @param nombreImagen Nombre de la imagen del artículo
     */
    public void setNombreImagen(String nombreImagen) {
        this.nombreImagen = nombreImagen;
    }

    
    /**
     * String con el contenido del artículo.
     * 
     */
    @Override
    public String toString() {
        String cadDes ;
        if (this.isDesmontable()) {
            cadDes = "es desmontable" ;
        } else {
            cadDes = "no es desmontable" ;
        }
        
        String cadena = "Código del artículo: " + this.getCodigo() + ".\n"
                + this.getDescripcion() + "\nPrecio: " + this.precio 
                + "\nFabricado en: " + this.getPais() + "\nAlto: " + this.getAlto() +
                " Ancho: " + this.getAncho() + "\n\tAño: " + this.getAnnio() +
                "\n El artículo " + cadDes ;
        return cadena;
    }    
        
}