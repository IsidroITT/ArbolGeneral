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
    
    public boolean enlazaHijo(NodoGeneral hijo){
        NodoHijo enlaceHijo = new NodoHijo(hijo);
        if(enlaceHijo == null) return false;
        if(ini == null & fin == null) {
            ini = fin = enlaceHijo;
            return true;
        }
        enlaceHijo.ant = fin;
        fin.sig = enlaceHijo;
        fin = enlaceHijo;
        return true;
    }
}
