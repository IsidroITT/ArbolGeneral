
package Clase;

public class ArbolGeneral {
    NodoGeneral raiz;
    
    public ArbolGeneral(){raiz = null;}
    
    public boolean insertar(String pathPadre, char dato){
        //1.- Revisa si raiz existe, si no lo crea con el valor del dato
        if(raiz == null){
            raiz = new NodoGeneral(dato);
            return true;
        }
        //2.- Revisa si el path path exite
        NodoGeneral padre = encontrarNodo(pathPadre);
        if( padre == null) return false;
        
        //3.- Si exite un hermano que se llame IGUAL que el hijo que vamos a crear
        NodoGeneral gemelo = encontrarNodo(pathPadre+"/"+dato);
        // regresa falso si exite un gemelo
        if( gemelo != null) return false;
        
        //4.- Se construye el nodo a enlazar/insertar en el arbol
        NodoGeneral hijoNuevo = new NodoGeneral(dato);
        
        return padre.enlazaHijo(hijoNuevo);
    }
    
    public boolean eliminar(String pathNodoEliminar){
        return true;
    }
    
    public NodoGeneral encontrarNodo(String path){
        if(raiz == null || path.isEmpty()) return null;// retorna null, si no existe raiz o path esta vacio
//        if(raiz == null) return null;//salir si no existe raiz
//        if(path.isEmpty()) return null;//salir si no exite path
        //quitar diagonal
        path = path.replaceFirst("/", "");
        //convertir cadena a vector
        String vector[] = path.split("");
        //descartar si el valor de raiz no coincide con la raiz real
        if(raiz.dato != vector[0].charAt(0)) return null;
        //regresa raiz si el path de tam 1
        if(vector.length == 1) return raiz;
        //crear nodo encontrado
        NodoGeneral nodoEncontrado = raiz.encontrarHijo(vector[1].charAt(0));
        //salir no existe el nodo
        if(nodoEncontrado == null) return null;
        //continua si hay mas de 2 nodos a buscar
        if(vector.length > 2){
            return encontrarNodo(nodoEncontrado, path.substring(4));
        }else{
            return nodoEncontrado;
        }
    }
    
    public NodoGeneral encontrarNodo(NodoGeneral padre, String path){
        // generamos el vector para buscar nodos
        String[] vector = path.split("/");
        // buscamos dentro del padre el primer elemento del vector
        NodoGeneral nodoEncontrado = padre.encontrarHijo(vector[0].charAt(0)); 
        // regresamos null, si no existe el nodo
        if(nodoEncontrado == null) return null;
        // regresamos el nodo si el vector es de tam 1
        if(vector.length == 1) return nodoEncontrado;
        // buscamos dentro de nodo encontrado si hay mas nodos a buscar
        else  return encontrarNodo(nodoEncontrado, path.substring(2));
    }
}
