package Clase;

public class NodoGeneral {

    char dato;
    NodoHijo ini, fin;

    public NodoGeneral(char valor) {
        dato = valor;
        ini = fin = null;
    }

    public NodoGeneral encontrarHijo(char valorABuscar) {
        for (NodoHijo tmp = ini; tmp != null; tmp = tmp.sig) {
            if (tmp.enlaceHijo.dato == valorABuscar) {
                return tmp.enlaceHijo; //Nodo encontrado
            }
        }
        return null;
    }
}
