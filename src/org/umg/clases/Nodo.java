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
public class Nodo {
    public int correlativo;
    public int numeroAvion;
    public int dpi;
    public String nombrePasajero;
    public int numeroAsiento;
    public Nodo siguiente;
    public Nodo anterior;
    
    public Nodo(int correlativo, int numeroAvion, int dpi, String nombre, int asiento){
        this.correlativo = correlativo;
        this.numeroAvion = numeroAvion;
        this.dpi = dpi;
        this.nombrePasajero = nombre;
        this.numeroAsiento = asiento;
        siguiente = null;
        anterior = null;
    }
}
