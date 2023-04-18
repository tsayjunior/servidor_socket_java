/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorSocketEst;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Junior Javier
 */
public class Cliente {
    
    private Socket sc;
    DataInputStream in;
    DataOutputStream out;

    public Cliente() {
        try {
            this.sc = new Socket("127.0.0.1", 5000);
            System.out.println("entra a constructor cliente");
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    public void initCliente(){
        try {
            in = new DataInputStream(sc.getInputStream());
            out = new DataOutputStream(sc.getOutputStream());
            System.out.println("entra a init cliente");
            while (true) {                
                
            //envio mensaje del cliente
            out.writeUTF("Hola mundo desde el cliente !!!");
            //Recibo el mensaje del servidor
            System.out.println("Antes de recibir mensaje");

            String mensaje = in.readUTF();
            System.out.println("despues de recibir mensaje");
//            System.out.println(mensaje);
            }
        } catch (IOException ex) {
            Logger.getLogger(ejercicio_socket_marcadores_gas.Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public static void main(String[] args) {
        Cliente c = new Cliente();
        c.initCliente();
        Cliente c2 = new Cliente();
        c2.initCliente();
    }
}
