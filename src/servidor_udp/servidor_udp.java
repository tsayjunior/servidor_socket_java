/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor_udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hp
 */
public class servidor_udp {
    public static void main(String[] args) {
        
            final int PUERTO = 5000;
            byte[] buffer = new byte[1024];
        try {
            System.out.println("Iniciado el servidor");
            DatagramSocket SocketUDP = new DatagramSocket(PUERTO);
            
//            DatagramPacket peticion = new DatagramSocket(buffer, buffer.length);
            
            
        } catch (SocketException ex) {
            Logger.getLogger(servidor_udp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
