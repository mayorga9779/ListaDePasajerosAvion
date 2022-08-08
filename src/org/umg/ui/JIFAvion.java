/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.umg.ui;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.umg.clases.ListaDoble;
import org.umg.clases.Nodo;

/**
 *
 * @author Edgar Mayorga
 */
public class JIFAvion extends javax.swing.JInternalFrame {
    private ListaDoble listaAvion1 = new ListaDoble();
    private static int CAPACIDAD = 10;
    private int numeroAvion = 0;
    private int dpi = 0;
    private int numeroAsiento = 0;
    private int correlativo = 1;
    private int correlativoAnterior = 0;
    private int correlativoSiguiente = 0;
    private int asientoOriginal = 0;
    private String nombrePasajero = "";
    private String mensaje = "";
    private String nombreLabel = "";
    private boolean ocupado = false;
    private boolean validador = false;
    
    public JIFAvion(int numeroAvion) throws IOException {
        initComponents();
        this.setSize(900, 700);     //750
        this.setLocation(225, 25);
        spVertical.setBounds(this.getWidth()/2, 0, 25, this.getHeight());
        this.numeroAvion = numeroAvion;
        //cargo los datos desde el archivo, segun la lista del avion que escoja en el programa
        importarDatos(numeroAvion);
        
        txtDPI.setEditable(false);
        txtNombrePasajero.setEditable(false);
        txtNumeroAsiento.setEditable(false);
        cbAsiento.setEnabled(false);
        btnSiguiente.setEnabled(false);
        btnAnterior.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnModificar.setEnabled(false);
        btnGuardarCambios.setEnabled(false);
        btnEliminar.setEnabled(false);
        //btnGuardarLista.setEnabled(false);
    }
    
    public boolean asientoOcupado(int numeroAsiento){
        boolean estaOcupado = false;
        Nodo nodo;
        
        nodo = listaAvion1.buscarAsiento(numeroAsiento);
        
        if(nodo != null){           //si esta ocupado el asiento
            estaOcupado = false;
        }else{
            estaOcupado = true;     //sino esta ocupado el asiento
        }
        
        return estaOcupado;
    }
    
    public void actualizarAsientos(){
        if(!listaAvion1.listaVacia() == true){
            for(int i = 1; i <= 10; i++){
                switch(i){
                    case 1:
                        if(asientoOcupado(i) == false){             //si el asiento esta ocupado
                            lbl1.setBackground(Color.RED);
                        }else{
                            lbl1.setBackground(Color.GREEN);
                        }
                        break;
                    case 2:
                        if(asientoOcupado(i) == false){             //si el asiento esta ocupado
                            lbl2.setBackground(Color.RED);
                        }else{
                            lbl2.setBackground(Color.GREEN);
                        }
                        break;
                    case 3:
                        if(asientoOcupado(i) == false){             //si el asiento esta ocupado
                            lbl3.setBackground(Color.RED);
                        }else{
                            lbl3.setBackground(Color.GREEN);
                        }
                        break;
                    case 4:
                        if(asientoOcupado(i) == false){             //si el asiento esta ocupado
                            lbl4.setBackground(Color.RED);
                        }else{
                            lbl4.setBackground(Color.GREEN);
                        }
                        break;
                    case 5:
                        if(asientoOcupado(i) == false){             //si el asiento esta ocupado
                            lbl5.setBackground(Color.RED);
                        }else{
                            lbl5.setBackground(Color.GREEN);
                        }
                        break;
                    case 6:
                        if(asientoOcupado(i) == false){             //si el asiento esta ocupado
                            lbl6.setBackground(Color.RED);
                        }else{
                            lbl6.setBackground(Color.GREEN);
                        }
                        break;
                    case 7:
                        if(asientoOcupado(i) == false){             //si el asiento esta ocupado
                            lbl7.setBackground(Color.RED);
                        }else{
                            lbl7.setBackground(Color.GREEN);
                        }
                        break;
                    case 8:
                        if(asientoOcupado(i) == false){             //si el asiento esta ocupado
                            lbl8.setBackground(Color.RED);
                        }else{
                            lbl8.setBackground(Color.GREEN);
                        }
                        break;
                    case 9:
                        if(asientoOcupado(i) == false){             //si el asiento esta ocupado
                            lbl9.setBackground(Color.RED);
                        }else{
                            lbl9.setBackground(Color.GREEN);
                        }
                        break;
                    case 10:
                        if(asientoOcupado(i) == false){             //si el asiento esta ocupado
                            lbl10.setBackground(Color.RED);
                        }else{
                            lbl10.setBackground(Color.GREEN);
                        }
                        break;
                }
            }
        }
    }
    
    public void cambiarColorAsientoOcupado(int numeroAsiento, boolean estado){
        if(estado == true){
            switch(numeroAsiento){
                case 1:
                    lbl1.setBackground(Color.red);
                    break;
                case 2:
                    lbl2.setBackground(Color.red);
                    break;
                case 3:
                    lbl3.setBackground(Color.red);
                    break;
                case 4:
                    lbl4.setBackground(Color.red);
                    break;
                case 5:
                    lbl5.setBackground(Color.red);
                    break;
                case 6:
                    lbl6.setBackground(Color.red);
                    break;
                case 7:
                    lbl7.setBackground(Color.red);
                    break;
                case 8:
                    lbl8.setBackground(Color.red);
                    break;
                case 9:
                    lbl9.setBackground(Color.red);
                    break;
                case 10:
                    lbl10.setBackground(Color.red);
                    break;
            }
        }else{
            switch(numeroAsiento){
                case 1:
                    lbl1.setBackground(Color.green);
                    break;
                case 2:
                    lbl2.setBackground(Color.green);
                    break;
                case 3:
                    lbl3.setBackground(Color.green);
                    break;
                case 4:
                    lbl4.setBackground(Color.green);
                    break;
                case 5:
                    lbl5.setBackground(Color.green);
                    break;
                case 6:
                    lbl6.setBackground(Color.green);
                    break;
                case 7:
                    lbl7.setBackground(Color.green);
                    break;
                case 8:
                    lbl8.setBackground(Color.green);
                    break;
                case 9:
                    lbl9.setBackground(Color.green);
                    break;
                case 10:
                    lbl10.setBackground(Color.green);
                    break;
            }
        }
    }
    
    public void limpiarAvion(){
        lbl1.setBackground(Color.green);
        lbl2.setBackground(Color.green);
        lbl3.setBackground(Color.green);
        lbl4.setBackground(Color.green);
        lbl5.setBackground(Color.green);
        lbl6.setBackground(Color.green);
        lbl7.setBackground(Color.green);
        lbl8.setBackground(Color.green);
        lbl9.setBackground(Color.green);
        lbl10.setBackground(Color.green);
    }
    
    public void actualizarCorrelativos(){
        if(!listaAvion1.listaVacia() == true){
            listaAvion1.actualizarCorrelativo();
        }
    }
    
    public void liberarAsiento(int numeroAsiento){
        switch(numeroAsiento){
            case 1:
                lbl1.setBackground(Color.GREEN);
                break;
            case 2:
                lbl2.setBackground(Color.GREEN);
                break;
            case 3:
                lbl3.setBackground(Color.GREEN);
                break;
            case 4:
                lbl4.setBackground(Color.GREEN);
                break;
            case 5:
                lbl5.setBackground(Color.GREEN);
                break;
            case 6:
                lbl6.setBackground(Color.GREEN);
                break;
            case 7:
                lbl7.setBackground(Color.GREEN);
                break;
            case 8:
                lbl8.setBackground(Color.GREEN);
                break;
            case 9:
                lbl9.setBackground(Color.GREEN);
                break;
            case 10:
                lbl10.setBackground(Color.GREEN);
                break;
        }
    }
    
