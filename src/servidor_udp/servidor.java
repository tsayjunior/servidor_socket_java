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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hp
 */
public class servidor {
    public static void main(String[] args) throws IOException {
        
            final int PUERTO = 5000;
            byte[] buffer = new byte[1024];
        try {
            System.out.println("Iniciado el servidor UDP");
            DatagramSocket SocketUDP = new DatagramSocket(PUERTO);
            while(true){
                DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);
                SocketUDP.receive(peticion);
                System.out.println("Recibo la informacion del cliente");
                String mensaje = new String(peticion.getData());
                System.out.println(mensaje);

                int puertoCliente = peticion.getPort();
                InetAddress direccion= peticion.getAddress();

                mensaje = "hola mundo desde el servidor";

                buffer = mensaje.getBytes();

                DatagramPacket respuesta = new DatagramPacket(buffer, buffer.length, direccion, puertoCliente);
                System.out.println("Envio la informacion del cliente");
                SocketUDP.send(respuesta);
            
            }
            
            
            
            
        } catch (SocketException ex) {
            Logger.getLogger(servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
