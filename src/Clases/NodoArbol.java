/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

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
