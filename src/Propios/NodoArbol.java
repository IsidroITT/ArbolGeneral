package Propios;

/**
 *
 * @author isidro
 */
public class NodoArbol {
    public char dato;
    public ListaGeneral enlace;
    
    public NodoArbol(char valor){
        this.dato = valor;
        enlace = new ListaGeneral();
    }
            
       
}
