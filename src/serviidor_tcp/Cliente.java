/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviidor_tcp;

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
public class Cliente {
    
    public static void main(String[] args) {
            final String HOST = "127.0.0.1";
            final int PUERTO = 5000;
            DataInputStream in;
            DataOutputStream out;
            
        try {
            Socket sc = new Socket(HOST, PUERTO);
            in = new DataInputStream(sc.getInputStream());
            out = new DataOutputStream(sc.getOutputStream());
            
            //envio mensaje del cliente
            out.writeUTF("Hola mundo desde el cliente !!!");
            //Recibo el mensaje del servidor
            String mensaje = in.readUTF();
            System.out.println(mensaje);
            
            sc.close();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
