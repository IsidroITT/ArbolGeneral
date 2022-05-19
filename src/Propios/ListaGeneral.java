// Lista doblemente enlazada con nodos generales como nodos de la lista
package Propios;

/**
 *
 * @author isidro
 */
public class ListaGeneral {
    NodoGeneral INI, FIN; 

  public ListaGeneral(){
      INI = FIN = null;
  }//Constructor

  //Metodos de estado
  public boolean listaVacia(){
      return INI == null && FIN == null;
  }

  public boolean ultimoNodo(){
      return INI == FIN;
  }
  //Insertar
  public boolean insertarINI(NodoArbol dato){
      NodoGeneral NUEVO = new NodoGeneral(dato);
      if(NUEVO == null) return false; //Lista "llena"
      if(listaVacia()) {
        INI=FIN=NUEVO;
        return true;}
      INI.ant = NUEVO;
      NUEVO.sig = INI;
      INI =NUEVO;
      return true;
  }

  public boolean insertarFIN(NodoArbol dato){
      NodoGeneral NUEVO = new NodoGeneral(dato);
      if(NUEVO == null) return false; //Lista "llena"
      if(listaVacia()) {
        INI=FIN=NUEVO;
        return true;}
      FIN.sig = NUEVO;
      NUEVO.ant = FIN;
      FIN = NUEVO;
      return true;
  }
  
  public boolean insertarPosN(int pos, NodoArbol dato){
      NodoGeneral NUEVO = new NodoGeneral(dato);
      NodoGeneral TMP = buscaPos(pos);
      if(NUEVO == null || TMP == null) return false;
      if(TMP == FIN){
          insertarFIN(dato);
          return true;
      }
      if(ultimoNodo()){
          INI.ant = NUEVO;
          NUEVO.sig = INI;
          INI = NUEVO;
          return true;
      }
      NUEVO.sig = TMP;
      NUEVO.ant = TMP.ant;
      TMP.ant = NUEVO;
      NUEVO.ant.sig = NUEVO;
      return true;
  }
  
  private NodoGeneral buscaPos(int pos){
      int numNodos = 1;
      for(NodoGeneral TMP = INI; TMP != null; TMP = TMP.sig){
          if(numNodos==pos) return TMP;
          numNodos++;
      }
      return null;
  }
  //Eliminar
  public boolean eliminarValor(char valorEliminar){
      //1.- Lista vacia
      if(listaVacia()) return false;
      //2.- Un solo nodo
      if(ultimoNodo()){
          eliminarINI();
          return true;
      }
      //3.- Lista con valores
      //3.1.- Lista vacia
      if(valorEliminar == INI.dato.dato){ 
          eliminarINI(); return true;
      }
      //3.2.- Un solo nodo
      if(valorEliminar == FIN.dato.dato){ 
          NodoGeneral TMP = FIN;
          FIN = TMP.ant;
          FIN.sig = TMP.ant = null;
          TMP = null;
          return true;
      }
      //3.3.- Lista con valores
      NodoGeneral TMP = null;
      for(NodoGeneral ciclo = INI.sig; ciclo != null; ciclo = ciclo.sig){
          if(valorEliminar==ciclo.dato.dato) {TMP = ciclo; break;}
          else return false;
      }
      TMP.ant.sig = TMP.sig;
      TMP.sig.ant = TMP.ant;
      TMP.sig = TMP.ant = null;
      TMP = null;
      return true;
  }
  
  public boolean eliminarFIN(){
      if (listaVacia()) return false;
        NodoGeneral TMP = FIN;
        if (ultimoNodo()) {
            INI = FIN = null; //Se generan condiciones iniciales
            TMP = null;
            return true;
        }//hay 2 o mas nodos
        FIN = TMP.ant;
        TMP.ant = null;
        FIN.sig = null;
        TMP = null;
        return true;
  }
  
  public boolean eliminarINI(){
      if (listaVacia()) return false;
        NodoGeneral TMP = INI;
        if (ultimoNodo()) {
            INI = FIN = null; //Se generan condiciones iniciales
            TMP = null;
            return true;
        }//hay 2 o mas nodos
        INI = TMP.sig;
        TMP.sig = null;
        INI.ant = null;
        TMP = null;
        return true;
  }
  
   //Mostrar
    public String mostrarINIaFIN(){
        if(listaVacia()) return "";
        String cad = "";
        
        for(NodoGeneral TMP = INI; TMP!=null; TMP = TMP.sig){
            cad += TMP.dato+"<-->";
        }
        return cad;
    }
    
    public String mostrarFINaINI(){
        if(listaVacia()) return "";
        String cad = "";
        
        for(NodoGeneral TMP = FIN; TMP!=null; TMP = TMP.ant){
            cad += TMP.dato+"<-->";
        }
        return cad;
    }
    
    //Codigo de modificar
    public boolean modificarNodo(char nodoModificar, char valorNuevo){
        NodoGeneral TMP = buscarNodo(nodoModificar) ;
        if(TMP == null) return false;
        TMP.dato.dato= valorNuevo;
        return true;
    }
    
    private NodoGeneral buscarNodo(char busca){
        for(NodoGeneral TMP = INI; TMP!=null; TMP = TMP.sig){
            if(TMP.dato.dato == busca)
                return TMP;
        }
        return null;
    }
}
