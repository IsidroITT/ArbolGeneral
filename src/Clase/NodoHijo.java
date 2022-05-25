package Clase;

class NodoHijo {

    NodoGeneral enlaceHijo;
    NodoHijo ant, sig;

    public NodoHijo(NodoGeneral enlaceAlHijo) {
        this.enlaceHijo = enlaceAlHijo;
        ant = sig = null;
    }
}
