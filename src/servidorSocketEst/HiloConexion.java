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
import javax.swing.event.EventListenerList;

/**
 *
 * @author hp
 */
public class HiloConexion extends Thread {
    
    DataInputStream in;
    DataOutputStream out;
    Socket socket;
// ----------------- eventos ----------------------------
    protected EventListenerList listenerList = new EventListenerList();

    public void addMyEventListener(SocketEventListenner listener) {
        listenerList.add(SocketEventListenner.class, listener);
    }

    public void removeMyEventListener(SocketEventListenner listener) {
        listenerList.remove(SocketEventListenner.class, listener);
    }

    void fireMyEvent(DataEvent evt) {
        Object[] listeners = listenerList.getListenerList();
        for (int i = 0; i < listeners.length; i = i + 2) {
            if (listeners[i] == SocketEventListenner.class) {
                ((SocketEventListenner) listeners[i + 1]).onReader(evt);
            }
        }
    }
    
    
    // fin eventos
    public HiloConexion(Socket sc) {
        socket = sc;
    }
    
    @Override
    public void run(){
        while (true) {            
            
            try {
//                in = new DataInputStream(socket.getInputStream());
//                out = new DataOutputStream(socket.getOutputStream());
                while (true) {
                
                
                in = new DataInputStream(socket.getInputStream());
//                out = new DataOutputStream(socket.getOutputStream());
                //envio mensaje del cliente
                
                String mensaje = in.readUTF();
                DataEvent ce = new DataEvent(mensaje);
//                addMyEventListener(ce);
                fireMyEvent(ce);
//                out.writeUTF("Hola mundo desde Hilo Conexiones !!!");
                //Recibo el mensaje del servidor
//                System.out.println(mensaje);

            }
            } catch (IOException ex) {
                Logger.getLogger(HiloConexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
