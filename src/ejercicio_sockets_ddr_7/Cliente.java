/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_sockets_ddr_7;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hp
 */
public class Cliente {
    
    public static void main(String[] args) {
        
        try {
            Scanner sn = new Scanner(System.in);
            sn.useDelimiter("\n");
            Socket sc = new Socket("127.0.0.1", 5000);
            
            DataInputStream in = new DataInputStream(sc.getInputStream());
            DataOutputStream out = new DataOutputStream(sc.getOutputStream());
            
            String mensaje = in.readUTF();
            System.out.println(mensaje);
            
            String nombre = sn.next();
            out.writeUTF(nombre);
               
            ClienteHilo hilo = new ClienteHilo(in, out);
            hilo.start();
            hilo.join();
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
