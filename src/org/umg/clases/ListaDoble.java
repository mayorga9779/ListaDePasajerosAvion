/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.umg.clases;

/**
 *
 * @author Edgar Mayorga
 */
public class ListaDoble {
    Nodo cabezera;
    Nodo puntero;
    
    public ListaDoble(){
        cabezera = puntero = null;
    }
    
    public boolean vacia(){
        boolean vacia = false;
        
        if(cabezera == null){
            vacia = true;
        }
        return vacia;
    }
    
    /*public ListaDoble insertaInicio(int correlativo, int numeroAvion, int dpi, String nombre, int asiento){
        Nodo nuevo = new Nodo(correlativo, numeroAvion, dpi, nombre, asiento);
        if(vacia()){
            cabezera = puntero = nuevo;
        }else{
            nuevo.siguiente = cabezera;
            cabezera.anterior = nuevo;
            cabezera = nuevo;
        }
        return this;
    }*/
    
    public void insertaFinal(int numeroAvion, int dpi, String nombre, int asiento){
        int correlativo = elementos() + 1;
        Nodo nuevo = new Nodo(correlativo, numeroAvion, dpi, nombre, asiento);
        
        if(vacia()){
            cabezera  = puntero = nuevo;
        }else{
            puntero.siguiente = nuevo;
            nuevo.anterior = puntero;
            puntero = nuevo;
        }
    }
    
    public void eliminarCorrelativo(int correlativo) throws Exception{
        Nodo actual;
        boolean encontrado = false;
        actual = cabezera;
        
        while((actual != null) && (!encontrado)){
            encontrado = (actual.correlativo == correlativo);
            
            if(!encontrado){
                actual = actual.siguiente;
            }
        }
        if(actual != null){
            if(actual == cabezera){
                cabezera = actual.siguiente;
                
                if(actual.siguiente != null){
                    actual.siguiente.anterior = null;
                }
            }else if(actual.siguiente != null){
                actual.anterior.siguiente = actual.siguiente;
                actual.siguiente.anterior = actual.anterior;
            }else{
                actual.anterior.siguiente = null;
            }
            if(actual == puntero){
                puntero = actual.anterior;
            }
            actual = null;
        }
    }
    
    public void eliminar(int dpi) throws Exception{
        Nodo actual;
        boolean encontrado = false;
        actual = cabezera;
        
        while((actual != null) && (!encontrado)){
            encontrado = (actual.dpi == dpi);
            
            if(!encontrado){
                actual = actual.siguiente;
            }
        }
        if(actual != null){
            if(actual == cabezera){
                cabezera = actual.siguiente;
                
                if(actual.siguiente != null){
                    actual.siguiente.anterior = null;
                }
            }else if(actual.siguiente != null){
                actual.anterior.siguiente = actual.siguiente;
                actual.siguiente.anterior = actual.anterior;
            }else{
                actual.anterior.siguiente = null;
            }
            if(actual == puntero){
                puntero = actual.anterior;
            }
            actual = null;
        }
    }
    
    public void eliminarAsiento(int asiento) throws Exception{
        Nodo actual;
        boolean encontrado = false;
        actual = cabezera;
        
        while((actual != null) && (!encontrado)){
            encontrado = (actual.numeroAsiento == asiento);
            
            if(!encontrado){
                actual = actual.siguiente;
            }
        }
        if(actual != null){
            if(actual == cabezera){
                cabezera = actual.siguiente;
                
                if(actual.siguiente != null){
                    actual.siguiente.anterior = null;
                }
            }else if(actual.siguiente != null){
                actual.anterior.siguiente = actual.siguiente;
                actual.siguiente.anterior = actual.anterior;
            }else{
                actual.anterior.siguiente = null;
            }
            if(actual == puntero){
                puntero = actual.anterior;
            }
            actual = null;
        }
    }
    
    
    
    public boolean buscarElemento(int dpi){
        Nodo temp = cabezera;
        
        while(temp != null){
            if(temp.dpi == dpi){
                System.out.println("Pasajero encontrado");
                return true;
            }
            temp = temp.siguiente;
        }
        System.out.println("No se encontro al pasajero");
        return false;
    }
    
    public boolean actualizarElemento(int correlativo, int nuevoDpi, String nuevoNombre, int nuevoAsiento){
        Nodo temp = cabezera;
        
        while(temp != null){
            if(temp.correlativo == correlativo){
                temp.dpi = nuevoDpi;
                temp.nombrePasajero = nuevoNombre;
                temp.numeroAsiento = nuevoAsiento;
                return true;
            }
            temp = temp.siguiente;
        }
        System.out.println("Nodo no encontrado");
        return false;
    }
    
    public boolean actualizarCorrelativo(){
        Nodo temp = cabezera;
        int nuevoCorrelativo = 1;
        
        while(temp != null){
            temp.correlativo = nuevoCorrelativo;
            temp = temp.siguiente;
            nuevoCorrelativo++;
        }
        
        return true;
    }
    
    /*public boolean actualizarElemento(int dpi, int nuevoDpi, String nuevoNombre, int nuevoAsiento){
        Nodo temp = cabezera;
        
        while(temp != null){
            if(temp.dpi == dpi){
                temp.dpi = nuevoDpi;
                temp.nombrePasajero = nuevoNombre;
                temp.numeroAsiento = nuevoAsiento;
                return true;
            }
            temp = temp.siguiente;
        }
        System.out.println("Nodo no encontrado");
        return false;
    }*/
    
    public boolean listaVacia(){
        if(cabezera == null){
            return true;
        }else{
            return false;
        }
    }
    
    public int elementos(){
        int cantidad = 0;
        Nodo n = cabezera;
        
        while(n != null){
            n = n.siguiente;
            cantidad++;
        }
        
        return cantidad;
    }
    
    public void verLista(){
        Nodo n;
        n = cabezera;
        
        while(n != null){
            System.out.println("Correlativo: " + n.correlativo + " No. avion: " + n.numeroAvion + " DPI: " + n.dpi + " Nombre: " + n.nombrePasajero + " Asiento: " + n.numeroAsiento);
            n = n.siguiente;
        }
    }
    
    public Nodo buscarCorrelativo(int correlativo){
        Nodo n = null;
        Nodo auxiliar = null;
        n = cabezera;
        
        while(n != null){
            if(n.correlativo == correlativo){
                auxiliar = new Nodo(n.correlativo, n.numeroAvion, n.dpi, n.nombrePasajero, n.numeroAsiento);
            }
            n = n.siguiente;
        }
        
        return auxiliar;
    }
    
    public Nodo buscarAsiento(int asiento){
        Nodo n = null;
        Nodo auxiliar = null;
        n = cabezera;
        
        while(n != null){
            if(n.numeroAsiento == asiento){
                auxiliar = new Nodo(n.correlativo, n.numeroAvion, n.dpi, n.nombrePasajero, n.numeroAsiento);
                break;
            }
            n = n.siguiente;
        }
        
        return auxiliar;
    }
    
    public void limpiarLista() throws Exception{
        int totalElementos = elementos();
        System.out.println("La lista tiene: " + totalElementos + " elementos a eliminar.");
        
        for(int i = 0; i <= 10; i++){
            eliminarAsiento(i);
        }
    }
    
    public void elementoSiguiente(int asiento){
        Nodo n;
        n = cabezera;
        
        while(n != null){
            if(n.numeroAsiento == asiento){
                System.out.println("Elemento siguiente: DPI: " + n.dpi + " Nombre: " + n.nombrePasajero + " Asiento: " + n.numeroAsiento);
                
            }
            n = n.siguiente;
        }
    }
}
