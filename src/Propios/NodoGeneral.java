
package Propios;

/**
 *
 * @author isidro
 */
public class NodoGeneral {
    public NodoArbol dato;
    public NodoGeneral sig;
    public NodoGeneral ant;
    
    public NodoGeneral(NodoArbol valor){
        dato = valor;
        sig = null;
        ant = null;
    } 
}