    public void exportarDatos(int numeroAvion){
        String ruta = "C:/Directorio_pasajeros";
        String nombrePasajero = "";
        int correlativo = 0;
        int dpi = 0;
        int numeroAsiento = 0;
        File directorio = new File(ruta);
        PrintWriter salida = null;
        
        try{
            //Verifico que la lista no este vacia
            if(!listaAvion1.listaVacia() == true){
                //Verifico si el directorio existe.
                if(!directorio.exists()){
                    //creo el directorio o carpeta
                    if(directorio.mkdirs()){
                        //Creo el archivo con los datos de la lista.
                        salida = new PrintWriter(new BufferedWriter(new FileWriter(ruta + "/Lista_avion" + numeroAvion + ".txt")));
                        //mando a escribir los datos de la lista al archivo de texto
                        for(int i = 1; i <= listaAvion1.elementos(); i++){
                            correlativo = listaAvion1.buscarCorrelativo(i).correlativo;
                            dpi = listaAvion1.buscarCorrelativo(i).dpi;
                            nombrePasajero = listaAvion1.buscarCorrelativo(i).nombrePasajero;
                            numeroAsiento = listaAvion1.buscarCorrelativo(i).numeroAsiento;

                            salida.println(correlativo + ";" +  dpi + ";" + nombrePasajero + ";" + numeroAsiento);
                        }
                        salida.close();
                        JOptionPane.showMessageDialog(null, "¡Los datos se guardaron en el archivo " + ruta + "/Lista_avion" + numeroAvion + ".txt" + " con éxito!", "MENSAJE", JOptionPane.INFORMATION_MESSAGE);
                    }
                }else{              //si el directorio o carpeta ya existe.
                    //Creo el archivo con los datos de la lista.
                    salida = new PrintWriter(new BufferedWriter(new FileWriter(ruta + "/Lista_avion" + numeroAvion + ".txt")));
                    //mando a escribir los datos de la lista al archivo de texto
                    for(int i = 1; i <= listaAvion1.elementos(); i++){
                        correlativo = listaAvion1.buscarCorrelativo(i).correlativo;
                        dpi = listaAvion1.buscarCorrelativo(i).dpi;
                        nombrePasajero = listaAvion1.buscarCorrelativo(i).nombrePasajero;
                        numeroAsiento = listaAvion1.buscarCorrelativo(i).numeroAsiento;
                        
                        salida.println(correlativo + ";" +  dpi + ";" + nombrePasajero + ";" + numeroAsiento);
                    }
                    salida.close();
                    JOptionPane.showMessageDialog(null, "¡Los datos se guardaron en el archivo " + ruta + "/Lista_avion" + numeroAvion + ".txt" + " con éxito!", "MENSAJE", JOptionPane.INFORMATION_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(null, "La lista de pasajeros esta vacia.", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Ocurrio un problema al guardar la lista. " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void importarDatos(int numeroAvion) throws IOException{
        String ruta = "C:/Directorio_pasajeros";
        String nombrePasajero = "";
        String archivo = ruta + "/Lista_avion" + numeroAvion + ".txt";
        int dpi = 0;
        int numeroAsiento = 0;
        File directorio = new File(ruta);
        File documento = new File(archivo);
        BufferedReader entrada = null;
        
        try{
            //si no existe el directorio o carpeta, que lo cree
            if(!directorio.exists()){
                if(directorio.mkdirs()){
                    
                }
            }else{
                //valido si el archivo o documento con datos de la lista de pasajeros existe.
                if(documento.exists()){
                    entrada = new BufferedReader(new FileReader(archivo));
                
                    String s = new String();
                    String s2 = new String();
                    ///si la lista esta vacia
                    if (listaAvion1.listaVacia() == true) {
                        while ((s = entrada.readLine()) != null) {
                            s2 += s + "\n";
                            String[] informacion = s.split(";");
                            dpi = Integer.parseInt(informacion[1]);
                            nombrePasajero = informacion[2];
                            numeroAsiento = Integer.parseInt(informacion[3]);

                            //inserto los datos en la lista
                            listaAvion1.insertaFinal(numeroAvion, dpi, nombrePasajero, numeroAsiento);
                            //actualizo los asientos del avion
                            cambiarColorAsientoOcupado(numeroAsiento, true);
                        }
                        
                        System.out.println("Los datos del arvhivo " + ruta + "/Lista_avion" + numeroAvion + ".txt  son");
                        System.out.println("########################################################################################");
                        listaAvion1.verLista();
                        entrada.close();
                    }
                }else{
                    System.out.println("El archivo " + archivo + " no existe.");
                }
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Ocurrio un error al cargar datos desde el archivo " + "/Lista_avion" + numeroAvion + ".txt", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        spVertical = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblAsientoSeleccionado = new javax.swing.JLabel();
        lbl6 = new javax.swing.JLabel();
        lbl5 = new javax.swing.JLabel();
        lbl3 = new javax.swing.JLabel();
        lbl4 = new javax.swing.JLabel();
        lbl1 = new javax.swing.JLabel();
        lbl2 = new javax.swing.JLabel();
        lbl7 = new javax.swing.JLabel();
        lbl8 = new javax.swing.JLabel();
        lbl9 = new javax.swing.JLabel();
        lbl10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtIngresoDpi = new javax.swing.JTextField();
        txtIngresoNombrePasajero = new javax.swing.JTextField();
        btnAnterior = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtDPI = new javax.swing.JTextField();
        txtNombrePasajero = new javax.swing.JTextField();
        txtNumeroAsiento = new javax.swing.JTextField();
        btnModificar = new javax.swing.JButton();
        btnGuardarCambios = new javax.swing.JButton();
        btnGuardarLista = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        cbAsiento = new javax.swing.JComboBox<>();
        btnNuevoViaje = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnAgregarPasajero = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(null);

        spVertical.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(spVertical);
        spVertical.setBounds(450, 0, 10, 730);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ACTUALIZACIÓN LISTA PASAJEROS");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(460, 10, 400, 22);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("INGRESO DE PASAJEROS");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 10, 410, 22);

        jLabel3.setText("DPI:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 40, 110, 20);

        jLabel4.setText("Nombre pasajero:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 70, 110, 20);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Seleccionar asiento", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanel1.setLayout(null);

        jLabel7.setBackground(new java.awt.Color(255, 51, 51));
        jLabel7.setOpaque(true);
        jPanel1.add(jLabel7);
        jLabel7.setBounds(250, 190, 40, 40);

        jLabel8.setBackground(new java.awt.Color(51, 255, 51));
        jLabel8.setOpaque(true);
        jPanel1.add(jLabel8);
        jLabel8.setBounds(250, 140, 40, 40);

        lblAsientoSeleccionado.setBackground(java.awt.Color.orange);
        lblAsientoSeleccionado.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblAsientoSeleccionado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAsientoSeleccionado.setOpaque(true);
        jPanel1.add(lblAsientoSeleccionado);
        lblAsientoSeleccionado.setBounds(250, 240, 40, 40);

        lbl6.setBackground(new java.awt.Color(51, 255, 51));
        lbl6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl6.setText("6");
        lbl6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbl6.setOpaque(true);
        lbl6.setPreferredSize(new java.awt.Dimension(15, 15));
        lbl6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl6MouseClicked(evt);
            }
        });
        jPanel1.add(lbl6);
        lbl6.setBounds(160, 170, 25, 20);

        lbl5.setBackground(new java.awt.Color(51, 255, 51));
        lbl5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl5.setText("5");
        lbl5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbl5.setOpaque(true);
        lbl5.setPreferredSize(new java.awt.Dimension(15, 15));
        lbl5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl5MouseClicked(evt);
            }
        });
        jPanel1.add(lbl5);
        lbl5.setBounds(130, 170, 25, 20);

        lbl3.setBackground(new java.awt.Color(51, 255, 51));
        lbl3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl3.setText("3");
        lbl3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbl3.setOpaque(true);
        lbl3.setPreferredSize(new java.awt.Dimension(15, 15));
        lbl3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl3MouseClicked(evt);
            }
        });
        jPanel1.add(lbl3);
        lbl3.setBounds(130, 150, 25, 20);

        lbl4.setBackground(new java.awt.Color(51, 255, 51));
        lbl4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl4.setText("4");
        lbl4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbl4.setOpaque(true);
        lbl4.setPreferredSize(new java.awt.Dimension(15, 15));
        lbl4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl4MouseClicked(evt);
            }
        });
        jPanel1.add(lbl4);
        lbl4.setBounds(160, 150, 25, 20);

        lbl1.setBackground(new java.awt.Color(51, 255, 51));
        lbl1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl1.setText("1");
        lbl1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbl1.setOpaque(true);
        lbl1.setPreferredSize(new java.awt.Dimension(15, 15));
        lbl1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl1MouseClicked(evt);
            }
        });
        jPanel1.add(lbl1);
        lbl1.setBounds(130, 120, 25, 20);

        lbl2.setBackground(new java.awt.Color(51, 255, 51));
        lbl2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl2.setText("2");
        lbl2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbl2.setOpaque(true);
        lbl2.setPreferredSize(new java.awt.Dimension(15, 15));
        lbl2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl2MouseClicked(evt);
            }
        });
        jPanel1.add(lbl2);
        lbl2.setBounds(160, 120, 25, 20);

        lbl7.setBackground(new java.awt.Color(51, 255, 51));
        lbl7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl7.setText("7");
        lbl7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbl7.setOpaque(true);
        lbl7.setPreferredSize(new java.awt.Dimension(15, 15));
        lbl7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl7MouseClicked(evt);
            }
        });
        jPanel1.add(lbl7);
        lbl7.setBounds(130, 200, 25, 20);

        lbl8.setBackground(new java.awt.Color(51, 255, 51));
        lbl8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl8.setText("8");
        lbl8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbl8.setOpaque(true);
        lbl8.setPreferredSize(new java.awt.Dimension(15, 15));
        lbl8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl8MouseClicked(evt);
            }
        });
        jPanel1.add(lbl8);
        lbl8.setBounds(160, 200, 25, 20);

        lbl9.setBackground(new java.awt.Color(51, 255, 51));
        lbl9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl9.setText("9");
        lbl9.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbl9.setOpaque(true);
        lbl9.setPreferredSize(new java.awt.Dimension(15, 15));
        lbl9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl9MouseClicked(evt);
            }
        });
        jPanel1.add(lbl9);
        lbl9.setBounds(130, 220, 25, 20);

        lbl10.setBackground(new java.awt.Color(51, 255, 51));
        lbl10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl10.setText("10");
        lbl10.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbl10.setOpaque(true);
        lbl10.setPreferredSize(new java.awt.Dimension(15, 15));
        lbl10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl10MouseClicked(evt);
            }
        });
        jPanel1.add(lbl10);
        lbl10.setBounds(160, 220, 25, 20);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("LEYENDA:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(250, 100, 160, 14);

        jLabel9.setText("Asiento vacio");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(300, 150, 110, 30);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/umg/img/esquema_avion3.png"))); // NOI18N
        jPanel1.add(jLabel5);
        jLabel5.setBounds(10, 20, 300, 450);

        jLabel10.setText("Asiento ocupado");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(300, 190, 110, 40);

        jLabel11.setText("Asiento");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(300, 250, 80, 14);

        jLabel12.setText("seleccionado:");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(300, 270, 80, 14);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 170, 420, 480);
        getContentPane().add(txtIngresoDpi);
        txtIngresoDpi.setBounds(120, 40, 170, 20);
        getContentPane().add(txtIngresoNombrePasajero);
        txtIngresoNombrePasajero.setBounds(120, 70, 310, 20);

        btnAnterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/umg/img/anterior-boton.png"))); // NOI18N
        btnAnterior.setText("Anterior");
        btnAnterior.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAnterior.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });
        getContentPane().add(btnAnterior);
        btnAnterior.setBounds(580, 100, 90, 60);

        btnSiguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/umg/img/siguiente-boton.png"))); // NOI18N
        btnSiguiente.setText("Siguiente");
        btnSiguiente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSiguiente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });
        getContentPane().add(btnSiguiente);
        btnSiguiente.setBounds(670, 100, 90, 60);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Manejo de lista de pasajeros", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanel2.setLayout(null);

        jLabel13.setText("DPI de pasajero:");
        jPanel2.add(jLabel13);
        jLabel13.setBounds(30, 40, 130, 20);

        jLabel14.setText("Nombre del pasajero:");
        jPanel2.add(jLabel14);
        jLabel14.setBounds(30, 70, 130, 20);

        jLabel15.setText("No. asiento:");
        jPanel2.add(jLabel15);
        jLabel15.setBounds(30, 100, 130, 20);
        jPanel2.add(txtDPI);
        txtDPI.setBounds(160, 40, 160, 20);
        jPanel2.add(txtNombrePasajero);
        txtNombrePasajero.setBounds(160, 70, 160, 20);
        jPanel2.add(txtNumeroAsiento);
        txtNumeroAsiento.setBounds(160, 100, 80, 20);

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/umg/img/editar.png"))); // NOI18N
        btnModificar.setText("Editar pasajero");
        btnModificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnModificar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel2.add(btnModificar);
        btnModificar.setBounds(20, 170, 90, 60);

        btnGuardarCambios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/umg/img/guardar-el-archivo.png"))); // NOI18N
        btnGuardarCambios.setText("Guardar cambios");
        btnGuardarCambios.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGuardarCambios.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGuardarCambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCambiosActionPerformed(evt);
            }
        });
        jPanel2.add(btnGuardarCambios);
        btnGuardarCambios.setBounds(110, 170, 90, 60);

        btnGuardarLista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/umg/img/documentos.png"))); // NOI18N
        btnGuardarLista.setText("Enviar a archivo");
        btnGuardarLista.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGuardarLista.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGuardarLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarListaActionPerformed(evt);
            }
        });
        jPanel2.add(btnGuardarLista);
        btnGuardarLista.setBounds(290, 170, 90, 60);

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/umg/img/boton-eliminar.png"))); // NOI18N
        btnEliminar.setText("Eliminar pasajero");
        btnEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel2.add(btnEliminar);
        btnEliminar.setBounds(200, 170, 90, 60);

        cbAsiento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        cbAsiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAsientoActionPerformed(evt);
            }
        });
        jPanel2.add(cbAsiento);
        cbAsiento.setBounds(250, 100, 70, 20);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(470, 170, 410, 480);

        btnNuevoViaje.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/umg/img/modo-vuelo.png"))); // NOI18N
        btnNuevoViaje.setText("Nuevo viaje");
        btnNuevoViaje.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevoViaje.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNuevoViaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoViajeActionPerformed(evt);
            }
        });
        getContentPane().add(btnNuevoViaje);
        btnNuevoViaje.setBounds(250, 100, 89, 60);

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/umg/img/buscar.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBuscar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar);
        btnBuscar.setBounds(490, 100, 90, 60);

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/umg/img/detener.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar);
        btnCancelar.setBounds(760, 100, 90, 60);

        btnAgregarPasajero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/umg/img/agregar-usuario.png"))); // NOI18N
        btnAgregarPasajero.setText("Agregar pasajero");
        btnAgregarPasajero.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAgregarPasajero.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAgregarPasajero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPasajeroActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregarPasajero);
        btnAgregarPasajero.setBounds(340, 100, 90, 60);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbl1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl1MouseClicked
        // TODO add your handling code here:
        lblAsientoSeleccionado.setText("");
        lblAsientoSeleccionado.setText(lbl1.getText());
        lbl1.setBackground(Color.ORANGE);
        
        if(lbl2.getBackground() != Color.RED && listaAvion1.buscarAsiento(2) == null){
            lbl2.setBackground(Color.GREEN);
        }else{
            lbl2.setBackground(Color.RED);
        }
        if(lbl3.getBackground() != Color.RED && listaAvion1.buscarAsiento(3) == null){
            lbl3.setBackground(Color.GREEN);
        }else{
            lbl3.setBackground(Color.RED);
        }
        if(lbl4.getBackground() != Color.RED && listaAvion1.buscarAsiento(4) == null){
            lbl4.setBackground(Color.GREEN);
        }else{
            lbl4.setBackground(Color.RED);
        }
        if(lbl5.getBackground() != Color.RED && listaAvion1.buscarAsiento(5) == null){
            lbl5.setBackground(Color.GREEN);
        }else{
            lbl5.setBackground(Color.RED);
        }
        if(lbl6.getBackground() != Color.RED && listaAvion1.buscarAsiento(6) == null){
            lbl6.setBackground(Color.GREEN);
        }else{
            lbl6.setBackground(Color.RED);
        }
        if(lbl7.getBackground() != Color.RED && listaAvion1.buscarAsiento(7) == null){
            lbl7.setBackground(Color.GREEN);
        }else{
            lbl7.setBackground(Color.RED);
        }
        if(lbl8.getBackground() != Color.RED && listaAvion1.buscarAsiento(8) == null){
            lbl8.setBackground(Color.GREEN);
        }else{
            lbl8.setBackground(Color.RED);
        }
        if(lbl9.getBackground() != Color.RED && listaAvion1.buscarAsiento(9) == null){
            lbl9.setBackground(Color.GREEN);
        }else{
            lbl9.setBackground(Color.RED);
        }
        if(lbl10.getBackground() != Color.RED && listaAvion1.buscarAsiento(10) == null){
            lbl10.setBackground(Color.GREEN);
        }else{
            lbl10.setBackground(Color.RED);
        }
    }//GEN-LAST:event_lbl1MouseClicked

    private void btnAgregarPasajeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPasajeroActionPerformed
        // TODO add your handling code here:
        try{
            if(!txtIngresoDpi.getText().trim().equals("")){
                dpi = Integer.parseInt(txtIngresoDpi.getText().trim());
            }else{
                mensaje = "Debe ingresar el DPI del pasajero.";
            }
            if(!txtIngresoNombrePasajero.getText().trim().equals("")){
                nombrePasajero = txtIngresoNombrePasajero.getText().trim().toUpperCase();
            }else{
                mensaje = "Debe ingresar el nombre del pasajero.";
            }
            if(!lblAsientoSeleccionado.getText().trim().equals("")){
                numeroAsiento = Integer.parseInt(lblAsientoSeleccionado.getText());
            }else{
                mensaje = "Debe seleccionar el asiento en el avion para el pasajero.";
            }

            if(!txtIngresoDpi.getText().trim().equals("") && !txtIngresoNombrePasajero.getText().trim().equals("") && !lblAsientoSeleccionado.getText().trim().equals("")){
                if(listaAvion1.elementos() < CAPACIDAD){
                    if(asientoOcupado(numeroAsiento) == true){
                        listaAvion1.insertaFinal(numeroAvion, dpi, nombrePasajero, numeroAsiento);
                        cambiarColorAsientoOcupado(numeroAsiento, true);
                        txtIngresoDpi.setText("");
                        txtIngresoNombrePasajero.setText("");
                        lblAsientoSeleccionado.setText("");
                        listaAvion1.verLista();
                        System.out.println("_________________________________________________________________________________________");
                        mensaje = "OK";
                    }else{
                        mensaje = "El asiento seleccionado ya esta ocupado.";
                    }

                }else{
                    mensaje = "Se excedió la capacidad de asientos.";
                }
            }

            if(!mensaje.equals("OK")){
                JOptionPane.showMessageDialog(null, mensaje, "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Pasajero agregado con éxito.", "MENSAJE", JOptionPane.INFORMATION_MESSAGE);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error al ingresar un DPI invalido", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btnAgregarPasajeroActionPerformed

    private void lbl2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl2MouseClicked
        // TODO add your handling code here:
        lblAsientoSeleccionado.setText("");
        lblAsientoSeleccionado.setText(lbl2.getText());
        lbl2.setBackground(Color.ORANGE);
        
        if(lbl1.getBackground() != Color.RED && listaAvion1.buscarAsiento(1) == null){
            lbl1.setBackground(Color.GREEN);
        }else{
            lbl1.setBackground(Color.RED);
        }
        if(lbl3.getBackground() != Color.RED && listaAvion1.buscarAsiento(3) == null){
            lbl3.setBackground(Color.GREEN);
        }else{
            lbl3.setBackground(Color.RED);
        }
        if(lbl4.getBackground() != Color.RED && listaAvion1.buscarAsiento(4) == null){
            lbl4.setBackground(Color.GREEN);
        }else{
            lbl4.setBackground(Color.RED);
        }
        if(lbl5.getBackground() != Color.RED && listaAvion1.buscarAsiento(5) == null){
            lbl5.setBackground(Color.GREEN);
        }else{
            lbl5.setBackground(Color.RED);
        }
        if(lbl6.getBackground() != Color.RED && listaAvion1.buscarAsiento(6) == null){
            lbl6.setBackground(Color.GREEN);
        }else{
            lbl6.setBackground(Color.RED);
        }
        if(lbl7.getBackground() != Color.RED && listaAvion1.buscarAsiento(7) == null){
            lbl7.setBackground(Color.GREEN);
        }else{
            lbl7.setBackground(Color.RED);
        }
        if(lbl8.getBackground() != Color.RED && listaAvion1.buscarAsiento(8) == null){
            lbl8.setBackground(Color.GREEN);
        }else{
            lbl8.setBackground(Color.RED);
        }
        if(lbl9.getBackground() != Color.RED && listaAvion1.buscarAsiento(9) == null){
            lbl9.setBackground(Color.GREEN);
        }else{
            lbl9.setBackground(Color.RED);
        }
        if(lbl10.getBackground() != Color.RED && listaAvion1.buscarAsiento(10) == null){
            lbl10.setBackground(Color.GREEN);
        }else{
            lbl10.setBackground(Color.RED);
        }
    }//GEN-LAST:event_lbl2MouseClicked

    private void lbl3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl3MouseClicked
        // TODO add your handling code here:
        lblAsientoSeleccionado.setText("");
        lblAsientoSeleccionado.setText(lbl3.getText());
        lbl3.setBackground(Color.ORANGE);
        
        if(lbl1.getBackground() != Color.RED && listaAvion1.buscarAsiento(1) == null){
            lbl1.setBackground(Color.GREEN);
        }else{
            lbl1.setBackground(Color.RED);
        }
        if(lbl2.getBackground() != Color.RED && listaAvion1.buscarAsiento(2) == null){
            lbl2.setBackground(Color.GREEN);
        }else{
            lbl2.setBackground(Color.RED);
        }
        if(lbl4.getBackground() != Color.RED && listaAvion1.buscarAsiento(4) == null){
            lbl4.setBackground(Color.GREEN);
        }else{
            lbl4.setBackground(Color.RED);
        }
        if(lbl5.getBackground() != Color.RED && listaAvion1.buscarAsiento(5) == null){
            lbl5.setBackground(Color.GREEN);
        }else{
            lbl5.setBackground(Color.RED);
        }
        if(lbl6.getBackground() != Color.RED && listaAvion1.buscarAsiento(6) == null){
            lbl6.setBackground(Color.GREEN);
        }else{
            lbl6.setBackground(Color.RED);
        }
        if(lbl7.getBackground() != Color.RED && listaAvion1.buscarAsiento(7) == null){
            lbl7.setBackground(Color.GREEN);
        }else{
            lbl7.setBackground(Color.RED);
        }
        if(lbl8.getBackground() != Color.RED && listaAvion1.buscarAsiento(8) == null){
            lbl8.setBackground(Color.GREEN);
        }else{
            lbl8.setBackground(Color.RED);
        }
        if(lbl9.getBackground() != Color.RED && listaAvion1.buscarAsiento(9) == null){
            lbl9.setBackground(Color.GREEN);
        }else{
            lbl9.setBackground(Color.RED);
        }
        if(lbl10.getBackground() != Color.RED && listaAvion1.buscarAsiento(10) == null){
            lbl10.setBackground(Color.GREEN);
        }else{
            lbl10.setBackground(Color.RED);
        }
    }//GEN-LAST:event_lbl3MouseClicked

    private void lbl4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl4MouseClicked
        // TODO add your handling code here:
        lblAsientoSeleccionado.setText("");
        lblAsientoSeleccionado.setText(lbl4.getText());
        lbl4.setBackground(Color.ORANGE);
        
        if(lbl1.getBackground() != Color.RED && listaAvion1.buscarAsiento(1) == null){
            lbl1.setBackground(Color.GREEN);
        }else{
            lbl1.setBackground(Color.RED);
        }
        if(lbl2.getBackground() != Color.RED && listaAvion1.buscarAsiento(2) == null){
            lbl2.setBackground(Color.GREEN);
        }else{
            lbl2.setBackground(Color.RED);
        }
        if(lbl3.getBackground() != Color.RED && listaAvion1.buscarAsiento(3) == null){
            lbl3.setBackground(Color.GREEN);
        }else{
            lbl3.setBackground(Color.RED);
        }
        if(lbl5.getBackground() != Color.RED && listaAvion1.buscarAsiento(5) == null){
            lbl5.setBackground(Color.GREEN);
        }else{
            lbl5.setBackground(Color.RED);
        }
        if(lbl6.getBackground() != Color.RED && listaAvion1.buscarAsiento(6) == null){
            lbl6.setBackground(Color.GREEN);
        }else{
            lbl6.setBackground(Color.RED);
        }
        if(lbl7.getBackground() != Color.RED && listaAvion1.buscarAsiento(7) == null){
            lbl7.setBackground(Color.GREEN);
        }else{
            lbl7.setBackground(Color.RED);
        }
        if(lbl8.getBackground() != Color.RED && listaAvion1.buscarAsiento(8) == null){
            lbl8.setBackground(Color.GREEN);
        }else{
            lbl8.setBackground(Color.RED);
        }
        if(lbl9.getBackground() != Color.RED && listaAvion1.buscarAsiento(9) == null){
            lbl9.setBackground(Color.GREEN);
        }else{
            lbl9.setBackground(Color.RED);
        }
        if(lbl10.getBackground() != Color.RED && listaAvion1.buscarAsiento(10) == null){
            lbl10.setBackground(Color.GREEN);
        }else{
            lbl10.setBackground(Color.RED);
        }
    }//GEN-LAST:event_lbl4MouseClicked

    private void lbl5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl5MouseClicked
        // TODO add your handling code here:
        lblAsientoSeleccionado.setText("");
        lblAsientoSeleccionado.setText(lbl5.getText());
        lbl5.setBackground(Color.ORANGE);
        
        if(lbl1.getBackground() != Color.RED && listaAvion1.buscarAsiento(1) == null){
            lbl1.setBackground(Color.GREEN);
        }else{
            lbl1.setBackground(Color.RED);
        }
        if(lbl2.getBackground() != Color.RED && listaAvion1.buscarAsiento(2) == null){
            lbl2.setBackground(Color.GREEN);
        }else{
            lbl2.setBackground(Color.RED);
        }
        if(lbl3.getBackground() != Color.RED && listaAvion1.buscarAsiento(3) == null){
            lbl3.setBackground(Color.GREEN);
        }else{
            lbl3.setBackground(Color.RED);
        }
        if(lbl4.getBackground() != Color.RED && listaAvion1.buscarAsiento(4) == null){
            lbl4.setBackground(Color.GREEN);
        }else{
            lbl4.setBackground(Color.RED);
        }
        if(lbl6.getBackground() != Color.RED && listaAvion1.buscarAsiento(6) == null){
            lbl6.setBackground(Color.GREEN);
        }else{
            lbl6.setBackground(Color.RED);
        }
        if(lbl7.getBackground() != Color.RED && listaAvion1.buscarAsiento(7) == null){
            lbl7.setBackground(Color.GREEN);
        }else{
            lbl7.setBackground(Color.RED);
        }
        if(lbl8.getBackground() != Color.RED && listaAvion1.buscarAsiento(8) == null){
            lbl8.setBackground(Color.GREEN);
        }else{
            lbl8.setBackground(Color.RED);
        }
        if(lbl9.getBackground() != Color.RED && listaAvion1.buscarAsiento(9) == null){
            lbl9.setBackground(Color.GREEN);
        }else{
            lbl9.setBackground(Color.RED);
        }
        if(lbl10.getBackground() != Color.RED && listaAvion1.buscarAsiento(10) == null){
            lbl10.setBackground(Color.GREEN);
        }else{
            lbl10.setBackground(Color.RED);
        }
    }//GEN-LAST:event_lbl5MouseClicked

    private void lbl6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl6MouseClicked
        // TODO add your handling code here:
        lblAsientoSeleccionado.setText("");
        lblAsientoSeleccionado.setText(lbl6.getText());
        lbl6.setBackground(Color.ORANGE);
        
        if(lbl1.getBackground() != Color.RED && listaAvion1.buscarAsiento(1) == null){
            lbl1.setBackground(Color.GREEN);
        }else{
            lbl1.setBackground(Color.RED);
        }
        if(lbl2.getBackground() != Color.RED && listaAvion1.buscarAsiento(2) == null){
            lbl2.setBackground(Color.GREEN);
        }else{
            lbl2.setBackground(Color.RED);
        }
        if(lbl3.getBackground() != Color.RED && listaAvion1.buscarAsiento(3) == null){
            lbl3.setBackground(Color.GREEN);
        }else{
            lbl3.setBackground(Color.RED);
        }
        if(lbl4.getBackground() != Color.RED && listaAvion1.buscarAsiento(4) == null){
            lbl4.setBackground(Color.GREEN);
        }else{
            lbl4.setBackground(Color.RED);
        }
        if(lbl5.getBackground() != Color.RED && listaAvion1.buscarAsiento(5) == null){
            lbl5.setBackground(Color.GREEN);
        }else{
            lbl5.setBackground(Color.RED);
        }
        if(lbl7.getBackground() != Color.RED && listaAvion1.buscarAsiento(7) == null){
            lbl7.setBackground(Color.GREEN);
        }else{
            lbl7.setBackground(Color.RED);
        }
        if(lbl8.getBackground() != Color.RED && listaAvion1.buscarAsiento(8) == null){
            lbl8.setBackground(Color.GREEN);
        }else{
            lbl8.setBackground(Color.RED);
        }
        if(lbl9.getBackground() != Color.RED && listaAvion1.buscarAsiento(9) == null){
            lbl9.setBackground(Color.GREEN);
        }else{
            lbl9.setBackground(Color.RED);
        }
        if(lbl10.getBackground() != Color.RED && listaAvion1.buscarAsiento(10) == null){
            lbl10.setBackground(Color.GREEN);
        }else{
            lbl10.setBackground(Color.RED);
        }
    }//GEN-LAST:event_lbl6MouseClicked

    private void lbl7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl7MouseClicked
        // TODO add your handling code here:
        lblAsientoSeleccionado.setText("");
        lblAsientoSeleccionado.setText(lbl7.getText());
        lbl7.setBackground(Color.ORANGE);
        
        if(lbl1.getBackground() != Color.RED && listaAvion1.buscarAsiento(1) == null){
            lbl1.setBackground(Color.GREEN);
        }else{
            lbl1.setBackground(Color.RED);
        }
        if(lbl2.getBackground() != Color.RED && listaAvion1.buscarAsiento(2) == null){
            lbl2.setBackground(Color.GREEN);
        }else{
            lbl2.setBackground(Color.RED);
        }
        if(lbl3.getBackground() != Color.RED && listaAvion1.buscarAsiento(3) == null){
            lbl3.setBackground(Color.GREEN);
        }else{
            lbl3.setBackground(Color.RED);
        }
        if(lbl4.getBackground() != Color.RED && listaAvion1.buscarAsiento(4) == null){
            lbl4.setBackground(Color.GREEN);
        }else{
            lbl4.setBackground(Color.RED);
        }
        if(lbl5.getBackground() != Color.RED && listaAvion1.buscarAsiento(5) == null){
            lbl5.setBackground(Color.GREEN);
        }else{
            lbl5.setBackground(Color.RED);
        }
        if(lbl6.getBackground() != Color.RED && listaAvion1.buscarAsiento(6) == null){
            lbl6.setBackground(Color.GREEN);
        }else{
            lbl6.setBackground(Color.RED);
        }
        if(lbl8.getBackground() != Color.RED && listaAvion1.buscarAsiento(8) == null){
            lbl8.setBackground(Color.GREEN);
        }else{
            lbl8.setBackground(Color.RED);
        }
        if(lbl9.getBackground() != Color.RED && listaAvion1.buscarAsiento(9) == null){
            lbl9.setBackground(Color.GREEN);
        }else{
            lbl9.setBackground(Color.RED);
        }
        if(lbl10.getBackground() != Color.RED && listaAvion1.buscarAsiento(10) == null){
            lbl10.setBackground(Color.GREEN);
        }else{
            lbl10.setBackground(Color.RED);
        }
    }//GEN-LAST:event_lbl7MouseClicked

    private void lbl8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl8MouseClicked
        // TODO add your handling code here:
        lblAsientoSeleccionado.setText("");
        lblAsientoSeleccionado.setText(lbl8.getText());
        lbl8.setBackground(Color.ORANGE);
        
        if(lbl1.getBackground() != Color.RED && listaAvion1.buscarAsiento(1) == null){
            lbl1.setBackground(Color.GREEN);
        }else{
            lbl1.setBackground(Color.RED);
        }
        if(lbl2.getBackground() != Color.RED && listaAvion1.buscarAsiento(2) == null){
            lbl2.setBackground(Color.GREEN);
        }else{
            lbl2.setBackground(Color.RED);
        }
        if(lbl3.getBackground() != Color.RED && listaAvion1.buscarAsiento(3) == null){
            lbl3.setBackground(Color.GREEN);
        }else{
            lbl3.setBackground(Color.RED);
        }
        if(lbl4.getBackground() != Color.RED && listaAvion1.buscarAsiento(4) == null){
            lbl4.setBackground(Color.GREEN);
        }else{
            lbl4.setBackground(Color.RED);
        }
        if(lbl5.getBackground() != Color.RED && listaAvion1.buscarAsiento(5) == null){
            lbl5.setBackground(Color.GREEN);
        }else{
            lbl5.setBackground(Color.RED);
        }
        if(lbl6.getBackground() != Color.RED && listaAvion1.buscarAsiento(6) == null){
            lbl6.setBackground(Color.GREEN);
        }else{
            lbl6.setBackground(Color.RED);
        }
        if(lbl7.getBackground() != Color.RED && listaAvion1.buscarAsiento(7) == null){
            lbl7.setBackground(Color.GREEN);
        }else{
            lbl7.setBackground(Color.RED);
        }
        if(lbl9.getBackground() != Color.RED && listaAvion1.buscarAsiento(9) == null){
            lbl9.setBackground(Color.GREEN);
        }else{
            lbl9.setBackground(Color.RED);
        }
        if(lbl10.getBackground() != Color.RED && listaAvion1.buscarAsiento(10) == null){
            lbl10.setBackground(Color.GREEN);
        }else{
            lbl10.setBackground(Color.RED);
        }
    }//GEN-LAST:event_lbl8MouseClicked

    private void lbl9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl9MouseClicked
        // TODO add your handling code here:
        lblAsientoSeleccionado.setText("");
        lblAsientoSeleccionado.setText(lbl9.getText());
        lbl9.setBackground(Color.ORANGE);
        
        if(lbl1.getBackground() != Color.RED && listaAvion1.buscarAsiento(1) == null){
            lbl1.setBackground(Color.GREEN);
        }else{
            lbl1.setBackground(Color.RED);
        }
        if(lbl2.getBackground() != Color.RED && listaAvion1.buscarAsiento(2) == null){
            lbl2.setBackground(Color.GREEN);
        }else{
            lbl2.setBackground(Color.RED);
        }
        if(lbl3.getBackground() != Color.RED && listaAvion1.buscarAsiento(3) == null){
            lbl3.setBackground(Color.GREEN);
        }else{
            lbl3.setBackground(Color.RED);
        }
        if(lbl4.getBackground() != Color.RED && listaAvion1.buscarAsiento(4) == null){
            lbl4.setBackground(Color.GREEN);
        }else{
            lbl4.setBackground(Color.RED);
        }
        if(lbl5.getBackground() != Color.RED && listaAvion1.buscarAsiento(5) == null){
            lbl5.setBackground(Color.GREEN);
        }else{
            lbl5.setBackground(Color.RED);
        }
        if(lbl6.getBackground() != Color.RED && listaAvion1.buscarAsiento(6) == null){
            lbl6.setBackground(Color.GREEN);
        }else{
            lbl6.setBackground(Color.RED);
        }
        if(lbl7.getBackground() != Color.RED && listaAvion1.buscarAsiento(7) == null){
            lbl7.setBackground(Color.GREEN);
        }else{
            lbl7.setBackground(Color.RED);
        }
        if(lbl8.getBackground() != Color.RED && listaAvion1.buscarAsiento(8) == null){
            lbl8.setBackground(Color.GREEN);
        }else{
            lbl8.setBackground(Color.RED);
        }
        if(lbl10.getBackground() != Color.RED && listaAvion1.buscarAsiento(10) == null){
            lbl10.setBackground(Color.GREEN);
        }else{
            lbl10.setBackground(Color.RED);
        }
    }//GEN-LAST:event_lbl9MouseClicked

    private void lbl10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl10MouseClicked
        // TODO add your handling code here:
        lblAsientoSeleccionado.setText("");
        lblAsientoSeleccionado.setText(lbl10.getText());
        lbl10.setBackground(Color.ORANGE);
        
        if(lbl1.getBackground() != Color.RED && listaAvion1.buscarAsiento(1) == null){
            lbl1.setBackground(Color.GREEN);
        }else{
            lbl1.setBackground(Color.RED);
        }
        if(lbl2.getBackground() != Color.RED && listaAvion1.buscarAsiento(2) == null){
            lbl2.setBackground(Color.GREEN);
        }else{
            lbl2.setBackground(Color.RED);
        }
        if(lbl3.getBackground() != Color.RED && listaAvion1.buscarAsiento(3) == null){
            lbl3.setBackground(Color.GREEN);
        }else{
            lbl3.setBackground(Color.RED);
        }
        if(lbl4.getBackground() != Color.RED && listaAvion1.buscarAsiento(4) == null){
            lbl4.setBackground(Color.GREEN);
        }else{
            lbl4.setBackground(Color.RED);
        }
        if(lbl5.getBackground() != Color.RED && listaAvion1.buscarAsiento(5) == null){
            lbl5.setBackground(Color.GREEN);
        }else{
            lbl5.setBackground(Color.RED);
        }
        if(lbl6.getBackground() != Color.RED && listaAvion1.buscarAsiento(6) == null){
            lbl6.setBackground(Color.GREEN);
        }else{
            lbl6.setBackground(Color.RED);
        }
        if(lbl7.getBackground() != Color.RED && listaAvion1.buscarAsiento(7) == null){
            lbl7.setBackground(Color.GREEN);
        }else{
            lbl7.setBackground(Color.RED);
        }
        if(lbl8.getBackground() != Color.RED && listaAvion1.buscarAsiento(8) == null){
            lbl8.setBackground(Color.GREEN);
        }else{
            lbl8.setBackground(Color.RED);
        }
        if(lbl9.getBackground() != Color.RED && listaAvion1.buscarAsiento(9) == null){
            lbl9.setBackground(Color.GREEN);
        }else{
            lbl9.setBackground(Color.RED);
        }
    }//GEN-LAST:event_lbl10MouseClicked

    private void btnNuevoViajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoViajeActionPerformed
        // TODO add your handling code here:
        if(listaAvion1.listaVacia() == false){
            int resp = JOptionPane.showConfirmDialog(null,"¿Está seguro que desea inicializar la lista de pasajeros?");
            
            if (JOptionPane.OK_OPTION == resp){
                try {
                    listaAvion1.limpiarLista();
                    limpiarAvion();
                    listaAvion1.verLista();
                    JOptionPane.showMessageDialog(null, "Lista inicializada con éxito.", "MENSAJE", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    Logger.getLogger(JIFAvion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "La lista no tiene pasajeros.", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnNuevoViajeActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        int dpi = 0;
        String nombrePasajero = "";
        int numeroAsiento = 0;
        
        if(!listaAvion1.listaVacia() == true){
            correlativo = 1;
            //correlativo = correlativo;
            dpi = listaAvion1.buscarCorrelativo(correlativo).dpi;
            nombrePasajero = listaAvion1.buscarCorrelativo(correlativo).nombrePasajero;
            numeroAsiento = listaAvion1.buscarCorrelativo(correlativo).numeroAsiento;
            
            if(dpi > 0 && !nombrePasajero.equals("") && numeroAsiento > 0){
                txtDPI.setText(String.valueOf(dpi));
                txtNombrePasajero.setText(nombrePasajero);
                txtNumeroAsiento.setText(String.valueOf(numeroAsiento));
                txtIngresoDpi.setText("");
                txtIngresoNombrePasajero.setText("");
                lblAsientoSeleccionado.setText("");
                
                txtIngresoDpi.setEditable(false);
                txtIngresoNombrePasajero.setEditable(false);
                btnBuscar.setEnabled(false);
                btnSiguiente.setEnabled(true);
                btnAnterior.setEnabled(true);
                btnCancelar.setEnabled(true);
                btnModificar.setEnabled(true);
                btnGuardarCambios.setEnabled(false);
                btnEliminar.setEnabled(true);
                btnGuardarLista.setEnabled(true);
                btnNuevoViaje.setEnabled(false);
                btnAgregarPasajero.setEnabled(false);
            }
        }else{
            JOptionPane.showMessageDialog(null, "La lista de pasajeros esta vacia.", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        // TODO add your handling code here:
        Nodo nodo;
        correlativo = correlativo + 1;
        
        try{
            nodo = listaAvion1.buscarCorrelativo(correlativo);
            
            if(nodo != null){
                dpi = listaAvion1.buscarCorrelativo(correlativo).dpi;
                nombrePasajero = listaAvion1.buscarCorrelativo(correlativo).nombrePasajero;
                numeroAsiento = listaAvion1.buscarCorrelativo(correlativo).numeroAsiento;
                
                txtDPI.setText(String.valueOf(dpi));
                txtNombrePasajero.setText(nombrePasajero);
                txtNumeroAsiento.setText(String.valueOf(numeroAsiento));
            }else{
                correlativo--;  //retrocedo una posicion
                JOptionPane.showMessageDialog(null, "Esta en el final de la lista. No hay mas datos que mostrar.", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            }
        }catch(Exception ex){
            System.out.println("Error: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        try{
            if(!btnBuscar.isEnabled() && btnModificar.isEnabled()){
                txtDPI.setText("");
                txtNombrePasajero.setText("");
                txtNumeroAsiento.setText("");
                
                txtIngresoDpi.setEditable(true);
                txtIngresoNombrePasajero.setEditable(true);

                btnBuscar.setEnabled(true);
                btnSiguiente.setEnabled(false);
                btnAnterior.setEnabled(false);
                btnCancelar.setEnabled(false);
                btnModificar.setEnabled(false);
                btnGuardarCambios.setEnabled(false);
                btnEliminar.setEnabled(false);
                btnGuardarLista.setEnabled(true);
                btnNuevoViaje.setEnabled(true);
                btnAgregarPasajero.setEnabled(true);
                return;
            }
            if(!btnModificar.isEnabled() && btnGuardarCambios.isEnabled()){
                txtDPI.setEditable(false);
                txtNombrePasajero.setEditable(false);
                cbAsiento.setEnabled(false);
                btnSiguiente.setEnabled(true);
                btnAnterior.setEnabled(true);
                btnModificar.setEnabled(true);
                btnEliminar.setEnabled(true);
                btnGuardarCambios.setEnabled(false);
                btnGuardarLista.setEnabled(true);
                txtNumeroAsiento.setText(String.valueOf(asientoOriginal));
                validador = true;
                cbAsiento.setSelectedIndex(0);      //aqui se lanza nuevamente el evento del combobox
            }
        }catch(Exception ex){
            System.out.println("Ocurrio una excepcion " + ex.getMessage());
        }
        
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        // TODO add your handling code here:
        Nodo nodo;
        correlativo = correlativo - 1;
        
        try{
            nodo = listaAvion1.buscarCorrelativo(correlativo);
            
            if(nodo != null){
                dpi = listaAvion1.buscarCorrelativo(correlativo).dpi;
                nombrePasajero = listaAvion1.buscarCorrelativo(correlativo).nombrePasajero;
                numeroAsiento = listaAvion1.buscarCorrelativo(correlativo).numeroAsiento;
                
                txtDPI.setText(String.valueOf(dpi));
                txtNombrePasajero.setText(nombrePasajero);
                txtNumeroAsiento.setText(String.valueOf(numeroAsiento));
            }else{
                correlativo++;      //avanzo una posicion
                JOptionPane.showMessageDialog(null, "Esta al principio de la lista. No hay más datos que mostrar.", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            }
        }catch(Exception ex){
            System.out.println("Error: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnAnteriorActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        txtDPI.setEditable(true);
        txtNombrePasajero.setEditable(true);
        cbAsiento.setEnabled(true);
        btnAnterior.setEnabled(false);
        btnSiguiente.setEnabled(false);
        btnModificar.setEnabled(false);
        btnGuardarCambios.setEnabled(true);
        btnEliminar.setEnabled(false);
        btnGuardarLista.setEnabled(false);
        
        validador = false;
        asientoOriginal = Integer.parseInt(txtNumeroAsiento.getText());
    }//GEN-LAST:event_btnModificarActionPerformed

    private void cbAsientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAsientoActionPerformed
        // TODO add your handling code here:
        int asiento = 0;
        
        if(validador == false){
            asiento = Integer.parseInt(cbAsiento.getSelectedItem().toString());
            //si el asiento seleccionado no esta ocupado
            if(asientoOcupado(asiento) == true){
                txtNumeroAsiento.setText(String.valueOf(asiento));
            }else{
                JOptionPane.showMessageDialog(null, "El asiento seleccionado ya esta ocupado.", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                cbAsiento.setSelectedIndex(0);
                txtNumeroAsiento.setText(String.valueOf(asientoOriginal));
            }
        }
        
    }//GEN-LAST:event_cbAsientoActionPerformed

    private void btnGuardarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCambiosActionPerformed
        // TODO add your handling code here:
        dpi = Integer.valueOf(txtDPI.getText().trim());
        nombrePasajero = txtNombrePasajero.getText().trim().toUpperCase();
        numeroAsiento = Integer.parseInt(txtNumeroAsiento.getText().trim());
        
        try{
            listaAvion1.actualizarElemento(correlativo, dpi, nombrePasajero, numeroAsiento);
            actualizarAsientos();
            txtDPI.setEnabled(false);
            txtNombrePasajero.setEditable(false);
            cbAsiento.setEnabled(false);
            btnModificar.setEnabled(true);
            btnEliminar.setEnabled(true);
            btnGuardarCambios.setEnabled(false);
            btnGuardarLista.setEnabled(true);
            btnAnterior.setEnabled(true);
            btnSiguiente.setEnabled(true);
            validador = true;
            cbAsiento.setSelectedIndex(0);
            //System.out.println("_____________________________________________________________________________");
            listaAvion1.verLista();
            JOptionPane.showMessageDialog(null, "¡Datos actualizados con éxito!", "MENSAJE", JOptionPane.INFORMATION_MESSAGE);
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Ocurrio un problema al actualizar la información.", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
        }
        
    }//GEN-LAST:event_btnGuardarCambiosActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        Nodo nodoSiguiente;
        Nodo nodoAnterior;
        
        try{
            int resp = JOptionPane.showConfirmDialog(null,"¿Está seguro que desea eliminar el dato?");
            
            if (JOptionPane.OK_OPTION == resp){
                numeroAsiento = listaAvion1.buscarCorrelativo(correlativo).numeroAsiento;
                listaAvion1.eliminarCorrelativo(correlativo);
                liberarAsiento(numeroAsiento);
                txtDPI.setText("");
                txtNombrePasajero.setText("");
                txtNumeroAsiento.setText("");
                actualizarCorrelativos();
                listaAvion1.verLista();
                JOptionPane.showMessageDialog(null, "¡Dato eliminado con éxito!", "MENSAJE", JOptionPane.INFORMATION_MESSAGE);

                if (!listaAvion1.listaVacia() == true) {
                    nodoSiguiente = listaAvion1.buscarCorrelativo(correlativo);
                    nodoAnterior = listaAvion1.buscarCorrelativo(correlativo - 1);
                    //verifico si el nodo siguiente tiene datos
                    if (nodoSiguiente != null) {
                        dpi = listaAvion1.buscarCorrelativo(correlativo).dpi;
                        nombrePasajero = listaAvion1.buscarCorrelativo(correlativo).nombrePasajero;
                        numeroAsiento = listaAvion1.buscarCorrelativo(correlativo).numeroAsiento;

                        txtDPI.setText(String.valueOf(dpi));
                        txtNombrePasajero.setText(nombrePasajero);
                        txtNumeroAsiento.setText(String.valueOf(numeroAsiento));
                    //verifico si el nodo anterior tiene datos
                    } else if (nodoAnterior != null) {         
                        dpi = listaAvion1.buscarCorrelativo(correlativo - 1).dpi;
                        nombrePasajero = listaAvion1.buscarCorrelativo(correlativo - 1).nombrePasajero;
                        numeroAsiento = listaAvion1.buscarCorrelativo(correlativo - 1).numeroAsiento;

                        txtDPI.setText(String.valueOf(dpi));
                        txtNombrePasajero.setText(nombrePasajero);
                        txtNumeroAsiento.setText(String.valueOf(numeroAsiento));

                        correlativo = correlativo - 1;
                    }
                }else{          //si la lista esta vacia.
                    txtDPI.setText("");
                    txtNombrePasajero.setText("");
                    txtNumeroAsiento.setText(String.valueOf(""));
                    
                    txtIngresoDpi.setEditable(true);
                    txtIngresoNombrePasajero.setEditable(true);

                    btnBuscar.setEnabled(true);
                    btnAnterior.setEnabled(false);
                    btnSiguiente.setEnabled(false);
                    btnCancelar.setEnabled(false);
                    btnModificar.setEnabled(false);
                    btnGuardarCambios.setEnabled(false);
                    btnEliminar.setEnabled(false);
                    btnNuevoViaje.setEnabled(true);
                    btnAgregarPasajero.setEnabled(true);
                    limpiarAvion();
                    System.out.println("La lista esta vacia, se eliminaron todos los elementos.");
                }
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Ocurrio un problema al eliminar el dato.", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnGuardarListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarListaActionPerformed
        // TODO add your handling code here:
        exportarDatos(numeroAvion);
    }//GEN-LAST:event_btnGuardarListaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarPasajero;
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardarCambios;
    private javax.swing.JButton btnGuardarLista;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevoViaje;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JComboBox<String> cbAsiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl10;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel lbl3;
    private javax.swing.JLabel lbl4;
    private javax.swing.JLabel lbl5;
    private javax.swing.JLabel lbl6;
    private javax.swing.JLabel lbl7;
    private javax.swing.JLabel lbl8;
    private javax.swing.JLabel lbl9;
    private javax.swing.JLabel lblAsientoSeleccionado;
    private javax.swing.JSeparator spVertical;
    private javax.swing.JTextField txtDPI;
    private javax.swing.JTextField txtIngresoDpi;
    private javax.swing.JTextField txtIngresoNombrePasajero;
    private javax.swing.JTextField txtNombrePasajero;
    private javax.swing.JTextField txtNumeroAsiento;
    // End of variables declaration//GEN-END:variables
}
