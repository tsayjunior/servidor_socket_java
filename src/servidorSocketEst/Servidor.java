/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorSocketEst;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Junior Javier
 */
public class Servidor {
    public static Map<Integer, Socket> Clientes = new HashMap<Integer, Socket>();
    
    public static void correrServidor(){
        ServerSocket servidor;
        Socket socket;
        
        try {
            servidor = new ServerSocket(5000);
            System.out.println("**********servidor iniciado*************");
            
            HiloConexiones conexiones = new HiloConexiones(servidor);
            conexiones.start();
            conexiones.addMyEventListener(new ConnectEvent(servidor));
//            conexiones.addMyEventListener(new MyEventListener() {
//                public void myEventOccurred(MyEvent evt) {
//                  System.out.println("fired");
//                }
//              });
            
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    // prueba 
    public void myEventOccurred(ConnectEvent evt) {
            System.out.println("fired");
    }
    
//    public void escuchador(){
//        MyClass c = new MyClass();
//        c.addMyEventListener(new MyEventListener() {
//        public void myEventOccurred(MyEvent evt) {
//            System.out.println("fired");
//          }
//        });
//    }
    public static void main(String[] argv) throws Exception {
    Servidor c = new Servidor();
//    c.addMyEventListener(new MyEventListener() {
//      public void myEventOccurred(MyEvent evt) {
//        System.out.println("fired");
//      }
//    });
  }
}
