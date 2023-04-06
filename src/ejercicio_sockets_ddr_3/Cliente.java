/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_sockets_ddr_3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hp
 */
public class Cliente implements Runnable{
    
    
    private String host;
    private int puerto;
    private String mensaje;

    public Cliente(int puerto, String mensaje) {
        this.host = "127.0.0.1";
        this.puerto = puerto;
        this.mensaje = mensaje;
    }

    public Cliente(String host, int puerto, String mensaje) {
        this.host = host;
        this.puerto = puerto;
        this.mensaje = mensaje;
    }
    
    

    @Override
    public void run() {
//        final String HOST = "127.0.0.1"1;
//            final int PUERTO = 5000;
//            DataInputStream in;
            DataOutputStream out;
            
        try {
            Socket sc = new Socket(host, puerto);
////            in = new DataInputStream(sc.getInputStream());
            out = new DataOutputStream(sc.getOutputStream());
            
            //envio mensaje del cliente
            out.writeUTF(mensaje);
            //Recibo el mensaje del servidor
//            String mensaje = in.readUTF();
//            System.out.println(mensaje);
//            
            sc.close();
        } catch (IOException ex) {
            Logger.getLogger(serviidor_tcp.Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
