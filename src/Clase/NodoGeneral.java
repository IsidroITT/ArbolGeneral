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

    public boolean enlazaHijo(NodoGeneral hijo) {
        NodoHijo enlaceHijo = new NodoHijo(hijo);
        if (enlaceHijo == null) {
            return false;
        }
        if (ini == null & fin == null) {
            ini = fin = enlaceHijo;
            return true;
        }
        enlaceHijo.ant = fin;
        fin.sig = enlaceHijo;
        fin = enlaceHijo;
        return true;
    }

    public boolean desenlazarHijo(NodoGeneral hijoEliminar) {
        //compara si el UNICO nodo que existe es el que sera elimininado
        if (ini == fin && ini.enlaceHijo == hijoEliminar) {// UNICO NODO
            ini.enlaceHijo = null; // se quita el enlace del padre al hijo
            ini = fin = null;
            return true;
        }
        if (ini.enlaceHijo == hijoEliminar) {// SI NODOELIMINAR == INI
            NodoHijo tmp = ini;
            ini = ini.sig;
            ini.ant = null;
            tmp.sig = null;
            tmp.enlaceHijo = null;
            tmp = null;
            return true;
        }
        if (fin.enlaceHijo.dato == hijoEliminar.dato) {// SI NODOELIMINAR == FIN
            NodoHijo tmp = fin;
            fin = fin.ant;
            fin.sig = null;
            tmp.ant = null;
            tmp.enlaceHijo = null;
            tmp = null;
            return true;
        }
        for (NodoHijo tmp = ini.sig; tmp != fin; tmp = tmp.sig) {// SI NODOELIMINAR SE ENCUENTRA EN MEDIO
            if (tmp.enlaceHijo == hijoEliminar) {
                tmp.ant.sig = tmp.sig;
                tmp.sig.ant = tmp.ant;
                tmp.ant = null;
                tmp.sig = null;
                tmp.enlaceHijo = null;
                tmp = null;
                return true;
            }
        }
        return false;
    }
    
    public boolean esRama(){
        return ini != null && fin != null; // si estan en null == rama, != null es hoja
    }
}
