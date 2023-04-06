/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_sockets_ddr_7;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hp
 */
public class Servidor {
    
    
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(5000);
            Socket sc;
            
            System.out.println("Servidor Iniciado");
            
            while (true) {                
                sc = server.accept();
                
                DataInputStream in = new DataInputStream(sc.getInputStream());
                DataOutputStream out = new DataOutputStream(sc.getOutputStream());
                
                out.writeUTF("Indica tu nombre");
                String nombreCliente = in.readUTF();
                
                ServidorHilo hilo= new ServidorHilo(in, out, nombreCliente);
                hilo.start();
                
                System.out.println("Creada la conexion con el cliente " + nombreCliente);
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
