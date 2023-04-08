/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_socket_marcadores_gas;

//import ejercicio_sockets_ddr_3.*;
//import java.io.DataInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hp
 */
public class Cliente extends Observable implements Runnable{
    
    private int puerto;
    private Socket sc;
            
    public Cliente(int puerto) {
        this.puerto = puerto;
    }


    @Override
    public void run() {
        final String HOST = "127.0.0.1";
        
            DataInputStream dis;
            
        try {
            Socket sc = new Socket(HOST, puerto);
            dis = new DataInputStream(sc.getInputStream());
            System.out.println("entra a cliente recien inicializado");
            System.out.println("lego de dis.readutf()");
            String nombre;
            double valor;
            
            while (true) {                
                
                nombre = dis.readUTF();
                
                this.setChanged();
                this.notifyObservers(nombre);
                this.clearChanged();
                
                valor = dis.readDouble();
                this.setChanged();
                this.notifyObservers(valor);
                this.clearChanged();
            }
            
        } catch (IOException ex) {
            Logger.getLogger(serviidor_tcp.Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void sendMessageToServe(){
        
        DataOutputStream out;
//        out = new DataOutputStream(sc.getOutputStream());
    }
}
