/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviidor_tcp;

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
public class Serviidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("hola");
        ServerSocket servidor = null;
        Socket sc= null;
        final int PUERTO = 5000;
        DataInputStream in;
        DataOutputStream out;

        try {
            servidor = new ServerSocket(PUERTO);
            System.out.println("Servidor Iniciado");
            while(true){
                sc = servidor.accept();//este metodo se queda a la espera, esperando en esa linea, no ejecutara nada mas, 
                //hasta que venga algo
                //esto que devuelve es el socket del cliente, el socket del cliente es este
                System.out.println("cliente Conectado");
                in = new DataInputStream(sc.getInputStream());
                out = new DataOutputStream(sc.getOutputStream());
                
                //leo el mensaje que me envia
                String mensaje = in.readUTF(); //esto se queda a la espera a que el cliente envie algo
                
                System.out.println(mensaje);
                out.writeUTF("hola mundo desde el servidor !!");
                
                sc.close(); //sierro el servidor del cliente
                System.out.println("cliente desconectado");

            }
        } catch (IOException ex) {
            Logger.getLogger(Serviidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
