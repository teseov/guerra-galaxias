package starwars;

import java.io.Serializable;

/**
 * Clase Elemento, que implementa Serializable, para representar un objeto con
 * sus atributos m�s comunes.
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
     * Atributo est�tico necesario para saber cu�l es el pr�ximo c�digo de art�culo
     * a asignar. Mantendr� siempre el valor del n�mero de art�culos que se han 
     * dado de alta en la empresa, o lo que es lo mismo, el valor del �ltimo 
     * c�digo asignado, de forma que al siguiente art�culo que se cree se le 
     * asignar� el valor de esta variable, m�s uno. As�, por ejemplo, si el 
     * valor de este atributo de clase es 5, significa que ya se han dado de
     * alta 5 art�culos, y el c�digo que habr� que asignar al pr�ximo art�culo 
     * que se d� de alta, deber� ser 6 (5+1). Se inicializa a 0 porque al 
     * comenzar, no hay ning�n art�culo dado de alta.  */
    private static int codigoUltimoArticulo = 0 ;
    
    /**
     * M�todo est�tico que devuelve el c�digo del �ltimo art�culo dado de alta
     * P�blico para poderlo consultar desde el formulario de edici�n
     * @return c�digo del �ltimo art�culo dado de alta.
     */
    public static int getCodigoUltimoElemento() {
        return Elemento.codigoUltimoArticulo ;
    }
    
    /**
     * M�todo est�tico que establece el c�digo de �ltimo art�culo dado de alta.
     * @param codigoUltimoArticulo C�digo de �ltimo art�culo dado de alta.
     * @throws IllegalArgumentException Si el c�digo es menor que cero se lanza una excepci�n.
     */
    protected static void setCodigoUltimoElemento(int codigoUltimoArticulo) throws IllegalArgumentException {
        if (codigoUltimoArticulo >= 0) {
            Elemento.codigoUltimoArticulo = codigoUltimoArticulo ;
        } else {
            throw new IllegalArgumentException("Error: El c�digo de art�culo debe"
                    + " ser un n�mero positivo.");
        }
    }
    
    /**
     * Establece el c�digo de un art�culo asign�ndole un n�mero que se obtiene
     * autom�ticamente a partir del �ltimo c�digo asignado, por lo que no
     * requiere par�metros.
     */
    private void setCodigoArticulo() {
        /*
        Hay que asignar como c�digo del art�culo el �ltimo c�digo asignado m�s 1 y
        al mismo tiempo actualizar el valor del �ltimo c�digo asignado.
        Por eso usamos el operador de autoincremento en notaci�n prefija:
        primero le sumamos uno a la variable, y luego le asignamos el valor 
        como c�digo del nuevo se��o.
        El m�todo lo hacemos private para que no pueda alterarse el c�digo 
        asignado a un art�culo en el momento de darlo de alta. Por tanto, s�lo
        desde esta clase se puede invocar, y se invoca concretamente desde su
        constructor, de manera que la �nica manera de asignar un c�digo a un 
        art�culo es darle el que le corresponde en el momento del alta.   */
        this.codigo = ++Elemento.codigoUltimoArticulo ;
    }
    
    
    /**
     * Constructor de la clase Articulo.
     * @param descripcion   Observacioens sobre el art�culo.
     * @param annio         A�o de emisi�n del art�culo.
     * @param pais          Pa�s de emisi�n del art�culo
     * @param precio        Precio del art�culo.
     * @param desmontable   Si es un art�culo desmontable.
     * @param alto          Alto del art�culo en mil�metros.
     * @param ancho         Ancho del art�culo en mil�metros.
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
     * Devuelve el c�digo del art�culo
     * @return c�digo del art�culo
     */
    public int getCodigo() {
        return codigo ;
    }
    
    /**
     * Establecer el c�digo del art�culo 
     * @param codigo Establecer el c�digo del art�culo
     */
    protected void setCodigo(int codigo) {
        this.codigo = codigo ;
    }
    
    /**
     * Devuelve la descripci�n del art�culo
     * @return Descripci�n del art�culo
     */
    public String getDescripcion() {
        return descripcion ;
    }
    
    /**
     * Establecer la descripci�n del art�culo 
     * @param descripcion Establecer la descripci�n del art�culo 
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion ;
    }

    /**
     * Devuelve el a�o del art�culo
     * @return A�o de emisi�n del art�culo
     */
    public int getAnnio() {
        return annio;
    }

    /**
     * Establecer el a�o de fabricaci�n del art�culo 
     * @param annio A�o de fabricaci�n
     */
    public void setAnnio(int annio) {
        this.annio = annio;
    }

    /**
     * Devuelve el pa�s del art�culo
     * @return Pa�s de origen del art�culo
     */
    public String getPais() {
        return pais;
    }

    /**
     * Establecer el pa�s de origen del art�culo 
     * @param pais Pa�s de origen del art�culo
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * Devuelve precio del art�culo
     * @return Precio del art�culo.
     */
    public float getPrecio() {
        return precio;
    }

    /**
     * Establecer el valor facial del art�culo 
     * @param precio valor facial del art�culo 
     */
    public void setPrecio(float precio) {
        this.precio = precio;
    }

    /**
     * Devuelve si es desmontable el art�culo
     * @return Si es desmontable el art�culo
     */
    public boolean isDesmontable() {
        return this.desmontable ;
    }

    /**
     * Establece si es desmontable o no un art�culo
     * @param desmontable true si lo es, falso en caso contrario
     */
    public void setDesmontable(boolean desmontable) {
        this.desmontable = desmontable ;
    }

    
    /**
     * Devuelve el alto de un art�culo
     * @return Alto del art�culo
     */
    public float getAlto() {
        return alto;
    }

    /**
     * Establece el alto de un art�culo
     * @param alto Alto del art�culo
     */
    public void setAlto(int alto) {
        this.alto = alto;
    }

    /**
     * Devuelve el ancho de un art�culo
     * @return Ancho del art�culo
     */
    public float getAncho() {
        return ancho;
    }

    /**
     * Establece el ancho de un art�culo
     * @param ancho Ancho del art�culo
     */
    public void setAncho(int ancho) {
        this.ancho = ancho ;
    }

    /**
     * Devuelve el nombre de la imagen del art�culo
     * @return El nombre de la imagen del art�culo
     */
    public String getNombreImagen() {
        return nombreImagen;
    }

    /**
     * Establecer el nombre de la imagen del art�culo
     * @param nombreImagen Nombre de la imagen del art�culo
     */
    public void setNombreImagen(String nombreImagen) {
        this.nombreImagen = nombreImagen;
    }

    
    /**
     * String con el contenido del art�culo.
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
        
        String cadena = "C�digo del art�culo: " + this.getCodigo() + ".\n"
                + this.getDescripcion() + "\nPrecio: " + this.precio 
                + "\nFabricado en: " + this.getPais() + "\nAlto: " + this.getAlto() +
                " Ancho: " + this.getAncho() + "\n\tA�o: " + this.getAnnio() +
                "\n El art�culo " + cadDes ;
        return cadena;
    }    
        
}