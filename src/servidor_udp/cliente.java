/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor_udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hp
 */
public class cliente {
    
    public static void main(String[] args) {
            final int PUERTO_SERVIDOR = 5000;
            byte[] buffer = new byte[1024];
        try {
            
            InetAddress direccionServidor = InetAddress.getByName("localhost");
            DatagramSocket socketUdp = new DatagramSocket();
            String mensaje = "Hola mundo desde el cliente";
               
            buffer = mensaje.getBytes();
            DatagramPacket pregunta = new DatagramPacket(buffer, buffer.length, direccionServidor, PUERTO_SERVIDOR);
            System.out.println("Envio el datagrama");
            socketUdp.send(pregunta);
            
            DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);
            socketUdp.receive(peticion);
            System.out.println("Recibo la Peticion"); 
            mensaje = new String(peticion.getData());
            System.out.println(mensaje);
            
            socketUdp.close();
            
        } catch (UnknownHostException ex) {
            Logger.getLogger(cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SocketException ex) {
            Logger.getLogger(cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    }
}
