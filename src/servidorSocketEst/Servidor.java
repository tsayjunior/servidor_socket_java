/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorSocketEst;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.EventListenerList;

/**
 *
 * @author Junior Javier
 */
public class Servidor implements SocketEventListenner {

    public Map<Integer, Socket> Clientes = new HashMap<Integer, Socket>();

//    protected EventListenerList listenerList = new EventListenerList();
    public void correrServidor() {
        ServerSocket servidor;
        Socket socket;

        try {
            servidor = new ServerSocket(5000);
            System.out.println("**********servidor iniciado*************");

            HiloConexiones conexiones = new HiloConexiones(servidor);
            conexiones.addMyEventListener(this);
//            conexiones.addMyEventListener(new SocketEventListenner() {
//
//            });
            conexiones.start();
//            conexiones.addMyEventListener(new ConnectEvent(servidor));
//            conexiones.addMyEventListener(new MyEventListener() {
//                public void myEventOccurred(MyEvent evt) {
//                  System.out.println("fired");
//                }
//              });

        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void onConnected(ConnectEvent evt) {

        System.out.println("entra a onConnected");
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onReader(DataEvent evt) {
        System.out.println("entra a onReader " + evt.sendMessage());
        byte[] buffer = { /* tus datos aquí */};
        for (Socket socket : Clientes.values()) {
            try {
                OutputStream outputStream = socket.getOutputStream();
                
                outputStream.write(buffer);
            } catch (IOException e) {
                // manejar excepción
            }
        }
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void myEventOccurred(ConnectEvent evt) {
        System.out.println("entra a myEventOccurred, aqui debe añadir al hasmap");
        int aux = Clientes.size() +1;
        Clientes.put(aux, evt.sendSocket());
        System.out.println("aux " + aux);
        HiloConexion hc2 = new HiloConexion(evt.sendSocket());
        hc2.addMyEventListener(this);
        hc2.start();
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
